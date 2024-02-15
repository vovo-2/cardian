import { useEffect } from "react";

import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement,
} from "chart.js";

import { Bar } from "react-chartjs-2";
import ChartDataLabels from "chartjs-plugin-datalabels";
import MonthlyCategoryInfoStore from "../../../store/MonthlyCategoryInfoStore";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,

  ArcElement,
  ChartDataLabels
);

export default function ACategoryGraph() {
  const {
    selectedMonth,
    selectedTopNCategory,
    nowMonthConsumeList,
    nowMonthLabelList,

    lastMonthConsumeList,
    colorList,
  } = MonthlyCategoryInfoStore();

  useEffect(() => {}, [lastMonthConsumeList]);

  const data = {
    labels: nowMonthLabelList.slice(0, selectedTopNCategory),
    datasets: [
      {
        label: selectedMonth - 1 > 0 ? `${selectedMonth - 1}월 달` : "",
        data:
          selectedMonth - 1 > 0
            ? lastMonthConsumeList.slice(0, selectedTopNCategory)
            : [],
        backgroundColor: colorList[8],
      },

      {
        label: `${selectedMonth}월 달`,
        data: nowMonthConsumeList.slice(0, selectedTopNCategory),
        backgroundColor: colorList[4],
      },
    ],
  };

  const options: object = {
    responsive: true,
    plugins: {
      legend: {
        display: true, //  위에 라벨 삭제
      },

      datalabels: {
        color: colorList,
        formatter: function () {
          return null; //data가 10 미만이면 숫자 값은 출력되지 않습니다.
        },
      },
    },
    scales: {
      y: {
        ticks: {
          display: false,
          beginAtZero: true,
        },
        grid: {
          drawBorder: false,
          display: false,
        },
      },
    },
  };

  return (
    <div className="">
      <Bar options={options} data={data} />
    </div>
  );
}
