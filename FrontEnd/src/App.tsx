import { Route, Routes } from "react-router-dom";

import NavBar from "./layouts/NavBar";
import MyCardPage from "./pages/MyCardPage";
import CardDetailPage from "./pages/CardDetailPage";
import "./App.css";
import Search from "./pages/Search";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<MyCardPage />} />
        <Route path="/mycard">
          <Route index element={<MyCardPage />} />
          <Route path=":card_id" element={<CardDetailPage />} />
        </Route>
        <Route path="/search" element={<Search />} />
        <Route path="/analysis" element={<div>mycard</div>} />
        <Route path="/recommendation" element={<div>mycard</div>} />
        <Route path="/menu" element={<div>mycard</div>} />
      </Routes>
      <NavBar />
    </>
  );
}

export default App;
