import { Tabs } from "flowbite-react";
import { CardDetailTabsTheme } from "../../themes/CardDetailTabsTheme";
import CardTransaction from "../CardTransaction/CardTransaction";

export default function CardDetailTabs() {
  return (
      <Tabs
        theme={CardDetailTabsTheme}
        aria-label="Tabs with underline"
        style="underline"
        className="h-min row-span-8"
      >
        <Tabs.Item active title="이용내역" className="grid-rows-12">
          <CardTransaction />
        </Tabs.Item>
        <Tabs.Item title="혜택">혜택</Tabs.Item>
      </Tabs>
  );
}
