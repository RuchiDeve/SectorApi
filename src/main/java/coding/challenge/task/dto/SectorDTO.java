package coding.challenge.task.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectorDTO {
    private Long id;
    private String name;
    private List<SubSectorDTO> subSectors;
}
