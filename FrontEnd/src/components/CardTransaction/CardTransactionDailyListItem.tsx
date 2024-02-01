import CardTransactionListItemLogo from "./CardTransactionListItemLogo";
import { BENEFIT_CODE } from "../../constants/benefitCode";

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

  const getTime = (date: string) => {
    const timeFormatter = new Intl.DateTimeFormat("ko-KR", {
      hour: "2-digit",
      hourCycle: "h24",
      minute: "2-digit",
    });

    const result = timeFormatter.format(new Date(date));

    return result;
  };

  const getPrice = (price: number) => {
    const priceFormatter = new Intl.NumberFormat("ko-KR");

    const result = `${priceFormatter.format(price)}원`;

    return result;
  };

  const getBenefitType = (benefitCode: string) => {
    const result = BENEFIT_CODE[benefitCode as keyof typeof BENEFIT_CODE];

    return result;
  };

  return (
    <div className="flex flex-row justify-between mb-3">
      <div className="flex flex-row">
        <CardTransactionListItemLogo associateImage={associateImage} />
        <div className=" ml-3">
          <div className="font-bold">{store}</div>
          <div className="text-darkgray text-sm">{getTime(date)}</div>
        </div>
      </div>
      <div className="float-right">
        <div className="text-end">{getPrice(price)}</div>
        {discountAmount > 0 && (
          <div className="text-sm">
            <span className="text-blue">{getPrice(discountAmount)} </span>
            <span className="text-darkgray">{getBenefitType(benefitCode)}</span>
          </div>
        )}
      </div>
    </div>
  );
}
