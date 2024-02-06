import CategoryConsumeStore from "../../../store/CategoryConsumeStore";
import { useEffect } from "react";

import { Chart as ChartJS, ArcElement, Tooltip, Legend } from "chart.js";
import { Pie } from "react-chartjs-2";
import ChartDataLabels from "chartjs-plugin-datalabels";
ChartJS.register(ArcElement, Tooltip, Legend, ChartDataLabels);

export default function ACategoryGraph() {
  const { consumeDataList, consumeLabelList, selectedMonth, colorList } =
    CategoryConsumeStore();
  useEffect(() => {}, [selectedMonth]);

  const data = {
    labels: consumeLabelList,
    datasets: [
      {
        data: consumeDataList,
        backgroundColor: colorList,
        borderColor: colorList,
        borderWidth: 1,
      },
    ],
  };

  const options: object = {
    responsive: true,
    plugins: {
      legend: {
        display: false, //  위에 라벨 삭제
      },

      datalabels: {
        color: ["#fff"],
        formatter: function () {
          return null; //data가 10 미만이면 숫자 값은 출력되지 않습니다.
        },
      },
    },
  };

  return (
    <div className="mx-20 mt-10 mb-10">
      <Pie options={options} data={data} />
    </div>
  );
}
