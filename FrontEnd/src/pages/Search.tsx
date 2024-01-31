import BrandSearchBar from "../components/Search/BrandSearchBar";
import BrandCategory from "../components/Search/BrandCategory";
import BrandList from "../components/Search/BrandList";

export default function Search() {
  return (
    <div>
      <BrandSearchBar />
      <BrandCategory />
      <BrandList />
    </div>
  );
}
