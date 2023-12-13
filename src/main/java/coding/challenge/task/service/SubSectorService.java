package coding.challenge.task.service;


import coding.challenge.task.dto.SubSectorDTO;

import java.util.List;

public interface SubSectorService {
    SubSectorDTO createSubSector(SubSectorDTO subSectorDTO);
    List<SubSectorDTO> getSubSectorsBySectorId(Long sectorId);
    List<SubSectorDTO> getAllSubSectors();
    SubSectorDTO updateSubSector(Long id, SubSectorDTO updatedSubSectorDTO);
    void deleteSubSector(Long id);

    SubSectorDTO getSubSectorById(Long id);
}

