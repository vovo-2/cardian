import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Bar } from "react-chartjs-2";
import YearTransactionStore from "../../store/YearTransactionStore";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

export default function YearGraph() {
  const { monthlyConsumeAmount } = YearTransactionStore();

  const options = {
    responsive: true,
    // 라벨 숨기기
    plugins: {
      legend: {
        display: false,
      },
    },

    // 차트 내부 그리드 지우기
    maintainAspectRatio: false,
    scales: {
      x: {
        beginAtZero: true,
        grid: {
          color: "transparent",
        },
      },
      y: {
        beginAtZero: true,
        grid: {
          lineWidth: 0,
          borderWidth: 105,
          color: "transparent",
        },
      },
    },
  };

  const labels = [
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월",
  ];

  const data = {
    labels,
    datasets: [
      {
        data: monthlyConsumeAmount,
        backgroundColor: "rgba(255, 99, 132, 0.5)",
      },
    ],
  };

  return <Bar options={options} data={data} />;
}
