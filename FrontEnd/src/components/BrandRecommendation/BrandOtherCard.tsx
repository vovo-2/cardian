import { Link } from "react-router-dom";

interface OtherCardProp {
  myCardId: number;
  cardImage: string;
  cardName: string;
  discountAmount: number;
  discountSign: string;
  thisMonthAchieve: boolean;
  currentBenefit: number;
  benefitLimitation: number;
}

export default function BrandOtherCard({
  myCardId,
  cardImage,
  cardName,
  discountAmount,
  discountSign,
  thisMonthAchieve,
  currentBenefit,
  benefitLimitation,
}: OtherCardProp) {
  return (
    <div>
      <Link to={`/mycard/${myCardId}`}>
        <div>
          <div className="rounded-lg flex-row mt-2 p-2 grid grid-cols-12">
            <div className="col-span-3">
              {/* 이미지 */}
              <img className="" src={cardImage} />
            </div>
            <div className="col-span-9 ml-3 flex flex-col justify-evenly">
              {/* 설명 */}
              <span className="text-xl font-semibold">{cardName}</span>
              <span className="text-lg">
                {discountAmount}
                {discountSign == "%" ? "% 할인" : "원 할인"}
              </span>
              <span>이번달 실적 {thisMonthAchieve ? <span className="text-blue font-semibold">충족</span> : <span className="text-gray">미충족</span>}</span>
              <span>
                남은 혜택{" "}
                {benefitLimitation - currentBenefit <= 0
                  ? "0"
                  : benefitLimitation - currentBenefit}
                원
              </span>
            </div>
          </div>
        </div>
      </Link>
    </div>
  );
}
