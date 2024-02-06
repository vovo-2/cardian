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
    <div className="w-dvw max-w-sm">
      {/* <div className="flex gap-2 overflow-y-auto whitespace-nowrap"> */}
      <div className="w-full flex flex-wrap whitespace-nowrap gap-2">
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
    </div>
  );
}
