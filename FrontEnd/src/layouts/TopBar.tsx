import logo from "../assets/logo.png";

export default function TopBar() {
  return (
    <div className="row-span-1 flex items-center">
      <img src={logo} alt="" className="h-full" />
      <span className="text-blue text-4xl font-bold">Cardian</span>
    </div>
  );
}
