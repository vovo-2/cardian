import { ReactElement } from "react";
import { useMatch, Link, useResolvedPath, useLocation } from "react-router-dom";
import {
  TbCreditCard,
  TbShoppingBagSearch,
  TbChartHistogram,
  TbMenu2,
  TbThumbUp,
} from "react-icons/tb";

interface LinkSetterProps {
  goto: string;
  icon: ReactElement;
}

function LinkSetter({ goto, icon }: LinkSetterProps) {
  const resolvePath = useResolvedPath(goto);
  const matchPath = useMatch({ path: resolvePath.pathname, end: true });
  let isActive = matchPath ? true : false;

  const now_path = useLocation().pathname;

  if (goto == "/mycard") {
    if (now_path == "/") isActive = true;
  }

  return (
    <Link
      to={goto}
      className={
        isActive
          ? "text-blue border-t-8 shadow-[inset_0_2px_4px_0_rgba(0,0,0,0.2)] flex w-full h-full justify-center "
          : "text-gray  hover:text-blue flex w-full justify-center h-full"
      }
    >
      {icon}
    </Link>
  );
}
export default function NavBar() {
  return (
    <div className="text-4xl fixed bottom-0 left-0 right-0 mx-auto max-w-[600px] h-[100px] bg-white">
      <div className="relative max-w-[600px] justify-center flex h-full ">
        <LinkSetter
          goto={"/mycard"}
          icon={<TbCreditCard size={50} className="my-auto" />}
        />
        <LinkSetter
          goto="/search"
          icon={<TbShoppingBagSearch size={50} className="my-auto" />}
        />
        <LinkSetter
          goto="/analysis"
          icon={<TbChartHistogram size={50} className="my-auto" />}
        />
        <LinkSetter
          goto="/recommendation"
          icon={<TbThumbUp size={50} className="my-auto" />}
        />
        <LinkSetter
          goto="/menu"
          icon={<TbMenu2 size={50} className="my-auto" />}
        />
      </div>
    </div>
  );
}
