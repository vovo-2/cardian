"use client";

import { Accordion, Table } from "flowbite-react";

import CardBenefitList from "./CardBenefitList";

export default function CardBenefit() {
  return (
    <Accordion className="border-none overflow-auto scrollbar-hide" collapseAll>
      <Accordion.Panel>
        <Accordion.Title className="bg-whiteblue w-full">
          <div className="flex w-full">
            <div className="rounded-full w-10 h-10 bg-black"></div>
            <div className=" ml-5">
              편의점 <span className=" text-2xl">5%</span> 할인
            </div>
          </div>
        </Accordion.Title>
        <Accordion.Content className="border-none">
          <div className="overflow-x-auto w-full border-whiteblue border-4 rounded-xl">
            <Table className="w-full">
              <Table.Body className="divide-y divide-whiteblue">
                <CardBenefitList />
              </Table.Body>
            </Table>
          </div>
        </Accordion.Content>
      </Accordion.Panel>
    </Accordion>
  );
}
