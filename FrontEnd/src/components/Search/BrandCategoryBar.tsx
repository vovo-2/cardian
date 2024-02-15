import { useState, useEffect } from "react";
import { Dropdown } from "flowbite-react";
import { CategoryTheme } from "../../themes/CategoryDropdownTheme";

import { axios } from "../../api";

type Category = {
  categoryCode: string;
  categoryName: string;
};

interface BrandCategoryProps {
  updateCategory: ({ categoryCode, categoryName }: Category) => void
  makeCategoryResult: () => void
  closeKeywordBar: (state: boolean) => void
}

export default function BrandCategory(props: BrandCategoryProps) {

  const [categoryList, setCategoryList] = useState<Category[]>();

  useEffect(() => {
    axios.get('/search/category').then(({ data }) => {
      setCategoryList(data);
    });
  }, []);

  return (
    <div className="flex mx-1 my-1 justify-between">
      <div>카테고리 선택</div>
      <Dropdown label="" placement="bottom-end" theme={CategoryTheme} inline>
        <div className="flex flex-wrap w-[300px]">
          {categoryList && categoryList.map((category) => {
            return (
              <Dropdown.Item
                href=""
                key={category.categoryCode}
                onClick={() => {props.closeKeywordBar(false); props.updateCategory(category); props.makeCategoryResult();}}
              >{category.categoryName}</Dropdown.Item>
            );
          })}
        </div>
      </Dropdown>
    </div>
  );
}
