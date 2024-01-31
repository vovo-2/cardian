interface BrandProps {
  categoryName: string;
  associationName: string;
  associationImage: string;
}

export default function Brand({categoryName, associationName, associationImage}: BrandProps) {
  return (
    <div className="grid grid-cols-12 bg-whiteblue rounded-lg py-2 px-2 my-2">
      <div className="col-span-2">
        <img className="h-16 l m-auto" src={associationImage} alt={associationName} crossOrigin="anonymous"
  referrerPolicy="no-referrer" />
      </div>
      <div className="col-span-10 my-auto ml-2">
        <div className="text-sm">{categoryName}</div>
        <div className="text-lg font-semibold mt-1">{associationName}</div>
      </div>
    </div>
  );
}