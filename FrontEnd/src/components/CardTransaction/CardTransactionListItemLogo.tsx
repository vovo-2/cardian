interface CardTransactionItemLogoProps {
  associateImage: string;
}

export default function CardTransactionItemLogo({
  associateImage,
}: CardTransactionItemLogoProps) {
  return (
    <img
      src={associateImage}
      alt="로고 이미지"
      className="rounded-xl w-12 h-12 object-contain"
    />
  );
}
