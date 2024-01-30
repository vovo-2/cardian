interface CardProps {
  myCardImage: string;
  myCardName: string;
}

export default function Card({ myCardImage, myCardName }: CardProps) {
  return (
    <div className="w-full flex justify-center items-center">
      <img src={myCardImage} alt={myCardName} className="w-1/2" />
    </div>
  )
}