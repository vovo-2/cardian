import { Link } from "react-router-dom";

interface BrandProps {
  categoryName: string;
  associationId: number;
  associationName: string;
  associationImage: string;
}

export default function Brand({
  categoryName,
  associationId,
  associationName,
  associationImage,
}: BrandProps) {
  return (
    <Link to={`/brand/${associationId}`} state={{associationName: associationName}}>
      <div className="flex flex-row bg-whiteblue rounded-lg py-2 px-2 my-2">
        <div className="w-16 mr-3">
          <img
            className="h-16 l m-auto rounded-full"
            src={associationImage}
            alt={associationName}
            crossOrigin="anonymous"
            referrerPolicy="no-referrer"
          />
        </div>
        <div className="my-auto ml-2">
          <div className="text-sm">{categoryName}</div>
          <div className="text-lg font-semibold mt-1">{associationName}</div>
        </div>
      </div>
    </Link>
  );
}
