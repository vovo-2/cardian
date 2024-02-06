import { Route, Routes } from "react-router-dom";

import NavBar from "./layouts/NavBar";
import MyCardPage from "./pages/MyCardPage";
import CardDetailPage from "./pages/CardDetailPage";
import "./App.css";
import SearchPage from "./pages/SearchPage";
import BrandRecommendationPage from "./pages/BrandRecommendationPage";
import AnalysisPage from "./pages/AnalysisPage";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<MyCardPage />} />
        <Route path="/mycard">
          <Route index element={<MyCardPage />} />
          <Route path=":card_id" element={<CardDetailPage />} />
        </Route>
        <Route path="/search" element={<SearchPage />} />
        <Route path="/analysis" element={<AnalysisPage />} />
        <Route path="/recommendation" element={<div>recommendation</div>} />
        <Route path="/menu" element={<div>menu</div>} />
        <Route path="/brand/:associationId" element={<BrandRecommendationPage />} />

        {/* 404 처리 */}
        <Route path="/*" element={<div>404 Error</div>} />
      </Routes>
      <NavBar />
    </>
  );
}

export default App;
