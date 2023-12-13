package coding.challenge.task.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubSectorDTO {
    private Long id;
    private String name;
    private Long sectorId;
}

