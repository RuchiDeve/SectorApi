package coding.challenge.task.service;

import coding.challenge.task.dto.SectorDTO;
import coding.challenge.task.model.Sector;

import java.util.List;

public interface SectorService {
    SectorDTO createSector(SectorDTO sectorDTO);
    SectorDTO getSectorById(Long id);
    List<SectorDTO> getAllSector();
    SectorDTO updateSector(Long id, SectorDTO updatedSectorDTO);
    void deleteSector(Long id);

}