import { Accordion } from "flowbite-react";

import CategoryBenefit from "./CategoryBenefit";
import BenefitList from "./BenefitList";

import { useParams } from "react-router-dom";
import { axios } from "../../api";
import { useEffect, useState } from "react";

type Benefit = {
  name: string;
  sign: string;
  discountAmount: number;
  cardId: number;
  iconImage: string;
  categorybenefitId: number;
};
export default function CardBenefitList() {
  const params = useParams();
  const [benefitList, setBenefitList] = useState<Benefit[]>([]);

  useEffect(() => {
    const url = `/card/${params.card_id}/benefit`;
    axios.get(url).then(({ data }) => {
      setBenefitList(data.benefitList);
    });
  }, []);

  return (
    <div className="overflow-auto scrollbar-hide h-[300px] ">
      <Accordion className="border-none " collapseAll>
        {benefitList &&
          benefitList.map((b) => (
            <Accordion.Panel key={b.categorybenefitId}>
              <Accordion.Title className="bg-whiteblue w-full rounded-2xl border-none mt-2">
                <div className="flex w-full">
                  <img src={`${b.iconImage}`} className="w-8 h-8 "></img>
                  <div className=" ml-5 my-auto text-5">
                    {b.name}
                    <span className="text-2xl font-semibold">{` ${b.discountAmount}${b.sign} `}</span>
                    할인
                  </div>
                </div>
              </Accordion.Title>
              <Accordion.Content className="border-none m-0 px-1">
                <BenefitList />
              </Accordion.Content>
            </Accordion.Panel>
          ))}
      </Accordion>
    </div>
  );
}
