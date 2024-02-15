import tw from "tailwind-styled-components";

import { CARD_TYPE, BENEFIT_CODE } from "../../constants/cardInfo";

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
  const getCardType = (type: string) => {
    const result = CARD_TYPE[type as keyof typeof CARD_TYPE];

    return result;
  };

  const getBenefitType = (benefitCode: string) => {
    const result = BENEFIT_CODE[benefitCode as keyof typeof BENEFIT_CODE];

    return result;
  };

  return (
    <>
      {type && <TypeBadge>{getCardType(type)}</TypeBadge>}
      {benefitCode && (
        <BenefitBadge>{getBenefitType(benefitCode)}</BenefitBadge>
      )}
    </>
  );
}
