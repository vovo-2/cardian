import { Link } from "react-router-dom";

interface CardProps {
  myCardImage: string;
  myCardName: string;
  myCardId: number;
}

export default function Card({ myCardImage, myCardName, myCardId }: CardProps) {
  return (
    <Link to={`/mycard/${myCardId}`} className="overflow-visible">
      <div className="w-full flex justify-center items-center overflow-visible">
        <img src={myCardImage} alt={myCardName} className="w-1/2 h-5/6 md:w-1/3 transition ease-in-out duration-700 hover:-translate-y-2" />
      </div>
    </Link>
  );
}
