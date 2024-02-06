interface OtherCardProp {
  cardImage: string,
  cardName: string,
  discountAmount: number,
  discountSign: string,
  thisMonthAchieve: boolean,
  currentBenefit: number,
  benefitLimitation: number
}

export default function BrandOtherCard({cardImage, cardName, discountAmount, discountSign, thisMonthAchieve, currentBenefit, benefitLimitation}: OtherCardProp) {
  return (
    <div>
      <div className="" />
      <div>
        <div className="rounded-lg flex-row mt-2 p-2 grid grid-cols-12">
          <div className="col-span-3">
            {/* 이미지 */}
            <img
              className=""
              src={cardImage}
            />
          </div>
          <div className="col-span-9 ml-3 flex flex-col justify-evenly">
            {/* 설명 */}
            <span className="text-xl">{cardName}</span>
            <span className="text-xl">{discountAmount}{ discountSign=="%" ? "% 할인" : "원 할인"}</span>
            <span>이번달 실적 {thisMonthAchieve ? "충족" : "미충족"}</span>
            <span>혜택 상한 {benefitLimitation-currentBenefit <= 0 ? "0" : benefitLimitation-currentBenefit}원 남음</span>
          </div>
        </div>
      </div>
    </div>
  );
}
