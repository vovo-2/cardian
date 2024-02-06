import NavBar from "../layouts/NavBar";
import MyCardList from "../components/MyCard/MyCardList";
import TopBar from "../layouts/TopBar";

export default function HomePage() {
  return (
    <div className="grid grid-rows-12 h-full">
      <TopBar />

      <div className="main row-span-10 flex justify-center items-center">
        <MyCardList />
      </div>

      <NavBar />
    </div>
  )
}
