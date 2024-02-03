import YearTransactionStore from "../../store/YearTransactionStore";

import { Accordion } from "flowbite-react";
import { AccordionTheme } from "../../themes/AccordionTheme";

import { axios } from "../../api";
import EntireMonthlyCardTransactionStore from "../../store/EntireMonthlyCardTransactionStore";
import CardTransactionMonthlyList from "../CardTransaction/CardTransactionMonthlyList";
import { useEffect } from "react";
import {
  CardTransactionMonthlyListProps,
  MonthlyTransactionDetails,
} from "../../interface/CardTransactionInterface";

export default function YearTransactionList() {
  const { monthlyConsumeAmount } = YearTransactionStore();
  const {
    entireMonthlyTransactionList,
    setMemberId,
    setEntireMonthlyTransactionList,
  } = EntireMonthlyCardTransactionStore();

  const member_id = 1;
  const url = `/statistic/${member_id}/EntireCardTransaction`;

  useEffect(() => {
    axios.get(url).then((data) => {
      setMemberId(member_id);

      const arr: CardTransactionMonthlyListProps[] = [];
      data.data.monthlyTransactionDetailsWithMonthList.map(
        (item: {
          month: number;
          dailyTransactionDetailsWithDayList: MonthlyTransactionDetails[];
        }) => {
          const reTypeObj: CardTransactionMonthlyListProps = {
            month: item.month,
            monthlyTransactionDetailsList:
              item.dailyTransactionDetailsWithDayList,
          };

          arr.push(reTypeObj);
        }
      );

      setEntireMonthlyTransactionList(arr);
    });
  }, []);
  console.log(entireMonthlyTransactionList);
  return (
    <div className="overflow-y-auto scrollbar-hide  ">
      <Accordion theme={AccordionTheme}>
        {monthlyConsumeAmount &&
          monthlyConsumeAmount.map((item, idx) => (
            <Accordion.Panel key={idx + 1}>
              <Accordion.Title className="">
                <div className=" ">{idx + 1}월</div>
                <div className="">
                  <span className="">{item}원</span>
                </div>
              </Accordion.Title>
              <Accordion.Content className="border-none m-0 px-1">
                {/* month, monthlyTransactionDetailsList */}
                {entireMonthlyTransactionList[idx].monthlyTransactionDetailsList
                  .length > 0 && (
                  <CardTransactionMonthlyList
                    key={entireMonthlyTransactionList[idx].month}
                    month={entireMonthlyTransactionList[idx].month}
                    monthlyTransactionDetailsList={
                      entireMonthlyTransactionList[idx]
                        .monthlyTransactionDetailsList
                    }
                  />
                )}
              </Accordion.Content>
            </Accordion.Panel>
          ))}
      </Accordion>
    </div>
  );
}
