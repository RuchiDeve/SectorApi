package coding.challenge.task.service.serviceImp;

import coding.challenge.task.dto.SectorDTO;
import coding.challenge.task.model.Sector;
import coding.challenge.task.repository.SectorRepository;
import coding.challenge.task.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImp implements SectorService {
    private final SectorRepository sectorRepository;

    @Override
    public SectorDTO createSector(SectorDTO sectorDTO) {
       Sector saveSector = Sector.builder()
                .name(sectorDTO.getName())
                .build();
        Sector savedSector = sectorRepository.save(saveSector);
        SectorDTO savedSectorDTO = SectorDTO.builder()
                .name(savedSector.getName())
                .build();
        return savedSectorDTO;
    }
    @Override
    public SectorDTO getSectorById(Long id) {
        Sector sector = sectorRepository.findById(id).orElseThrow(()->new RuntimeException("Sector not found"));
        SectorDTO sectorDTO = SectorDTO.builder()
                .name(sector.getName())
                .build();
        return sectorDTO;
    }

    @Override
    public List<SectorDTO> getAllSector() {
        List<Sector> sectors = sectorRepository.findAll();
return sectors.stream()
                .map(sector -> SectorDTO.builder()
                        .name(sector.getName())
                        .build())
                .collect(java.util.stream.Collectors.toList());

    }

    @Override
    public SectorDTO updateSector(Long id, SectorDTO updatedSectorDTO) {
        Sector sector = sectorRepository.findById(id).orElse(null);
        if (sector != null) {
            sector.setName(updatedSectorDTO.getName());
            Sector savedSector = sectorRepository.save(sector);
            SectorDTO savedSectorDTO = SectorDTO.builder()
                    .name(savedSector.getName())
                    .build();
            return savedSectorDTO;
        }
        return null;
    }

    @Override
    public void deleteSector(Long id) {
        sectorRepository.deleteById(id);
    }

}
