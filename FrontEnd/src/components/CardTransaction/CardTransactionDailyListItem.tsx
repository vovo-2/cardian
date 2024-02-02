import { formatBenefitType, formatPrice, formatTime } from "../../utils/formatUtils";
import CardTransactionListItemLogo from "./CardTransactionListItemLogo";

type DayTransaction = {
  associateImage: string;
  benefitCode: string;
  date: string;
  discountAmount: number;
  price: number;
  store: string;
  transactionId: number;
};

interface CardTransactionDailyListItemProps {
  transaction: DayTransaction;
}

export default function CardTransactionDailyListItem({
  transaction,
}: CardTransactionDailyListItemProps) {
  const { associateImage, benefitCode, date, discountAmount, price, store } =
    transaction;

  return (
    <div className="flex flex-row justify-between mb-3">
      <div className="flex flex-row">
        <CardTransactionListItemLogo associateImage={associateImage} />
        <div className=" ml-3">
          <div className="font-bold">{store}</div>
          <div className="text-darkgray text-sm">{formatTime(date)}</div>
        </div>
      </div>
      <div className="float-right">
        <div className="text-end">{formatPrice(price)}</div>
        {discountAmount > 0 && (
          <div className="text-sm">
            <span className="text-blue">{formatPrice(discountAmount)} </span>
            <span className="text-darkgray">{formatBenefitType(benefitCode)}</span>
          </div>
        )}
      </div>
    </div>
  );
}
