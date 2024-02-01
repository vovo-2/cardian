import { useState, useEffect } from "react";
import Brand from "./Brand";

import { axios } from "../../api";

type Brand = {
  associationId: number;
  associationName: string;
  associationImage: string;
};

interface Category {
  categoryCode: string;
  categoryName: string;
}

export default function BrandCategoryList({categoryCode, categoryName}: Category) {
  const [associationList, setAssociationList] = useState<Brand[]>();

  useEffect(() => {
    axios.get(`/search/${categoryCode}/association`).then(({ data }) => {
      setAssociationList(data);
    });
  }, [categoryCode]);

  return (
    <div className='h-96 overflow-auto scrollbar-hide'>
      {associationList &&
        associationList.map((associate) => {
          return (
            <Brand
              key={associate.associationId}
              categoryName={categoryName}
              associationName={associate.associationName}
              associationImage={associate.associationImage}
            />
          );
        })}
    </div>
  );
}
