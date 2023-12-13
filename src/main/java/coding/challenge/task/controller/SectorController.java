package coding.challenge.task.controller;

import coding.challenge.task.dto.SectorDTO;
import coding.challenge.task.model.Sector;
import coding.challenge.task.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sector")
public class SectorController {

    private final SectorService sectorService;

    @GetMapping
    public ResponseEntity<List<SectorDTO>> getSector() {
        return new ResponseEntity<>(sectorService.getAllSector(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDTO> getSector(@PathVariable Long id) {
        return new ResponseEntity<>(sectorService.getSectorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SectorDTO> createSector(@RequestBody SectorDTO sectorDTO) {
        return new ResponseEntity<>(sectorService.createSector(sectorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SectorDTO> updateSector(@PathVariable Long id, @RequestBody SectorDTO sectorDTO) {
        return new ResponseEntity<>(sectorService.updateSector(id, sectorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSector(@PathVariable Long id) {
        sectorService.deleteSector(id);
    }
    @GetMapping("/{id}/withSubsectors")
    public ResponseEntity<SectorDTO> getSectorWithSubsectors(@PathVariable Long id) {
        SectorDTO sectorWithSubsectors = sectorService.getSectorWithSubsectors(id);
        return new ResponseEntity<>(sectorWithSubsectors, HttpStatus.OK);
    }
}



