package A803.cardian.associate.service;


import A803.cardian.associate.data.dto.response.AssociationList;
import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
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
    public List<AssociationList> findAssociation(String categoryCode){
        List<Associate> associates= associateRepository.findByCategoryCode(categoryCode);
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
