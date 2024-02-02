import { Accordion } from "flowbite-react";

import { axios } from "../../api";
import { useState, useEffect } from "react";

export default function YearTransactionList() {
  return (
    <div>
      <div className="overflow-y-auto scrollbar-hide  ">
        <Accordion className="border-none w-full" collapseAll>
          <Accordion.Panel key="" className="">
            <Accordion.Title className="">
              <div className="flex justify-between">
                <div className="">1월</div>
                <div className="">000,000원</div>
              </div>
            </Accordion.Title>
            <Accordion.Content className="border-none m-0 px-1">
              이용내역들
            </Accordion.Content>
          </Accordion.Panel>
        </Accordion>
      </div>
    </div>
  );
}
