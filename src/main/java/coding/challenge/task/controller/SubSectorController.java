package coding.challenge.task.controller;


import coding.challenge.task.dto.SubSectorDTO;
import coding.challenge.task.service.SubSectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subsector")
public class SubSectorController {

    private final SubSectorService subSectorService;

    @GetMapping("/{sectorId}/sector")
    public ResponseEntity<List<SubSectorDTO>> getSubSectorsBySectorId(@PathVariable Long sectorId) {
        return new ResponseEntity<>(subSectorService.getSubSectorsBySectorId(sectorId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubSectorDTO> getSubSector(@PathVariable Long id) {
        return new ResponseEntity<>(subSectorService.getSubSectorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubSectorDTO> createSubSector(@RequestBody SubSectorDTO subSectorDTO) {
        return new ResponseEntity<>(subSectorService.createSubSector(subSectorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubSectorDTO> updateSubSector(@PathVariable Long id, @RequestBody SubSectorDTO subSectorDTO) {
        return new ResponseEntity<>(subSectorService.updateSubSector(id, subSectorDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSubSector(@PathVariable Long id) {
        subSectorService.deleteSubSector(id);
    }
    @GetMapping("/{id}/withSector")
    public ResponseEntity<SubSectorDTO> getSubSectorWithSector(@PathVariable Long id) {
        SubSectorDTO subSectorWithSector = subSectorService.getSubSectorById(id);
        return new ResponseEntity<>(subSectorWithSector, HttpStatus.OK);
    }

}
