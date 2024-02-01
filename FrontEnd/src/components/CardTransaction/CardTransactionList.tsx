import CardTransactionListItem from "./CardTransactionListItem";

export default function CardTransactionList() {
  return (
    <div className="p-2">
      <div className="text-gray mb-2">1월 16일</div>
      <div className="w-full">
        <CardTransactionListItem />
      </div>
    </div>
  )
}