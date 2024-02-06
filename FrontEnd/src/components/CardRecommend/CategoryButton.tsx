type Category = {
  categoryCode: string;
  categoryName: string;
  categoryImage: string;
};

interface CategoryButtonProps {
  category: Category;
  onClick: (category: Category) => void;
}

export default function CategoryButton({
  category,
  onClick,
}: CategoryButtonProps) {
  const { categoryImage, categoryName } = category;

  return (
    <button
      className="border rounded-xl flex p-1 items-center w-fit"
      onClick={() => onClick(category)}
    >
      <img src={categoryImage} alt="카테고리 이미지" className="w-8" />
      <div className="hidden mobile:block ml-1">{categoryName}</div>
    </button>
  );
}
