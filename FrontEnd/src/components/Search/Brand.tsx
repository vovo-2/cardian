import React from "react";

export default function Brand() {
  return (
    <div className="grid grid-cols-12 bg-whiteblue rounded-lg py-2 px-2 my-2">
      <div className="col-span-2">
        <img className="h-16 l m-auto" src="img/twosome.png" alt="" />
      </div>
      <div className="col-span-10 my-auto ml-2">
        <div className="text-sm">카페/베이커리</div>
        <div className="text-lg font-semibold mt-1">투썸플레이스</div>
      </div>
    </div>
  );
}
