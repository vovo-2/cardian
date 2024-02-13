import { Route, Routes } from "react-router-dom";

import NavBar from "./layouts/NavBar";
import MyCardPage from "./pages/MyCardPage";
import CardDetailPage from "./pages/CardDetailPage";
import "./App.css";
import SearchPage from "./pages/SearchPage";
import LoginPage from "./pages/LoginPage";
import CardRecommendPage from "./pages/CardRecommendPage";
import BrandRecommendationPage from "./pages/BrandRecommendationPage";
import AnalysisPage from "./pages/AnalysisPage";
import ProtectedRoute from "./routes/ProtectedRoute";
import MenuPage from "./pages/MenuPage";

function App() {
  return (
    <>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route element={<ProtectedRoute />}>
          <Route path="/" element={<MyCardPage />} />
          <Route path="/mycard">
            <Route index element={<MyCardPage />} />
            <Route path=":card_id" element={<CardDetailPage />} />
          </Route>
          <Route path="/search" element={<SearchPage />} />
          <Route path="/recommendation" element={<CardRecommendPage />} />
          <Route path="/analysis/:activeFunc" element={<AnalysisPage />} />
          <Route path="/menu" element={<MenuPage />} />
          <Route
            path="/brand/:associationId"
            element={<BrandRecommendationPage />}
          />
        </Route>

        {/* 404 처리 */}
        <Route path="/*" element={<div>404 Error</div>} />
      </Routes>
      <NavBar />
    </>
  );
}

export default App;
