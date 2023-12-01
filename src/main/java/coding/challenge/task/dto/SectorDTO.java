package coding.challenge.task.dto;

import jakarta.persistence.*;
import lombok.*;


@Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Builder
    @Table(name = "sectors")
    public class SectorDTO {
        @Id
        private Long id;
        private String name;
    }

