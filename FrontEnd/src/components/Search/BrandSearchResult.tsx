import { useState } from 'react';
import BrandCategory from "./BrandCategory";
import BrandList from "./BrandList";

type Category = {
  categoryCode: string;
  categoryName: string;
};

export default function BrandCategorySearch() {

  const [categoryCode, setCategoryCode] = useState("C001");
  const [categoryName, setCategoryName] = useState("대중교통");

  function onSetCategory({categoryCode, categoryName}: Category) {
    setCategoryCode(categoryCode);
    setCategoryName(categoryName)
  }

  return (
    <div>
      <BrandCategory updateCategory={onSetCategory} />
      <BrandList categoryCode={categoryCode} categoryName={categoryName} />
    </div>
  )
}