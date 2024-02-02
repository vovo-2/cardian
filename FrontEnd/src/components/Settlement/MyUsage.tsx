interface UsageProps {
    checkCard: number;
    creditCard: number;
}

export default function MyUsage({checkCard, creditCard}: UsageProps) {
  return (
    <div className="mt-5 text-2xl">
      <div className="flex justify-between">
        <span>체크카드</span>
        <span>총 <span className="text-blue font-semibold">{checkCard.toLocaleString()}</span>원</span>
      </div>
      <div className="flex justify-between">
        <span>신용카드</span>
        <span>총 <span className="text-blue font-semibold">{creditCard.toLocaleString()}</span>원</span>
      </div>
    </div>
  );
}
