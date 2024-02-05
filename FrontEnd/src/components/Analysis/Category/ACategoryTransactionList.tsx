import { Accordion } from "flowbite-react";
import { AccordionTheme, Accordiontheme } from "../../../themes/AccordionTheme";

import { axios } from "../../../api";
import { useEffect } from "react";
import EntireCategoryCardTransactionStore from "../../../store/EntireCategoryCardTransactionStore";
import CategoryConsumeStore from "../../../store/CategoryConsumeStore";
import CardTransactionMonthlyList from "../../CardTransaction/CardTransactionMonthlyList";

export default function ACategoryTransactionList() {
  const { categoryEntireTransactionList, setCategoryEntireTransactionList } =
    EntireCategoryCardTransactionStore();

  const { consumeLabelList } = CategoryConsumeStore();

  const member_id = 1;

  const url = `/statistic/${member_id}/CategoryTransaction`;

  useEffect(() => {
    axios.get(url).then(({ data }) => {
      console.log(data.categoryEntireTransactionList);
      setCategoryEntireTransactionList(data.categoryEntireTransactionList);
    });
  }, []);

  return (
    <div className="overflow-y-auto scrollbar-hide  ">
      <Accordion theme={AccordionTheme}>
        {categoryEntireTransactionList &&
          categoryEntireTransactionList.map((item, idx) => (
            <Accordion.Panel key={idx}>
              <Accordion.Title className="">
                <div className=" ">{item.categoryName}</div>
              </Accordion.Title>
              <Accordion.Content className="border-none m-0 px-1">
                {/* month, monthlyTransactionDetailsList */}
                {item.categoryMonthlyTransactionList.length > 0 &&
                  item.categoryMonthlyTransactionList.map((data) => {
                    return (
                      <CardTransactionMonthlyList
                        key={data.month}
                        month={data.month}
                        monthlyTransactionDetailsList={
                          data.monthlyTransactionDetailsList
                        }
                      />
                    );
                  })}
              </Accordion.Content>
            </Accordion.Panel>
          ))}
      </Accordion>
    </div>
  );
}
