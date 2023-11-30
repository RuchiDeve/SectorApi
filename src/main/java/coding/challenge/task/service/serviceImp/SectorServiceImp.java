package coding.challenge.task.service.serviceImp;

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
    public Sector createSector(Sector sector) {
        return sectorRepository.save(sector);
    }

//return invoiceRepository.save(invoice);


    @Override
    public Sector getSectorById(Long id) {
        return sectorRepository.findById(id).get();
    }
    @Override
    public List<Sector> getAllSector() {

        return sectorRepository.findAll();
    }
    @Override
    public Sector updateSector(Long id, Sector updatedSector) {
        Sector existingSector = sectorRepository.findById(id).orElse(null);
        if (existingSector != null) {
            return sectorRepository.save(updatedSector);
        }
        return null;
    }
    @Override
    public void deleteSector(Long id) {

        sectorRepository.deleteById(id);
    }
}
