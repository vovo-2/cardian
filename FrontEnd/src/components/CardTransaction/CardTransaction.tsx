import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { axios } from "../../api";

import CardTransactionMonthlyList from "./CardTransactionMonthlyList";

export default function CardTransaction() {
  const cardId = useParams().card_id;
  const [transactionList, setTransactionList] = useState([]);

  useEffect(() => {
    axios.get(`/card/${cardId}/transaction`).then(({ data }) => {
      setTransactionList(data.yearTransactionDetailsList);
    });
  }, [cardId]);

  return (
    <div className="overflow-y-scroll scrollbar-hide pb-[100px]">
      {transactionList.map(({ month, monthlyTransactionDetailsList }) => {
        return (
          <CardTransactionMonthlyList
            key={month}
            month={month}
            monthlyTransactionDetailsList={monthlyTransactionDetailsList}
          />
        );
      })}
    </div>
  );
}
