import { axios } from "../../../api";
import { useEffect } from "react";
import { formatPrice } from "../../../utils/formatUtils";
import { Button } from "flowbite-react";
import { IoMdArrowDropleft, IoMdArrowDropright } from "react-icons/io";

import { CiCirclePlus, CiCircleMinus } from "react-icons/ci";
import MonthlyCategoryInfoStore from "../../../store/MonthlyCategoryInfoStore";
import EntireCategoryCardTransactionStore from "../../../store/EntireCategoryCardTransactionStore";

export default function ACategoryInfo() {
  const {
    selectedMonth,
    selectedTopNCategory,
    setSelectedMonth,
    setSelectedTopNCategory,
    setNowMonthConsumeList,
    setLastMonthConsumeList,
    setNowMonthLabelList,
    setIsLoading,
  } = MonthlyCategoryInfoStore();

  const {
    entireCategoryConsume,
    setMonth,
    setEntireCategoryConsume,
    setCategoryTransactionList,
  } = EntireCategoryCardTransactionStore();

  useEffect(() => {
    const member_id = 1;
    const nowCategoryNameList: string[] = [];
    const nowConsumeList: number[] = [];
    const lastConsumeList: (number | undefined)[] = [];

    setIsLoading(true);
    // 이번달 이용내역 통신 로직
    let url = `/statistic/${member_id}/${selectedMonth}/categoryTransaction`;
    axios
      .get(url)
      .then(({ data }) => {
        setMonth(data.month);
        setEntireCategoryConsume(data.entireCategoryConsume);
        setCategoryTransactionList(data.categoryTransactionList);

        data.categoryTransactionList.map(
          (item: { categoryName: string; categoryConsume: number }) => {
            nowCategoryNameList.push(item.categoryName);
            nowConsumeList.push(item.categoryConsume);
          }
        );

        setNowMonthLabelList(nowCategoryNameList);
        setNowMonthConsumeList(nowConsumeList);
        // 이번달 이용내역 통신 로직 종료
      })
      .finally(
        () => {
          // 저번달 카테고리별 총 이용내역 통신 로직
          if (selectedMonth - 1 > 0) {
            url = `/statistic/${member_id}/${
              selectedMonth - 1
            }/categoryTransaction`;
            axios.get(url).then(({ data }) => {
              const lastMonthObj: Map<string, number> = new Map<
                string,
                number
              >();

              data.categoryTransactionList.map(
                (item: { categoryName: string; categoryConsume: number }) => {
                  lastMonthObj.set(item.categoryName, item.categoryConsume);
                }
              );

              nowCategoryNameList.map((label) => {
                lastConsumeList.push(lastMonthObj.get(label));
              });
              setLastMonthConsumeList(lastConsumeList);
            });
          }
        }
        // 저번달 카테고리별 총 이용내역 통신 로직 종료
      )
      .finally(() => {
        setIsLoading(false);
      });
  }, [selectedMonth]);

  return (
    <div>
      {/* 월 선택  */}
      <div className="flex my-auto justify-center">
        <div>
          <Button
            onClick={() => setSelectedMonth(selectedMonth - 1)}
            color="gray"
            className="border-none"
            disabled={selectedMonth == 1}
          >
            <IoMdArrowDropleft
              size={30}
              color="blue"
              className="hover:scale-125"
            />
          </Button>
        </div>

        <div className="my-auto text-xl">{selectedMonth}월</div>

        <Button
          onClick={() => {
            setSelectedMonth(selectedMonth + 1);
          }}
          color="gray"
          className="border-none"
          disabled={selectedMonth == 12}
        >
          <IoMdArrowDropright
            size={30}
            color="blue"
            className="hover:scale-125"
          />
        </Button>
      </div>
      {/* 월 선택 끝 */}

      {/* 해당 월 총 소비 금액 */}
      <div className="text-3xl font-bold ml-3 text-center">
        <div>{formatPrice(entireCategoryConsume)}</div>
      </div>
      {/* 해당 월 총 소비 금액 끝 */}

      {/* 상위 N개 카테고리 선택 */}
      <div className="my-auto mt-3 flex justify-center mx-auto">
        <div className="">
          <Button
            onClick={() => setSelectedTopNCategory(selectedTopNCategory - 1)}
            color="gray"
            className="border-none"
            disabled={selectedTopNCategory == 1}
          >
            <CiCircleMinus
              size={25}
              color="blue"
              className="hover:scale-125 "
            />
          </Button>
        </div>

        <div className="flex ">
          <div className="my-auto">상위</div>
          <div className="rounded-full border-2 w-10 h-10 border-blue my-auto flex mx-2 justify-center items-center font-bold">
            {selectedTopNCategory}
          </div>
          <div className="my-auto">개</div>
        </div>

        <div className="">
          <Button
            onClick={() => setSelectedTopNCategory(selectedTopNCategory + 1)}
            color="gray"
            className="border-none"
            disabled={selectedTopNCategory == 12}
          >
            <CiCirclePlus size={25} color="blue" className="hover:scale-125" />
          </Button>
        </div>
      </div>
      {/* 상위 N개 카테고리 선택 끝*/}
    </div>
  );
}
