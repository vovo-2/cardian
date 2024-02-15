import CardTransactionDailyList from "./CardTransactionDailyList";

type DayTransaction = {
  associateImage: string;
  benefitCode: string;
  date: string;
  discountAmount: number;
  price: number;
  store: string;
  transactionId: number;
};

type MonthlyTransactionDetails = {
  day: number;
  dailyTransactionDetailsList: DayTransaction[];
};

interface CardTransactionMonthlyListProps {
  month: number;
  monthlyTransactionDetailsList: MonthlyTransactionDetails[];
}

export default function CardTransactionMonthlyList({
  month,
  monthlyTransactionDetailsList,
}: CardTransactionMonthlyListProps) {
  return (
    <>
      {monthlyTransactionDetailsList.map(
        ({ day, dailyTransactionDetailsList }) => {
          return (
            <CardTransactionDailyList
              key={day}
              month={month}
              day={day}
              dailyTransactionDetailsList={dailyTransactionDetailsList}
            />
          );
        }
      )}
    </>
  );
}
