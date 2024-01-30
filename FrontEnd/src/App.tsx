import { Route, Routes } from "react-router-dom";
import "./App.css";
import NavBar from "./layouts/NavBar";
import MyCardPage from "./pages/MyCardPage";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<MyCardPage />} />
        <Route path="/mycard">
          <Route index element={<MyCardPage />} />
          <Route path=":card_id" element={<div> 카드 상세 정보 </div>} />
        </Route>
        <Route path="/search" element={<div>mycard</div>} />
        <Route path="/analysis" element={<div>mycard</div>} />
        <Route path="/recommendation" element={<div>mycard</div>} />
        <Route path="/menu" element={<div>mycard</div>} />
      </Routes>
      <NavBar />
    </>
  );
}

export default App;
