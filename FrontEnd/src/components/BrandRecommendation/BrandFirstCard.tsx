import { Link } from "react-router-dom";
import Badge from "../ui/Badge";
import ProgressBar from "../ui/ProgressBar";

interface FirstCardProp {
  myCardId: number;
  cardImage: string;
  cardCompany: string;
  cardName: string;
  discountAmount: number;
  discountSign: string;
  cardType: string;
  benefitCode: string;
  consume: number;
  goal: number;
  thisMonthAchieve: boolean;
  currentBenefit: number;
  benefitLimitation: number;
  benefitRemain: boolean;
}

export default function BrandFirstCard({
  myCardId,
  cardImage,
  cardCompany,
  cardName,
  discountAmount,
  discountSign,
  cardType,
  benefitCode,
  consume,
  goal,
  thisMonthAchieve,
  currentBenefit,
  benefitLimitation,
  benefitRemain,
}: FirstCardProp) {
  return (
    <div className="h-1/3">
      <Link to={`/mycard/${myCardId}`}>
        <div className="flex flex-row">
          {/* 카드 */}
          <div className="h-full w-1/2 my-auto">
            <img src={cardImage} />
          </div>
          {/* 설명 */}
          <div className="ml-2 w-full flex flex-col justify-between">
            <div className="flex justify-between">
              <span className="text-2xl font-bold">{cardCompany}</span>
              <div className="ml-auto">
                <Badge type={cardType} />
                <Badge benefitCode={benefitCode} />
              </div>
            </div>
            <span className="text-xl">{cardName}</span>
            <span className="text-lg">
              <span className="text-4xl font-bold text-blue">
                {discountAmount}
                {discountSign === "+" ? "원" : discountSign}
              </span>
              &nbsp;할인
            </span>

            <div className="flex w-full h-px my-2 bg-gray" />
            {/* 그래프 나오는 부분 */}
            <div>
              <div className="flex flex-row justify-between">
                <span className="text-sm">이번 달 실적</span>
                <span className="text-sm text-gray">
                  {thisMonthAchieve
                    ? "충족"
                    : consume.toLocaleString() +
                      " / " +
                      goal.toLocaleString() +
                      "원"}
                </span>
              </div>
              <div>
                <ProgressBar value={consume} total={goal} />
              </div>
            </div>
            <div>
              <div className="flex flex-row justify-between">
                <span className="text-sm">혜택</span>
                <span className="text-sm text-gray">
                  {benefitRemain
                    ? currentBenefit.toLocaleString() +
                      " / " +
                      benefitLimitation.toLocaleString() +
                      "원"
                    : "0원"}
                </span>
              </div>
              <div>
                <ProgressBar value={currentBenefit} total={benefitLimitation} />
              </div>
            </div>
          </div>
        </div>
      </Link>
    </div>
  );
}
