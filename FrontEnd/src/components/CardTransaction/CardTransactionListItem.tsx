import CardTransactionListItemLogo from "./CardTransactionListItemLogo";

export default function CardTransactionItem() {
  return (
    <div className="flex flex-row justify-between">
      <div className="flex flex-row">
        <CardTransactionListItemLogo />
        <div className=" ml-3">
          <div className="font-bold">바나프레소</div>
          <div className="text-darkgray text-sm">15:02</div>
        </div>
      </div>
      <div className="float-right">
        <div className="text-end">1,800원</div>
        <div className="text-sm">
          <span className="text-blue">1,500원 </span>
          <span className="text-darkgray">적립</span>
        </div>
      </div>
    </div>
  );
}
