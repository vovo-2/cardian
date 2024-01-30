import tw from "tailwind-styled-components";

type BadgeProps = {
  type?: string; // 신용, 체크
  benefitCode?: string; // 할인, 적립, 캐시백
};

const TypeBadge = tw.span`
  inline-flex 
  items-center 
  rounded-xl 
  bg-white 
  px-2 
  py-1 
  text-xs 
  font-medium 
  text-blue ring-1 
  ring-inset 
  ring-blue/100
`;

const BenefitBadge = tw.span`
  inline-flex 
  items-center 
  rounded-xl 
  bg-yellow 
  px-2 
  py-1 
  text-xs 
  font-medium 
  text-darkgray
`;

export default function Badge({ type, benefitCode }: BadgeProps) {
  return (<>
    {type && <TypeBadge>{type}</TypeBadge>}
    {benefitCode && <BenefitBadge>{benefitCode}</BenefitBadge>}
  </>);
}
