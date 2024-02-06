import { BENEFIT_CODE } from "../constants/cardInfo";

/**
 * @example
 * ```ts
 * // 01월 01일
 * console.log(getDate(1, 1));
 * ```
 */
export const formatDate = (month: number, day: number) => {
  const paddedMonth = month.toString().padStart(2, "0");
  const paddedDay = day.toString().padStart(2, "0");

  const result = `${paddedMonth}월 ${paddedDay}일`;

  return result;
};

/**
 * @example
 * ```ts
 * // 01:01
 * console.log(getTime("2023-12-31T01:01:00"));
 * ```
 */
export const formatTime = (date: string) => {
  const timeFormatter = new Intl.DateTimeFormat("ko-KR", {
    hour: "2-digit",
    hourCycle: "h24",
    minute: "2-digit",
  });

  const result = timeFormatter.format(new Date(date));

  return result;
};

/**
 * @example
 * ```ts
 * // 1,100,000원
 * console.log(getPrice(1100000));
 * ```
 */
export const formatPrice = (price: number) => {
  const priceFormatter = new Intl.NumberFormat("ko-KR");

  const result = `${priceFormatter.format(price)}원`;

  return result;
};

/**
 * @example
 * ```ts
 * // 할인
 * console.log(getBenefitType("DISCOUNT"));
 * // 적립
 * console.log(getBenefitType("ACCUMULATE"));
 * // 캐시백
 * console.log(getBenefitType("CASHBACK"));
 * ```
 */
export const formatBenefitType = (benefitCode: string) => {
  const result = BENEFIT_CODE[benefitCode as keyof typeof BENEFIT_CODE];

  return result;
};

/**
 * @example
 * ```ts
 * // 10%
 * console.log(formatPriceToPercentage(10,100));
 * ```
 */
export const formatPriceToPercentage = (price: number, total: number) => {
  const result = ((price / total) * 100).toFixed(2);

  return `${result}%`;
};
