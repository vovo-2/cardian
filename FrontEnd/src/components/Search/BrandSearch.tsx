import { useState } from "react";
import BrandKeywordBar from "./BrandKeywordBar";
import BrandCategoryBar from "./BrandCategoryBar";
import BrandKeywordList from "./BrandKeywordList";
import BrandCategoryList from "./BrandCategoryList";

type Category = {
  categoryCode: string;
  categoryName: string;
};

export default function BrandSearch() {
  /*
   * 키워드로 검색한 결과를 보여줄 때 : false (default)
   * 카테고리 별 제휴사를 보여줄 때 : true
   */
  const [keywordResult, setKeywordResult] = useState(false);

  function onSetKeywordResult() {
    setKeywordResult(true);
  }
  function onSetCategoryResult() {
    setKeywordResult(false);
  }

  const [keyword, setKeyword] = useState("");
  
  function onSetKeyword(keyword: string) {
    setKeyword(keyword);
  }

  const [categoryCode, setCategoryCode] = useState("C001");
  const [categoryName, setCategoryName] = useState("대중교통");

  function onSetCategoryCode({ categoryCode, categoryName }: Category) {
    setCategoryCode(categoryCode);
    setCategoryName(categoryName);
  }

  return (
    <div>
      <BrandKeywordBar makeKeywordResult={onSetKeywordResult} updateKeyword={onSetKeyword} />
      <BrandCategoryBar makeCategoryResult={onSetCategoryResult} updateCategory={onSetCategoryCode} />
      {
        keywordResult
        ? <BrandKeywordList keyword={keyword} />
        : <BrandCategoryList categoryCode={categoryCode} categoryName={categoryName} />
      }
    </div>
  );
}