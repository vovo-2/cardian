import BenefitItem from "./BenefitItem";
export default function BenefitList() {
  return (
    <div className="overflow-x-auto border-blue border-2 rounded-xl ">
      <BenefitItem />
      <BenefitItem />
      <BenefitItem />
      <BenefitItem />
    </div>
  );
}
