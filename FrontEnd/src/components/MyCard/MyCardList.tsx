import { useState, useEffect } from "react";

import { Carousel } from "flowbite-react";
import { CarouselTheme } from "../../themes/CarouselTheme";
import MyCard from "./MyCard";

import { axios } from "../../api";

type MyCard = {
  mycardId: number;
  myCardName: string;
  myCardImage: string;
};

export default function CardList() {
  const [cardList, setCardList] = useState<MyCard[]>();

  useEffect(() => {
    axios.get("/card/1").then(({ data }) => {
      setCardList(data.cardList);
    });
  }, []);

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
