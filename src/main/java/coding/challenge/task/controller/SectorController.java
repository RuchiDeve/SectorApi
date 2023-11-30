package coding.challenge.task.controller;

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
    public ResponseEntity<List<Sector>> getSector() {
        return new ResponseEntity<>(sectorService.getAllSector(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSector(@PathVariable Long id) {
        return new ResponseEntity<>(sectorService.getSectorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sector> createSector(@RequestBody Sector sector) {
        return new ResponseEntity<>(sectorService.createSector(sector), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable Long id, @RequestBody Sector sector) {
        return new ResponseEntity<>(sectorService.updateSector(id, sector), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSector(@PathVariable Long id) {
        sectorService.deleteSector(id);
    }
}


