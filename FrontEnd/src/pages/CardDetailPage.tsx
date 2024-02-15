import CardDetail from "../components/CardDetail/CardDetail";
import CardDetailTabs from "../components/CardDetail/CardDetailTabs";

export default function CardDetailPage() {
  return (
    <div className="h-full grid grid-rows-12 pb-[100px]">
      <CardDetail />
      <CardDetailTabs />
    </div>
  );
}
