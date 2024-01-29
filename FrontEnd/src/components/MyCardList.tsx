import { useState, useEffect } from "react";
import { Carousel } from "flowbite-react";
import { CarouselTheme } from "../themes/CarouselTheme";

import axios from "axios";

import MyCard from "./MyCard";

type MyCard = {
  mycardId: number;
  myCardName: string;
  myCardImage: string;
};

interface MyCardList {
  memberId: number;
  cardList: MyCard[];
}

export default function CardList() {
  const [cardList, setCardList] = useState<MyCard[]>([]);
  const [memberId, setMemberId] = useState<number>();

  useEffect(() => {
    axios.get(`${import.meta.env.VITE_BASE_URL}/card/1`).then(({ data }) => {
      setCardList(data.cardList);
      setMemberId(data.memberId);
    });
  }, []);

  return (
    <div className="flex">
      <Carousel theme={CarouselTheme} slide={false}>
        {cardList.map((card) => {
          return (
            <MyCard
              key={card.mycardId}
              myCardImage={card.myCardImage}
              myCardName={card.myCardName}
            />
          );
        })}
      </Carousel>
    </div>
  );
}
