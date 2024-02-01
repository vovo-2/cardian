import { useState, useEffect } from "react";
import Brand from "./Brand";

import { axios } from "../../api";

type Brand = {
  associationId: number;
  associationName: string;
  associationImage: string;
  categoryCode: string;
  categoryName: string;
};

interface Keyword {
  keyword: string;
}

export default function BrandKeywordList({keyword}: Keyword) {
  const [associationList, setAssociationList] = useState<Brand[]>();

  useEffect(() => {
    axios.post('/search/association', {search: keyword}).then(({ data }) => {
      setAssociationList(data);
    });
  }, [keyword]);

  return (
    <div className='h-96 overflow-auto scrollbar-hide'>
      {associationList &&
        associationList.map((associate) => {
          return (
            <Brand
              key={associate.associationId}
              categoryName={associate.categoryName}
              associationName={associate.associationName}
              associationImage={associate.associationImage}
            />
          );
        })}
    </div>
  );
}
