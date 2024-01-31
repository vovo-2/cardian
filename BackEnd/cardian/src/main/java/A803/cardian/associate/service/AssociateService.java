package A803.cardian.associate.service;


import A803.cardian.associate.data.dto.response.AssociationList;
import A803.cardian.associate.data.dto.response.AssociationSearch;
import A803.cardian.associate.data.dto.response.Search;
import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.category.repository.SubCommonRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AssociateService {
    private final AssociateRepository associateRepository;
    private final SubCommonRepository subCommonRepository;



    public List<AssociationList> findAssociation(String categoryCode){
        List<AssociationList> associationList= new ArrayList<>();
        List<Associate> associates= associateRepository.findByCategoryCode(categoryCode);
        for(Associate associate : associates){
            AssociationList list=AssociationList.builder()
                    .associationId(associate.getId())
                    .associationName(associate.getName())
                    .associationImage(associate.getImage())
                    .build();
            associationList.add(list);
        }

        return associationList;
    }

    public List<AssociationSearch> searchAssociation(Search search){
        String s= search.getSearch();
        List<Associate> associates= associateRepository.findByNameContaining(s);
        List<AssociationSearch> associationSearchList= new ArrayList<>();
        for(Associate associate : associates){
            String cateCode=associate.getCategoryCode();
            String cateName= subCommonRepository.findByDetailCode(cateCode).orElse(null);
            AssociationSearch list=AssociationSearch.builder()
                    .associationId(associate.getId())
                    .associationName(associate.getName())
                    .associationImage(associate.getImage())
                    .categoryName(cateName)
                    .categoryCode(associate.getCategoryCode())
                    .build();
            associationSearchList.add(list);
        }

        return associationSearchList;
    }
}
