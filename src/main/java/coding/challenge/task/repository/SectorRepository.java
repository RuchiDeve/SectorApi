package coding.challenge.task.repository;

import coding.challenge.task.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    Optional<Sector> findById(Long id);
    // You may add other methods as needed
}
