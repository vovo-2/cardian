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

export default function BrandKeywordList({ keyword }: Keyword) {
  const [associationList, setAssociationList] = useState<Brand[]>();

  useEffect(() => {
    axios.post("/search/association", { search: keyword }).then(({ data }) => {
      setAssociationList(data);
    });
  }, [keyword]);

  return (
    <div className="h-96 overflow-auto scrollbar-hide">
      {associationList && associationList.length > 0 ? (
        associationList.map((associate) => (
          <Brand
            key={associate.associationId}
            categoryName={associate.categoryName}
            associationId={associate.associationId}
            associationName={associate.associationName}
            associationImage={associate.associationImage}
          />
        ))
      ) : (
        <div className="flex justify-center py-10">
          <span className="text-3xl font-semibold text-lightgray">검색 결과가 없습니다.</span>
        </div>
      )}
    </div>
  );
}
