import { useState, useEffect } from "react";
import { FaSearch } from "react-icons/fa";

interface BrandKeywordProps {
  updateKeyword: (keyword: string) => void;
  makeKeywordResult: () => void;
  keywordResult: boolean;
  isClick: boolean;
  setClick: (state: boolean) => void;
}

export default function BrandKeywordBar(props: BrandKeywordProps) {
  function updateKeyword(keyword: string) {
    props.updateKeyword(keyword);
  }

  function makeKeywordResult() {
    props.makeKeywordResult();
  }

  const [isClick, setClick] = useState(false);
  const [keyword, setKeyword] = useState("");

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setKeyword(e.target.value);
  };
  const searchSubmitHandler = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
  };

  // keywordResult가 true에서 false로 바뀔 때마다 실행되는 함수 만들기
  useEffect(() => {
    if (!props.isClick && isClick) {
      setClick(false);
      setKeyword("");
    }
  }, [props.isClick, isClick])

  return (
    <div>
      {isClick || (
        <div className=" w-full h-10 flex flex-row justify-between ">
          <div className="">
            <div className="text-2xl font-bold">브랜드 혜택</div>
          </div>
          <button
            className="h-full my-auto mr-1"
            onClick={() => {
              setClick(true);
              props.setClick(true);
            }}
          >
            <FaSearch size="20" />
          </button>
        </div>
      )}

      {isClick && (
        <form
          className=" w-full h-10 flex flex-row justify-between "
          onSubmit={searchSubmitHandler}
        >
          <input
            className="bg-gray-100 outline-none w-full mr-5 rounded-lg border-4 border-blue"
            type="text"
            placeholder="검색어를 입력하세요."
            value={keyword}
            onChange={onChangeHandler}
          />
          <button
            className="h-full my-auto mr-1"
            type="submit"
            onClick={() => {
              if (keyword.length == 0) {
                alert("검색어를 입력하세요.");
              } else if (keyword.trim() === "") {
                alert("검색어를 입력하세요.");
              } else {
                updateKeyword(keyword);
                makeKeywordResult();
              }
            }}
          >
            <FaSearch size="20" />
          </button>
        </form>
      )}
    </div>
  );
}
