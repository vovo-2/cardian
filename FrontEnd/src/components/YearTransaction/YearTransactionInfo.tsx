import React from "react";

import { axios } from "../../api";
import { useState, useEffect } from "react";
import YearTransactionStore from "../../store/YearTransactionStore";

export default function YearTransactionInfo() {
  const {
    monthlyConsumeAmount,
    yearConsumeAmount,
    setYearConsumeAmount,
    setMonthlyConsumeAmount,
  } = YearTransactionStore();

  const [year, setYear] = useState<number>(0);

  const priceFormatter = new Intl.NumberFormat("ko-KR");

  useEffect(() => {
    setYear(new Date().getFullYear());

    const member_id = 1;
    const url = `/statistic/${member_id}`;
    axios.get(url).then((data) => {
      setYearConsumeAmount(data.data.yearConsumeAmount.yearConsumeAmount);

      const monthlyObj = data.data.yearConsumeAmount.monthlyConsumeAmount;
      const monthlyArray = [];

      for (const key in monthlyObj) {
        monthlyArray.push(monthlyObj[key]);
      }
      setMonthlyConsumeAmount(monthlyArray);
    });
  }, []);

  return (
    <div className="">
      <div className="text-xl mb-2">{year}년</div>
      <div className="font-bold text-3xl">
        {priceFormatter.format(yearConsumeAmount)}원
      </div>
    </div>
  );
}
