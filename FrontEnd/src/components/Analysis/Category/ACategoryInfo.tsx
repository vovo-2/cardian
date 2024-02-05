import { axios } from "../../../api";
import { useEffect, useState } from "react";
import CategoryConsumeStore from "../../../store/CategoryConsumeStore";
import { formatPrice } from "../../../utils/formatUtils";

export default function ACategoryInfo() {
  const {
    categoryMonthlyConsumeList,
    setCategoryMonthlyConsumeList,
    selectedMonth,
    setSelectedMonth,
    consumeDataList,
    consumeLabelList,
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

  return (
    <div>
      <div>{selectedMonth}월</div>
      <div>
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
