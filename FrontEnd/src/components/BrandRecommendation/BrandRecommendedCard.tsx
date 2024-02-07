import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

import { axios } from "../../api";
import BrandOtherCard from "./BrandOtherCard";
import BrandFirstCard from "./BrandFirstCard";
import { Label, Radio } from "flowbite-react";
import { RadioButtonTheme } from "../../themes/RadioButtonTheme";

type CardType = {
  myCardId: number;
  cardImage: string;
  cardCompany: string;
  cardName: string;
  goal: number; // 채워야 하는 실적 금액
  consume: number; // 이번달 사용 금액
  thisMonthAchieve: boolean; // 이번달 실적 채웠는지
  cardType: string;
  benefitCode: string;
  benefitLimitation: number; // 혜택 한도
  currentBenefit: number; // 이번달 기사용 혜택
  benefitRemain: boolean; // 이번달 혜택 한도 남았는지
  discountAmount: number;
  discountSign: string;
  goalAchieve: boolean; // 저번달 실적 채웠는지
};

export default function BrandRecommendedCard() {
  const memberId: number = 1;
  const { associationId } = useParams();

  const [cardListPercent, setCardListPercent] = useState<CardType[]>();
  const [cardListPlus, setCardListPlus] = useState<CardType[]>();

  useEffect(() => {
    axios
      .get(`/search/${memberId}/${associationId}/card-list`)
      .then(({ data }) => {
        setCardListPercent(data[0]);
        setCardListPlus(data[1]);
      });
  }, [associationId]);

  const [isPercent, setPercent] = useState(true);

  const makePercent = () => {
    setPercent(true);
  }
  const makePlus = () => {
    setPercent(false);
  }

  return (
    <div>
      <div className="bg-whiteblue rounded-lg mb-3 p-2">
        <fieldset className="grid grid-cols-2">
          {/* <legend>제목</legend> */}
          <div>
            <Radio theme={RadioButtonTheme} id="%" name="criteria" value="true" onChange={makePercent} defaultChecked />
            <Label htmlFor="%"> %</Label>
          </div>
          <div>
            <Radio theme={RadioButtonTheme} id="+" name="criteria" value="false" onChange={makePlus} />
            <Label htmlFor="+"> +</Label>
          </div>
        </fieldset>
      </div>
      {isPercent ? (
        <div>
          {cardListPercent && cardListPercent.length > 0 && (
            <BrandFirstCard
              myCardId={cardListPercent[0].myCardId}
              cardImage={cardListPercent[0].cardImage}
              cardCompany={cardListPercent[0].cardCompany}
              cardName={cardListPercent[0].cardName}
              discountAmount={cardListPercent[0].discountAmount}
              discountSign={cardListPercent[0].discountSign}
              cardType={cardListPercent[0].cardType}
              benefitCode={cardListPercent[0].benefitCode}
              consume={cardListPercent[0].consume}
              goal={cardListPercent[0].goal}
              thisMonthAchieve={cardListPercent[0].thisMonthAchieve}
              currentBenefit={cardListPercent[0].currentBenefit}
              benefitLimitation={cardListPercent[0].benefitLimitation}
              benefitRemain={cardListPercent[0].benefitRemain}
            />
          )}
          {cardListPercent &&
            cardListPercent.slice(1).map((card) => {
              return (
                <BrandOtherCard
                  key={card.myCardId}
                  myCardId={card.myCardId}
                  cardImage={card.cardImage}
                  cardName={card.cardName}
                  discountAmount={card.discountAmount}
                  discountSign={card.discountSign}
                  thisMonthAchieve={card.thisMonthAchieve}
                  currentBenefit={card.currentBenefit}
                  benefitLimitation={card.benefitLimitation}
                />
              );
            })}
        </div>
      ) : (
        <div>
          {cardListPlus && cardListPlus.length > 0 && (
            <BrandFirstCard
              myCardId={cardListPlus[0].myCardId}
              cardImage={cardListPlus[0].cardImage}
              cardCompany={cardListPlus[0].cardCompany}
              cardName={cardListPlus[0].cardName}
              discountAmount={cardListPlus[0].discountAmount}
              discountSign={cardListPlus[0].discountSign}
              cardType={cardListPlus[0].cardType}
              benefitCode={cardListPlus[0].benefitCode}
              consume={cardListPlus[0].consume}
              goal={cardListPlus[0].goal}
              thisMonthAchieve={cardListPlus[0].thisMonthAchieve}
              currentBenefit={cardListPlus[0].currentBenefit}
              benefitLimitation={cardListPlus[0].benefitLimitation}
              benefitRemain={cardListPlus[0].benefitRemain}
            />
          )}
          {cardListPlus &&
            cardListPlus.slice(1).map((card) => {
              return (
                <BrandOtherCard
                  key={card.myCardId}
                  myCardId={card.myCardId}
                  cardImage={card.cardImage}
                  cardName={card.cardName}
                  discountAmount={card.discountAmount}
                  discountSign={card.discountSign}
                  thisMonthAchieve={card.thisMonthAchieve}
                  currentBenefit={card.currentBenefit}
                  benefitLimitation={card.benefitLimitation}
                />
              );
            })}
        </div>
      )}
    </div>
  );
}
