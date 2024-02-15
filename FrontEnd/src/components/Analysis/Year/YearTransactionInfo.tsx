import { axios } from "../../../api";
import { useState, useEffect } from "react";
import YearTransactionStore from "../../../store/YearTransactionStore";
import useAuthStore from "../../../store/AuthStore";

export default function YearTransactionInfo() {
  const { yearConsumeAmount, setYearConsumeAmount, setMonthlyConsumeAmount } =
    YearTransactionStore();

  const [year, setYear] = useState<number>(0);
  const { memberId } = useAuthStore();

  const priceFormatter = new Intl.NumberFormat("ko-KR");

  useEffect(() => {
    setYear(new Date().getFullYear());

    const url = `/statistic/${memberId}`;
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
