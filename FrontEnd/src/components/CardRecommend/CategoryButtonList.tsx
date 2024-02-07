import CategoryButton from "./CategoryButton";

type Category = {
  categoryCode: string;
  categoryName: string;
  categoryImage: string;
};

interface CategoryButtonListProps {
  categoryList: Category[];
  onCategorySelect: (category: Category) => void;
}

export default function CategoryButtonList({
  categoryList,
  onCategorySelect,
}: CategoryButtonListProps) {
  return (
    <div className="flex flex-wrap w-full overflow-x-scroll whitespace-nowrap gap-2 snap-x box-border">
      {categoryList.map((category) => {
        return (
          <CategoryButton
            key={category.categoryCode}
            category={category}
            onClick={onCategorySelect}
          />
        );
      })}
    </div>
  );
}
