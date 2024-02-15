import { useEffect } from "react";
import MonthlyCategoryInfoStore from "../../../store/MonthlyCategoryInfoStore";
import ACategoryGraph from "./ACategoryGraph";
import ACategoryTransactionList from "./ACategoryTransactionList";
import { SyncLoader } from "react-spinners";

export default function ACategory() {
  const { isLoading } = MonthlyCategoryInfoStore();

  useEffect(() => {}, [isLoading]);
  if (isLoading) {
    return (
      <div className="h-full my-36">
        <div className="text-center">
          <SyncLoader margin={20} color="blue" />
        </div>
      </div>
    );
  }

  return (
    <div>
      <ACategoryGraph />
      <ACategoryTransactionList />
    </div>
  );
}
