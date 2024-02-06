import CategoryConsumeStore from "../../../store/CategoryConsumeStore";
import { useEffect } from "react";

import { Chart as ChartJS, ArcElement, Tooltip, Legend } from "chart.js";
import { Pie } from "react-chartjs-2";

ChartJS.register(ArcElement, Tooltip, Legend);

export default function ACategoryGraph() {
  const { consumeDataList, consumeLabelList, selectedMonth } =
    CategoryConsumeStore();
  useEffect(() => {}, [selectedMonth]);
  const data = {
    labels: consumeLabelList,
    datasets: [
      {
        data: consumeDataList,
        backgroundColor: [
          "#80BCBD",
          "#AAD9BB",
          "#756AB6",
          "#FFE5E5",
          "#D5F0C1",
          "#F9F7C9",

          "#AC87C5",
          "#E0AED0",
          "#FFE5E5",
          "#AFC8AD",
          "#FFD0EC",
          "#F3EEEA",
        ],
        borderColor: [
          "#80BCBD",
          "#AAD9BB",
          "#756AB6",
          "#FFE5E5",
          "#D5F0C1",
          "#F9F7C9",

          "#AC87C5",
          "#E0AED0",
          "#FFE5E5",
          "#AFC8AD",
          "#FFD0EC",
          "#F3EEEA",
        ],
        borderWidth: 1,
      },
    ],
  };
  return (
    <div>
      <Pie data={data} />
    </div>
  );
}
