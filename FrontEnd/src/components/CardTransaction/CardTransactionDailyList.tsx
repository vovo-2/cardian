import CardTransactionDailyListItem from "./CardTransactionDailyListItem";

type DayTransaction = {
  associateImage: string;
  benefitCode: string;
  date: string;
  discountAmount: number;
  price: number;
  store: string;
  transactionId: number;
};

interface CardTransactionDailyListProps {
  month: number;
  day: number;
  dailyTransactionDetailsList: DayTransaction[];
}

export default function CardTransactionDailyList({
  month,
  day,
  dailyTransactionDetailsList,
}: CardTransactionDailyListProps) {
  const getDate = (month: number, day: number) => {
    const result = `${month}월 ${day}일`;

    return result;
  };

  return (
    <>
      {dailyTransactionDetailsList.length > 0 && (
        <div className="mb-8">
          <div className="text-xs text-darkgray mb-3">
            {getDate(month, day)}
          </div>
          {dailyTransactionDetailsList.map((transaction) => (
            <CardTransactionDailyListItem
              key={transaction.transactionId}
              transaction={transaction}
            />
          ))}
        </div>
      )}
    </>
  );
}