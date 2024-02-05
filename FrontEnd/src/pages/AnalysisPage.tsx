import YearGraph from "../components/YearTransaction/YearGraph";
import YearTransactionInfo from "../components/YearTransaction/YearTransactionInfo";
import YearTransactionList from "../components/YearTransaction/YearTransactionList";

import ACategoryInfo from "../components/Analysis/Category/ACategoryInfo";
import ACategoryGraph from "../components/Analysis/Category/ACategoryGraph";
import ACategoryTransactionList from "../components/Analysis/Category/ACategoryTransactionList";

export default function AnalysisPage() {
  return (
    // <div className="m-10">
    //   <YearTransactionInfo />
    //   {/* chartBox */}
    //   <div className="w-[700px] p-[20px]">
    //     {/* container */}
    //     <div className="w-[750px] max-w-[350px] overflow-x-auto">
    //       {/* containerBody */}
    //       <div className="h-[200px]">
    //         <YearGraph />
    //       </div>
    //     </div>
    //   </div>
    //   <YearTransactionList />
    // </div>

    <div className="m-10">
      <ACategoryInfo />
      <ACategoryGraph />
      <ACategoryTransactionList />
    </div>
  );
}
