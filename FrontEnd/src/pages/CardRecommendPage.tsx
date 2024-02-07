import { useEffect, useState } from "react";
import { axios } from "../api";

import CategoryButtonList from "../components/CardRecommend/CategoryButtonList";
import Badge from "../components/ui/Badge";
import { formatBenefitType } from "../utils/formatUtils";

type Category = {
  categoryCode: string;
  categoryName: string;
  categoryImage: string;
};

type CardBenefitDetail = {
  associateName: string;
  discountAmount: number;
  sign: string;
};

type RecommendationCard = {
  cardId: number;
  companyName: string;
  cardName: string;
  cardImage: string;
  benefitCode: string;
  type: string;
  cardBenefitDetailsList: CardBenefitDetail[];
  recievedBenefitAmount: number;
  maxBenefitAmount: number;
};

export default function CardRecommendPage() {
  const [categoryList, setCategoryList] = useState<Category[]>([]);
  const [selectedCategory, setSelectedCategory] = useState<Category>();
  const [recommendationCard, setRecommendationCard] =
    useState<RecommendationCard>();
  const moreReceivedBenefit =
    (recommendationCard?.maxBenefitAmount || 0) -
    (recommendationCard?.recievedBenefitAmount || 0);

  useEffect(() => {
    axios.get("/search/category-image").then(({ data }) => {
      setCategoryList(data);
    });
  }, []);

  const handleCategorySelect = (category: Category) => {
    setSelectedCategory(category);

    const memberId = 1;
    axios
      .get(`/recommendation/${memberId}/${category.categoryName}`)
      .then(({ data }) => {
        setRecommendationCard(data);
      });
  };

  const resultPhrase = (moreReceivedBenefit: number) => {
    let result = "";

    if (moreReceivedBenefit <= 0) {
      result = "이미 잘 사용하고 있어요!";
    } else if (moreReceivedBenefit <= 1000) {
      result = "조금 더 혜택을 받을 수 있었어요!";
    } else {
      result = "이만큼 더 혜택 받을 수 있었어요!";
    }

    return result;
  };

  return (
    <div className="w-full box-border pb-[100px]">
      <CategoryButtonList
        categoryList={categoryList}
        onCategorySelect={handleCategorySelect}
      />

      {!selectedCategory && (
        <div className="my-5">
          가장 큰 혜택의 카드를 보고싶은 카테고리를 선택해주세요!
        </div>
      )}
      {selectedCategory && (
        <div className="h-full flex flex-col justify-between">
          <div className="my-5">
            '<span className="font-bold">{selectedCategory?.categoryName}</span>
            ' 카테고리는 이 카드를 써보세요!
          </div>

          <div className="flex">
            <img
              src={recommendationCard?.cardImage}
              alt="추천 카드 이미지"
              className="w-1/3 h-full mr-3"
            />
            <div className="w-full">
              <div className="font-bold text-2xl">
                {recommendationCard?.companyName}
              </div>
              <div className="text-xl">{recommendationCard?.cardName}</div>
              <div className="my-2">
                <Badge type={recommendationCard?.type} />
                <Badge benefitCode={recommendationCard?.benefitCode} />
              </div>

              <div className="max-h-20 overflow-y-auto laptop:max-h-40 scrollbar-hide">
                {recommendationCard?.cardBenefitDetailsList.map(
                  ({ associateName, discountAmount, sign }, index) => {
                    return (
                      <div
                        key={index}
                        className="w-full grid grid-cols-12 mobile:text-sm items-baseline"
                      >
                        <span className="col-span-5">{associateName}</span>
                        <span className="col-span-4 text-xl font-bold text-blue">
                          <span>{discountAmount}</span>
                          <span>{sign === '+' ? '원' : sign}</span>
                        </span>
                        <span className="col-span-3">
                          {formatBenefitType(recommendationCard.benefitCode)}
                        </span>
                      </div>
                    );
                  }
                )}
              </div>
            </div>
          </div>

          <div>
            <div className="text-4xl mobile:text-xl tablet:text-2xl font-bold text-blue my-8 text-center">
              {resultPhrase(moreReceivedBenefit)}
            </div>
            <div className="w-full flex flex-col gap-3 text-xl px-5">
              <div className="w-full flex justify-between text-darkgray">
                <span>내가 받은</span>
                <span>{recommendationCard?.recievedBenefitAmount}원</span>
              </div>
              <div className="w-full flex justify-between font-bold">
                <span>더 받을 수 있었던</span>
                <span>{moreReceivedBenefit}원</span>
              </div>
              <hr className="my-2" />
              <div className="w-full flex justify-between text-darkgray">
                <span>총 받을 수 있었던</span>
                <span>{recommendationCard?.maxBenefitAmount}원</span>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
