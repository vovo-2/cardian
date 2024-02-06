import { Accordion, Flowbite } from "flowbite-react";
import { AccordionTheme } from "../../../themes/AccordionTheme";

import { axios } from "../../../api";
import { useEffect } from "react";
import EntireCategoryCardTransactionStore from "../../../store/EntireCategoryCardTransactionStore";
import CategoryConsumeStore from "../../../store/CategoryConsumeStore";
import CardTransactionMonthlyList from "../../CardTransaction/CardTransactionMonthlyList";
import {
  formatPrice,
  formatPriceToPercentage,
} from "../../../utils/formatUtils";

export default function ACategoryTransactionList() {
  const { categoryEntireTransactionList, setCategoryEntireTransactionList } =
    EntireCategoryCardTransactionStore();

  const {
    selectedMonth,
    colorList,
    consumeDataList,
    categoryMonthlyConsumeList,
  } = CategoryConsumeStore();

  const member_id = 1;

  const url = `/statistic/${member_id}/CategoryTransaction`;

  useEffect(() => {
    axios.get(url).then(({ data }) => {
      setCategoryEntireTransactionList(data.categoryEntireTransactionList);
    });
  }, []);

  return (
    <div className="">
      <Flowbite theme={{ theme: AccordionTheme }}>
        <Accordion className="" collapseAll>
          {categoryEntireTransactionList &&
            categoryEntireTransactionList.map((item, idx) => (
              <Accordion.Panel key={idx}>
                <Accordion.Title className="">
                  <div className="flex w-full ">
                    <div
                      className={
                        colorList[idx]
                          ? `bg-[${colorList[idx]}] rounded-full w-5 h-5 my-auto`
                          : ""
                      }
                    ></div>
                    <div className="w-1/5">
                      <div className="">{item.categoryName}</div>
                      <div className="text-xs text-gray">
                        {formatPriceToPercentage(
                          consumeDataList[idx],
                          categoryMonthlyConsumeList[selectedMonth - 1]
                            .monthlyEntireConsume
                        )}
                      </div>
                    </div>
                    <div className="w-4/5 text-end my-auto mr-2">
                      {formatPrice(consumeDataList[idx])}
                    </div>
                  </div>
                </Accordion.Title>
                <Accordion.Content className="">
                  {/* month, monthlyTransactionDetailsList */}
                  {item.categoryMonthlyTransactionList.length > 0 &&
                    item.categoryMonthlyTransactionList.map((data) => {
                      if (data.month == selectedMonth) {
                        return (
                          <CardTransactionMonthlyList
                            key={data.month}
                            month={data.month}
                            monthlyTransactionDetailsList={
                              data.monthlyTransactionDetailsList
                            }
                          />
                        );
                      }
                    })}
                </Accordion.Content>
              </Accordion.Panel>
            ))}
        </Accordion>
      </Flowbite>
    </div>
  );
}
