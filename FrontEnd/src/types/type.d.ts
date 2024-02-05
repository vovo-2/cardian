export type DayTransaction = {
  associateImage: string;
  benefitCode: string;
  date: string;
  discountAmount: number;
  price: number;
  store: string;
  transactionId: number;
};

export interface CardTransactionDailyListItemProps {
  transaction: DayTransaction;
}

export type MonthlyTransactionDetails = {
  day: number;
  dailyTransactionDetailsList: DayTransaction[];
};

export interface CardTransactionMonthlyListProps {
  month: number;
  monthlyTransactionDetailsList: MonthlyTransactionDetails[];
}
