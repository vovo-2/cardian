package A803.cardian.associate.data.dto.response;

import A803.cardian.associate.domain.Associate;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class AssociationList {
    private Integer associationId;
    private String associationName;
    private String associationImage;

    public static AssociationList from(Associate associate){


        return AssociationList.builder()
                .associationId(associate.getId())
                .associationName(associate.getName())
                .associationImage(associate.getImage())
                .build();
    }




}
