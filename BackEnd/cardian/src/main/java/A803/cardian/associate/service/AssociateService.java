package A803.cardian.associate.service;


import A803.cardian.associate.data.dto.response.AssociationList;
import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssoiciateRepository;
import A803.cardian.category.data.dto.reponse.CategoryList;
import A803.cardian.category.domain.SubCommonCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AssociateService {
    private final AssoiciateRepository assoiciateRepository;
    public List<AssociationList> findAssociation(String categoryCode){
        List<Associate> associates= assoiciateRepository.findByCategoryCode(categoryCode);
        List<AssociationList> associationLists= new ArrayList<>();
        for(Associate associate : associates){
            AssociationList associationList=AssociationList.builder()
                    .associationId(associate.getId())
                    .associationName(associate.getName())
                    .associationImage(associate.getImage())
                    .build();
            associationLists.add(associationList);
        }
        return associationLists;
    }
}
