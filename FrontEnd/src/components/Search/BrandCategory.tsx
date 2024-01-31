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
}

export default function BrandCategory(props: BrandCategoryProps) {

  function updateCategory({categoryCode, categoryName}: Category) {
    props.updateCategory({categoryCode, categoryName});
  }

  const [categoryList, setCategoryList] = useState<Category[]>();

  useEffect(() => {
    axios.get('/search/category').then(({ data }) => {
      setCategoryList(data);
    });
  }, []);

  return (
    <div className="flex mx-1 my-1 justify-between">
      <div>카테고리 선택</div>
      <Dropdown label="" placement="left-start" theme={CategoryTheme} inline>
        <div className="flex flex-wrap w-[300px]">
          {categoryList && categoryList.map((category) => {
            return (
              <Dropdown.Item
                href="#"
                key={category.categoryCode}
                onClick={() => updateCategory(category)}
              >{category.categoryName}</Dropdown.Item>
            );
          })}
        </div>
      </Dropdown>
    </div>
  );
}
