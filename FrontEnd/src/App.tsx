import { Route, Routes } from "react-router-dom";
import "./App.css";
import NavBar from "./layouts/NavBar";
import MyCardPage from "./pages/MyCardPage";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<MyCardPage />} />
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
