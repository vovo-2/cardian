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
      <div>{storeName}</div>
      <div className={`${isException ? "text-red-600 font-bold" : ""}`}>
        {discountAmount} {sign}
      </div>
    </div>
  );
}
