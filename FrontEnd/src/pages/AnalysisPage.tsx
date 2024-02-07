import { Tabs } from "flowbite-react";
import { CardDetailTabsTheme } from "../themes/CardDetailTabsTheme";
import Settlement from "../components/Settlement/Settlement";

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

    <div className='pb-[100px]'>
      <Tabs
      theme={CardDetailTabsTheme}
      aria-label="Tabs with underline"
      style="underline"
      className="h-min row-span-8"
    >
      <Tabs.Item active title="통계">
        {/* 통계 최상위 컴포넌트 */}
      </Tabs.Item>
      <Tabs.Item title="연말정산">
        <Settlement />
      </Tabs.Item>
    </Tabs>
    </div>
  );
}
