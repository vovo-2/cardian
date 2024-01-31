import React, { useState } from "react";
import { FaSearch } from "react-icons/fa";

export default function BrandSearchBar() {
  const [isClick, setClick] = useState(false);

  return (
    <div className=" flex h-10 justify-between ">
      {isClick || (
        <div className="">
          <div className="text-2xl font-bold">브랜드 혜택</div>
        </div>
      )}

      {isClick && (
        <>
          <input
            className="bg-gray-100 outline-none w-full mr-5 rounded-lg border-4 border-blue"
            type="text"
          />
        </>
      )}

      <button
        className="h-full my-auto mr-1"
        onClick={() => {
          setClick(true);
        }}
      >
        <FaSearch size="20" />
      </button>
    </div>
  );
}
