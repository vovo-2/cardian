import { axios } from "../../../api";
import { useEffect, useState } from "react";
import CategoryConsumeStore from "../../../store/CategoryConsumeStore";
import { formatPrice } from "../../../utils/formatUtils";
import { Button } from "flowbite-react";
import { IoMdArrowDropleft, IoMdArrowDropright } from "react-icons/io";

export default function ACategoryInfo() {
  const {
    categoryMonthlyConsumeList,
    setCategoryMonthlyConsumeList,
    selectedMonth,
    setSelectedMonth,
    setConsumeDataList,
    setConsumeLabelList,
  } = CategoryConsumeStore();

  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    const member_id = 1;
    const url = `/statistic/${member_id}/CategoryMonthlyConsume`;

    axios.get(url).then(({ data }) => {
      setCategoryMonthlyConsumeList(data.categoryMonthlyConsumeList);
    });
  }, []);

  if (isLoading == true && categoryMonthlyConsumeList.length > 0) {
    setIsLoading(false);
  }

  useEffect(() => {
    if (isLoading == false) {
      const dataList: number[] = [];
      const labelList: string[] = [];

      categoryMonthlyConsumeList[
        selectedMonth - 1
      ].categoryMonthlyConsumeDetails.map((item) => {
        dataList.push(item.monthlyConsumePerCategory);
        labelList.push(item.categoryName);
      });

      setConsumeDataList(dataList);
      setConsumeLabelList(labelList);
    }
  }, [isLoading]);

  useEffect(() => {
    if (isLoading == true) return;
    const dataList: number[] = [];
    const labelList: string[] = [];

    categoryMonthlyConsumeList[
      selectedMonth - 1
    ].categoryMonthlyConsumeDetails.map((item) => {
      dataList.push(item.monthlyConsumePerCategory);
      labelList.push(item.categoryName);
    });

    setConsumeDataList(dataList);
    setConsumeLabelList(labelList);
  }, [selectedMonth]);

  function handleLeftClick() {
    // --
    if (selectedMonth > 1) {
      setSelectedMonth(selectedMonth - 1);
    }
  }

  function handleRightClick() {
    // ++
    if (selectedMonth < 12) {
      setSelectedMonth(selectedMonth + 1);
    }
  }
  return (
    <div>
      <div className="flex my-auto">
        <div>
          <Button
            onClick={handleLeftClick}
            color="gray"
            className="border-none"
            disabled={selectedMonth == 1}
          >
            <IoMdArrowDropleft size={30} color="blue" />
          </Button>
        </div>

        <div className="my-auto text-xl">{selectedMonth}월</div>

        <Button
          onClick={handleRightClick}
          color="gray"
          className="border-none"
          disabled={selectedMonth == 12}
        >
          <IoMdArrowDropright size={30} color="blue" />
        </Button>
      </div>
      <div className="text-2xl font-bold ml-3">
        {categoryMonthlyConsumeList[selectedMonth - 1] && (
          <div>
            {formatPrice(
              categoryMonthlyConsumeList[selectedMonth - 1].monthlyEntireConsume
            )}
          </div>
        )}
      </div>
    </div>
  );
}
