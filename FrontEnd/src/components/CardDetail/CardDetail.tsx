// import CardImage from "../../assets/travelwallet.png";
import Badge from "../ui/Badge";
import ProgressBar from "../ui/ProgressBar";

export default function CardDetail() {
  return (
    <div className="row-span-3 flex">
      {/* 카드 이미지 */}
      <div className="h-full w-1/2">
        <img src="" alt="카드 이미지" className="h-full object-contain"/>
      </div>

      <div className="ml-2 w-full flex flex-col justify-evenly">
        <div>
          {/* 뱃지 */}
          <div className="float-right">
            <Badge type="신용" />
            <Badge benefitCode="적립" />
          </div>

          {/* 카드사 이름 */}
          <div className="font-bold text-3xl">우리카드</div>
          {/* 카드 이름 */}
          <div className="text-2xl">트레블월렛</div>
        </div>

        <div className="mt-5">
          {/* 실적 ProgressBar */}
          <ProgressBar total={350000} value={294860} />

          <div className="flex justify-between mb-1">
            {/* 현재까지의 실적 금액 */}
            <span className="text-base font-bold text-darkgray">294,860원</span>
            {/* 실적 총 금액 */}
            <span className="text-base font-medium text-darkgray">
              350,000원
            </span>
          </div>
        </div>
        {/* 총 받은 혜택 금액 */}
        <div className="flex flex-row-reverse">
          <span>
            총 <span className="text-blue text-sm">23,000</span>원 혜택
            받으셨어요.
          </span>
        </div>
      </div>
    </div>
  );
}
