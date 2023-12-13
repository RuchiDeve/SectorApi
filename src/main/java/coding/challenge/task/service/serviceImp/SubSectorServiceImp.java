package coding.challenge.task.service.serviceImp;

import coding.challenge.task.dto.SubSectorDTO;
import coding.challenge.task.model.SubSector;
import coding.challenge.task.repository.SubSectorRepository;
import coding.challenge.task.repository.SectorRepository;
import coding.challenge.task.service.SubSectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubSectorServiceImp implements SubSectorService {

    private final SubSectorRepository subSectorRepository;
    private final SectorRepository sectorRepository;

    @Override
    public SubSectorDTO createSubSector(SubSectorDTO subSectorDTO) {
        SubSector subSector = mapDtoToEntity(subSectorDTO);
        SubSector savedSubSector = subSectorRepository.save(subSector);
        return mapEntityToDto(savedSubSector);
    }

    public List<SubSectorDTO> getSubSectorsBySectorId(Long sectorId) {
        List<SubSector> subSectors = subSectorRepository.findBySectorId(sectorId);
        return subSectors.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubSectorDTO> getAllSubSectors() {
        List<SubSector> subSectors = subSectorRepository.findAll();
        return subSectors.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubSectorDTO updateSubSector(Long id, SubSectorDTO updatedSubSectorDTO) {
        SubSector subSector = subSectorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Subsector not found"));

        subSector.setName(updatedSubSectorDTO.getName());

        SubSector savedSubSector = subSectorRepository.save(subSector);
        return mapEntityToDto(savedSubSector);
    }

    @Override
    public void deleteSubSector(Long id) {
        subSectorRepository.deleteById(id);
    }

    @Override
    public SubSectorDTO getSubSectorById(Long id) {
        SubSector subSector = subSectorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Subsector not found"));

        return mapEntityToDto(subSector);
    }

    private SubSectorDTO mapEntityToDto(SubSector subSector) {
        SubSectorDTO subSectorDTO = new SubSectorDTO();
        subSectorDTO.setId(subSector.getId());
        subSectorDTO.setName(subSector.getName());
        subSectorDTO.setSectorId(subSector.getSector().getId()); // Assuming Sector is fetched along with SubSector
        return subSectorDTO;
    }

    private SubSector mapDtoToEntity(SubSectorDTO subSectorDTO) {
        SubSector subSector = new SubSector();
        subSector.setId(subSectorDTO.getId());
        subSector.setName(subSectorDTO.getName());
        subSector.setSector(sectorRepository.findById(subSectorDTO.getSectorId())
                .orElseThrow(() -> new IllegalArgumentException("Sector not found")));
        return subSector;
    }
}
