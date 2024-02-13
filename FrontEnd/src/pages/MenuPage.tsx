import { MdContactPage, MdOutlineInsertEmoticon } from "react-icons/md";
import { LinkSetter } from "../layouts/NavBar";
import { Link } from "react-router-dom";
import TopBar from "../layouts/TopBar";
import {
  TbChartHistogram,
  TbShoppingBagSearch,
  TbThumbUp,
} from "react-icons/tb";
import { FaMoneyBill1Wave } from "react-icons/fa6";

export default function MenuPage() {
  return (
    <div className="bg-whiteblue grid grid-rows-12 h-full">
      <TopBar />
      <div className="row-span-2 text-center my-auto">
        <h1 className="font-bold text-3xl">
          안녕하세요. <span className="text-blue ">김민준</span>님!
        </h1>
      </div>
      <div className="bg-white row-span-9 rounded-t-[70px]">
        <h1 className="font-bold text-3xl text-center mt-5">전체 메뉴</h1>
        <div className="mx-7">
          <div className="flex justify-between my-10">
            {/* 버튼 하나 시작 */}
            <Link to={"/search"} className="hover:font-bold hover:scale-110 ">
              <div>
                <TbShoppingBagSearch
                  size="80"
                  className="mx-auto  hover:text-blue"
                />
              </div>
              <div className="text-center">매장 별 혜택</div>
            </Link>
            {/* 버튼 하나 끝 */}

            {/* 버튼 하나 시작 */}
            <Link
              to={"/recommendation"}
              className="hover:font-bold hover:scale-110 "
            >
              <div>
                <TbThumbUp size="80" className="mx-auto  hover:text-blue" />
              </div>
              <div className="text-center">카드 추천</div>
            </Link>
            {/* 버튼 하나 끝 */}
            {/* 버튼 하나 시작 */}
            <Link
              to={"/analysis/category"}
              className="hover:font-bold hover:scale-110 "
            >
              <div>
                <TbChartHistogram
                  size="80"
                  className="mx-auto  hover:text-blue"
                />
              </div>
              <div className="mt-1 w-20 text-center">카테고리별 이용내역</div>
            </Link>
            {/* 버튼 하나 끝 */}
          </div>
          <div className="flex justify-between">
            {/* 버튼 하나 시작 */}
            <Link
              to={"/analysis/settlement"}
              className="hover:font-bold hover:scale-110 "
            >
              <div>
                <FaMoneyBill1Wave
                  size="80"
                  className="mx-auto  hover:text-blue"
                />
              </div>
              <div className="text-center">연말정산</div>
            </Link>
            {/* 버튼 하나 끝 */}

            {/* 버튼 하나 시작 */}
            <Link to={"/menu"} className="hover:font-bold hover:scale-110 ">
              <div>
                <MdContactPage size="80" className="mx-auto  hover:text-blue" />
              </div>
              <div className="text-center">마이페이지</div>
            </Link>
            {/* 버튼 하나 끝 */}
            {/* 버튼 하나 시작 */}
            <div className="w-[80px]"></div>
            {/* 버튼 하나 끝 */}
          </div>
        </div>
        <div className="text-right row-span-1 h-full ">
          <button className="hover:text-blue font-bold ">로그아웃</button>
        </div>
      </div>
    </div>
  );
}
