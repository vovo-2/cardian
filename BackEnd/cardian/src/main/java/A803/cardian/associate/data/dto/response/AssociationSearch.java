package A803.cardian.associate.data.dto.response;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class AssociationSearch {
    private Integer associationId;
    private String associationName;
    private String associationImage;
    private String categoryCode;
    private String categoryName;

}
