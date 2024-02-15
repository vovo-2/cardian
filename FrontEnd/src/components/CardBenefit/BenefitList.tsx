import BenefitItem from "./BenefitItem.tsx";

import { axios } from "../../api";
import { useState, useEffect } from "react";

type BenefitInfo = {
  storeName: string;
  discountAmount: number;
  sign: string;
};

type InputInfo = {
  key: number;
  myCardId: number;
  categoryCode: string;
};
export default function BenefitList({ myCardId, categoryCode }: InputInfo) {
  const [exceptionBenefit, setExceptionBenefit] = useState<BenefitInfo>();

  const [benefitList, setBenefitList] = useState<BenefitInfo[]>([]);
  useEffect(() => {
    const url = `/card/${myCardId}/${categoryCode}/store`;

    axios.get(url).then(({ data }) => {
      setExceptionBenefit(data.exceptionBenefitStore);
      const list: BenefitInfo[] = [];

      data.storeList.map((item: BenefitInfo) => {
        if (item.storeName != "") list.push(item);
      });
      setBenefitList(list);
    });
  }, []);

  return (
    <div className="overflow-x-auto rounded-xl  border-2 border-whiteblue ">
      {exceptionBenefit?.storeName && (
        <BenefitItem
          key={-1}
          storeName={exceptionBenefit.storeName}
          discountAmount={exceptionBenefit.discountAmount}
          sign={exceptionBenefit.sign}
          isException={true}
        />
      )}

      {benefitList &&
        benefitList.map((item, idx) => {
          return (
            <BenefitItem
              key={idx}
              storeName={item.storeName}
              discountAmount={item.discountAmount}
              sign={item.sign}
              isException={false}
            />
          );
        })}
    </div>
  );
}
