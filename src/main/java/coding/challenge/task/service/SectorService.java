package coding.challenge.task.service;

import coding.challenge.task.model.Sector;

import java.util.List;

public interface SectorService {
    Sector createSector(Sector sector);
    Sector getSectorById(Long id);
    List<Sector> getAllSector();
    Sector updateSector(Long id, Sector updatedSector);
    void deleteSector(Long id);
}