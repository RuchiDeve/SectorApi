package coding.challenge.task.repository;

import coding.challenge.task.model.SubSector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubSectorRepository extends JpaRepository<SubSector, Long> {
    List<SubSector> findBySectorId(Long sectorId);
    // You may add other methods as needed
}
