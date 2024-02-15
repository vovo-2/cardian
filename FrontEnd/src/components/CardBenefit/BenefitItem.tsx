import { RiVipCrown2Line } from "react-icons/ri";

type BenefitInfo = {
  storeName: string;
  discountAmount: number;
  sign: string;
  isException: boolean;
};

export default function BenefitItem({
  storeName,
  discountAmount,
  sign,
  isException,
}: BenefitInfo) {
  return (
    <div className="flex justify-between px-6 py-3 border-2 border-whiteblue">
      <div className="flex">
        {isException ? (
          <RiVipCrown2Line className="my-auto mr-1" color="#fbbf24" />
        ) : (
          ""
        )}
        <div>{storeName}</div>
      </div>
      <div className={`${isException ? "text-red-600 font-bold" : ""}`}>
        {discountAmount}
        {sign === "+" ? "원" : sign} 할인
      </div>
    </div>
  );
}
