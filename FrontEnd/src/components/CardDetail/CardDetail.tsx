import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

import { axios } from "../../api";
import { formatPrice } from "../../utils/formatUtils";
import Badge from "../ui/Badge";
import ProgressBar from "../ui/ProgressBar";

type myCardInfoDetails = {
  accumulate: number;
  benefitCode: string;
  cardImage: string;
  cardName: string;
  companyName: string;
  goal: number;
  totalBenefit: number;
  type: string;
};

export default function CardDetail() {
  const cardId = useParams().card_id;
  const [myCardInfoDetails, setMyCardInfoDetails] =
    useState<myCardInfoDetails>();

  useEffect(() => {
    axios.get(`/card/${cardId}/detail`).then(({ data }) => {
      setMyCardInfoDetails(data.myCardInfoDetails);
    });
  }, [cardId]);

  if (!myCardInfoDetails) {
    return <div>카드 정보 없음</div>;
  }

  const {
    accumulate,
    benefitCode,
    cardImage,
    cardName,
    companyName,
    goal,
    totalBenefit,
    type,
  } = myCardInfoDetails;

  return (
    <div className="row-span-3 flex">
      {/* 카드 이미지 */}
      <div className="h-full w-1/2">
        <img
          src={cardImage}
          alt="카드 이미지"
          className="h-full object-contain"
        />
      </div>

      <div className="ml-2 w-full flex flex-col justify-evenly">
        <div>
          {/* 뱃지 */}
          <div className="float-right">
            <Badge type={type} />
            <Badge benefitCode={benefitCode} />
          </div>

          {/* 카드사 이름 */}
          <div className="font-bold text-3xl">{companyName}</div>
          {/* 카드 이름 */}
          <div className="text-2xl">{cardName}</div>
        </div>

        <div className="mt-5">
          <div className="flex justify-between text-sm text-gray">
            <span>나의 실적</span>
            <span>목표 실적</span>
          </div>

          {/* 실적 ProgressBar */}
          <ProgressBar total={goal} value={accumulate} />

          <div className="flex justify-between mb-1">
            {/* 현재까지의 실적 금액 */}
            <span className="text-base font-bold text-darkgray">
              {formatPrice(accumulate)}
            </span>
            {/* 실적 총 금액 */}
            <span className="text-base font-medium text-darkgray">
              {formatPrice(goal)}
            </span>
          </div>
        </div>
        {/* 총 받은 혜택 금액 */}
        <div className="flex flex-row-reverse">
          <span>
            총{" "}
            <span className="text-blue text-sm">{formatPrice(totalBenefit)}</span>{" "}
            혜택 받으셨어요.
          </span>
        </div>
      </div>
    </div>
  );
}
