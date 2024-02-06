import { Tabs } from "flowbite-react";
import { CardDetailTabsTheme } from "../../themes/CardDetailTabsTheme";
import CardTransaction from "../CardTransaction/CardTransaction";
import CardBenefitList from "../CardBenefit/CardBenefitList";

export default function CardDetailTabs() {
  return (
    <Tabs
      theme={CardDetailTabsTheme}
      aria-label="Tabs with underline"
      style="underline"
      className="h-min row-span-8"
    >
      <Tabs.Item active title="이용내역">
        <CardTransaction />
      </Tabs.Item>
      <Tabs.Item title="혜택">
        <CardBenefitList />
      </Tabs.Item>
    </Tabs>
  );
}
