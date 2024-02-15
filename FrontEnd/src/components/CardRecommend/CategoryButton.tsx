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
  const { categoryName } = category;

  return (
    <button
      className="snap-center transition ease-in-out duration-200 p-2 border rounded-md flex items-center w-fit border-lightgray text-darkgray hover:bg-blue hover:text-white"
      onClick={() => onClick(category)}
    >
      <div>{categoryName}</div>
    </button>
  );
}
