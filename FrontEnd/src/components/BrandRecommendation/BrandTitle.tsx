import { useLocation } from "react-router-dom";

export default function BrandTitle() {

  const location = useLocation();
  const associationName = location.state?.associationName;

  return (
    <div className="flex justify-center text-3xl font-semibold mb-3">
        <span>{associationName}</span>
    </div>
  )
}
