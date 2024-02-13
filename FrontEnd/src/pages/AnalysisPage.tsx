import { Tabs } from "flowbite-react";
import { CardDetailTabsTheme } from "../themes/CardDetailTabsTheme";
import Settlement from "../components/Settlement/Settlement";
import ACategoryInfo from "../components/Analysis/Category/ACategoryInfo";
import ACategory from "../components/Analysis/Category/ACategory";
import { useParams } from "react-router-dom";

export default function AnalysisPage() {
  const { activeFunc } = useParams();
  const isCategory: boolean = activeFunc == "category" ? true : false;

  return (
    <div className="pb-[100px]">
      <Tabs
        theme={CardDetailTabsTheme}
        aria-label="Tabs with underline"
        style="underline"
        className="h-min row-span-8"
      >
        <Tabs.Item active={isCategory ? true : false} title="통계">
          {/* 통계 최상위 컴포넌트 */}
          <ACategoryInfo />
          <ACategory />
        </Tabs.Item>
        <Tabs.Item active={isCategory ? false : true} title="연말정산">
          <Settlement />
        </Tabs.Item>
      </Tabs>
    </div>
  );
}
