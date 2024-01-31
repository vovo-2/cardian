import { Accordion } from "flowbite-react";

import BenefitList from "./BenefitList";

export default function CardBenefitList() {
  return (
    <div className="overflow-auto scrollbar-hide h-[300px] ">
      <Accordion className="border-none " collapseAll>
        <Accordion.Panel>
          <Accordion.Title className="bg-whiteblue w-full rounded-2xl border-none mt-2">
            <div className="flex w-full">
              <img src="" className="w-8 h-8 "></img>
              <div className=" ml-5 my-auto text-5">
                카페
                <span className="text-2xl font-semibold">5%</span>
                할인
              </div>
            </div>
          </Accordion.Title>
          <Accordion.Content className="border-none m-0 px-1">
            <BenefitList />
          </Accordion.Content>
        </Accordion.Panel>
      </Accordion>
    </div>
  );
}
