package coding.challenge.task.service.serviceImp;
import coding.challenge.task.dto.SectorDTO;
import coding.challenge.task.dto.SubSectorDTO;
import coding.challenge.task.model.Sector;
import coding.challenge.task.model.SubSector;
import coding.challenge.task.repository.SectorRepository;
import coding.challenge.task.repository.SubSectorRepository;
import coding.challenge.task.service.SectorService;
import coding.challenge.task.service.SubSectorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

@RequiredArgsConstructor
public class SectorServiceImp implements SectorService {

    private final SectorRepository sectorRepository;
    private final SubSectorRepository subSectorRepository;

    @Override
    public SectorDTO createSector(SectorDTO sectorDTO) {
        Sector newSector = Sector.builder().name(sectorDTO.getName()).build();

        List<SubSectorDTO> subSectorsDTO = sectorDTO.getSubSectors();
        if (subSectorsDTO != null && !subSectorsDTO.isEmpty()) {
            List<SubSector> subSectors = subSectorsDTO.stream()
                    .map(subSectorDTO -> SubSector.builder()
                            .name(subSectorDTO.getName())
                            .sector(newSector) // Set reference to the parent Sector
                            .build())
                    .collect(Collectors.toList());
            newSector.setSubSectors(subSectors);
        }

        Sector savedSector = sectorRepository.save(newSector);
        return SectorDTO.builder().id(savedSector.getId()).name(savedSector.getName()).build();
    }

    @Override
    public SectorDTO getSectorById(Long id) {
        Sector sector = sectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sector not found"));
        return SectorDTO.builder().id(sector.getId()).name(sector.getName()).build();
    }

    @Override
    public List<SectorDTO> getAllSector() {
        List<Sector> sectors = sectorRepository.findAll(); // Fetch all sectors

        return sectors.stream().map(sector -> {
            List<SubSectorDTO> subSectorDTOs = sector.getSubSectors().stream()
                    .map(subSector ->
                            SubSectorDTO.builder()
                                    .id(subSector.getId())
                                    .name(subSector.getName())
                                    .sectorId(sector.getId()) // Assuming you need the sector ID in sub-sector DTO
                                    .build())
                    .collect(Collectors.toList());

            // Map the Sector entity to SectorDTO along with its SubSectorDTOs
            return SectorDTO.builder()
                    .id(sector.getId())
                    .name(sector.getName())
                    .subSectors(subSectorDTOs)
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public SectorDTO updateSector(Long id, SectorDTO updatedSectorDTO) {
        Sector sector = sectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sector not found"));

        sector.setName(updatedSectorDTO.getName());
        Sector savedSector = sectorRepository.save(sector);

        return SectorDTO.builder().id(savedSector.getId()).name(savedSector.getName()).build();
    }

    @Override
    public void deleteSector(Long id) {
        sectorRepository.deleteById(id);
    }

    public List<SubSectorDTO> getSubSectorsBySectorId(Long sectorId) {
        List<SubSector> subSectors = subSectorRepository.findBySectorId(sectorId);
        return subSectors.stream().map(subSector ->
                        SubSectorDTO.builder().id(subSector.getId()).name(subSector.getName()).sectorId(sectorId).build())
                .collect(Collectors.toList());
    }

    public SectorDTO getSectorWithSubsectors(Long sectorId) {
        Sector sector = sectorRepository.findById(sectorId)
                .orElseThrow(() -> new RuntimeException("Sector not found"));

        List<SubSector> subSectors = subSectorRepository.findBySectorId(sectorId);

        SectorDTO sectorDTO = new SectorDTO();
        sectorDTO.setId(sector.getId());
        sectorDTO.setName(sector.getName());

        List<SubSectorDTO> subSectorDTOs = subSectors.stream()
                .map(subSector -> SubSectorDTO.builder()
                        .id(subSector.getId())
                        .name(subSector.getName())
                        .sectorId(sectorId)
                        .build())
                .collect(Collectors.toList());

        sectorDTO.setSubSectors(subSectorDTOs);

        return sectorDTO;
    }

}