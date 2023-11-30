package coding.challenge.task.repository;

import coding.challenge.task.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    // You can add custom query methods here if needed
}
