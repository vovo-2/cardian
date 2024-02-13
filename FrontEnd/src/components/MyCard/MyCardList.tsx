import { useState, useEffect } from "react";

import { Carousel } from "flowbite-react";
import { CarouselTheme } from "../../themes/CarouselTheme";
import MyCard from "./MyCard";

import { axios } from "../../api";
import useAuthStore from "../../store/AuthStore";

type MyCard = {
  mycardId: number;
  myCardName: string;
  myCardImage: string;
};

export default function CardList() {
  const [cardList, setCardList] = useState<MyCard[]>();
  const { memberId } = useAuthStore();

  useEffect(() => {
    axios.get(`/card/${memberId}`).then(({ data }) => {
      setCardList(data.cardList);
    });
  }, [memberId]);

  return (
    <div className="flex">
      <Carousel theme={CarouselTheme} slide={false} className="overflow-y-visible">
        {cardList &&
          cardList.map((card) => {
            return (
              <MyCard
                key={card.mycardId}
                myCardImage={card.myCardImage}
                myCardName={card.myCardName}
                myCardId={card.mycardId}
              />
            );
          })}
      </Carousel>
    </div>
  );
}
