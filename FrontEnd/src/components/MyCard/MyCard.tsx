import { Link } from "react-router-dom";

interface CardProps {
  myCardImage: string;
  myCardName: string;
  myCardId: number;
}

export default function Card({ myCardImage, myCardName, myCardId }: CardProps) {
  return (
    <Link to={`/mycard/${myCardId}`}>
      <div className="w-full flex justify-center items-center">
        <img src={myCardImage} alt={myCardName} className="w-1/2" />
      </div>
    </Link>
  );
}
