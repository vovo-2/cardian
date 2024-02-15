import { Accordion, Flowbite } from "flowbite-react";
import { AccordionTheme } from "../../../themes/AccordionTheme";
import EntireCategoryCardTransactionStore from "../../../store/EntireCategoryCardTransactionStore";
import CardTransactionMonthlyList from "../../CardTransaction/CardTransactionMonthlyList";
import {
  formatPrice,
  formatPriceToPercentage,
} from "../../../utils/formatUtils";
import MonthlyCategoryInfoStore from "../../../store/MonthlyCategoryInfoStore";
import { axios } from "../../../api";
import useAuthStore from "../../../store/AuthStore";
import { useState } from "react";

export default function ACategoryTransactionList() {
  const { categoryConsumeList, entireCategoryConsume } =
    EntireCategoryCardTransactionStore();
  const { memberId } = useAuthStore();

  const { selectedMonth } = MonthlyCategoryInfoStore();

  const [monthlyTransactionDetailsList, setMonthlyTransactionDetailsList] =
    useState([]);

  function handleClick(selectedCategoryName: string) {
    const url = `/statistic/${memberId}/${selectedMonth}/${selectedCategoryName}/CategoryTransaction`;
    axios.get(url).then(({ data }) => {
      setMonthlyTransactionDetailsList(data.monthlyTransactionDetailsList);
    });
  }

  return (
    <div className="">
      <Flowbite theme={{ theme: AccordionTheme }}>
        <Accordion className="" collapseAll>
          {categoryConsumeList &&
            categoryConsumeList.map((item, idx) => (
              <Accordion.Panel key={idx}>
                <Accordion.Title className="">
                  <div
                    className="flex w-full mx-2"
                    onClick={() => handleClick(item.categoryName)}
                  >
                    {/* 카테고리 명, 총 이용내역 대비 해당 카테고리 비율 */}
                    <div className="w-1/5">
                      <div className="">{item.categoryName}</div>
                      <div className="text-xs text-gray">
                        {`${formatPriceToPercentage(
                          item.categoryConsume,
                          entireCategoryConsume
                        )}%`}
                      </div>
                    </div>
                    {/* 카테고리 명, 총 이용내역 대비 해당 카테고리 비율 끝 */}

                    {/* 해당 카테고리 이용 금액 */}
                    <div className="w-4/5 text-end my-auto mr-5">
                      {formatPrice(item.categoryConsume)}
                    </div>
                  </div>
                  {/* 해당 카테고리 이용 금액 끝 */}
                </Accordion.Title>
                <Accordion.Content className="">
                  {/* month, monthlyTransactionDetailsList */}
                  {monthlyTransactionDetailsList && (
                    <CardTransactionMonthlyList
                      key={selectedMonth}
                      month={selectedMonth}
                      monthlyTransactionDetailsList={
                        monthlyTransactionDetailsList
                      }
                    />
                  )}
                </Accordion.Content>
              </Accordion.Panel>
            ))}
        </Accordion>
      </Flowbite>
    </div>
  );
}
