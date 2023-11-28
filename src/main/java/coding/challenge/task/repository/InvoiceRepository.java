package coding.challenge.task.repository;

import coding.challenge.task.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // You can add custom query methods here if needed
}
