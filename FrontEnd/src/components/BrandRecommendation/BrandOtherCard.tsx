interface OtherCardProp {
  cardImage: string,
  cardName: string,
}

export default function BrandOtherCard({cardImage, cardName}: OtherCardProp) {
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
            <span className="text-xl">{cardName} 10% 할인</span>
            <span>이번달 실적 미충족</span>
            <span>혜택 상한 123,000원 남음</span>
          </div>
        </div>
      </div>
    </div>
  );
}
