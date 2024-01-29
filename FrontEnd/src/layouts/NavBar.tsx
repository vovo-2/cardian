import { useMatch, Link, useResolvedPath } from "react-router-dom";
import {
  TbCreditCard,
  TbShoppingBagSearch,
  TbChartHistogram,
  TbMenu2,
  TbThumbUp,
} from "react-icons/tb";

function LinkSetter({ goto, icon }) {
  const resolvePath = useResolvedPath(goto);
  const isActive = useMatch({ path: resolvePath.pathname, end: true });

  return (
    <Link
      to={goto}
      className={
        isActive
          ? "text-blue border-t-8 p-5 shadow-[inset_0_2px_4px_0_rgba(0,0,0,0.2)]"
          : "text-gray p-5 hover:text-blue"
      }
    >
      {icon}
    </Link>
  );
}
export default function NavBar() {
  return (
    <div className="text-4xl items-center h-[100px] flex flex-wrap fixed bottom-0 left-0 right-0 max-w-[600px] justify-between mx-auto">
      <LinkSetter goto="/mycard" icon={<TbCreditCard className="mx-auto" />} />
      <LinkSetter
        goto="/search"
        icon={<TbShoppingBagSearch className="mx-auto" />}
      />
      <LinkSetter
        goto="/analysis"
        icon={<TbChartHistogram className="mx-auto" />}
      />
      <LinkSetter
        goto="/recommendation"
        icon={<TbThumbUp className="mx-auto" />}
      />
      <LinkSetter goto="/menu" icon={<TbMenu2 className="mx-auto" />} />
    </div>
  );
}
