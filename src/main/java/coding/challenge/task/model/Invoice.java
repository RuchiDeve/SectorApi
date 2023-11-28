package coding.challenge.task.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
 @Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(nullable = false)
    @NotNull
    private BigDecimal amount;

    @Column(name = "purpose_of_payment", nullable = false)
    @NotEmpty
    private String purposeOfPayment;

    @NotEmpty
    private String description;

    @NotEmpty
    @Column(nullable = false)
    private String status;

    @CreationTimestamp()
    private LocalDateTime created_at;

    @PrePersist
    public void prePersist() {
        created_at = LocalDateTime.now();
    }
}
