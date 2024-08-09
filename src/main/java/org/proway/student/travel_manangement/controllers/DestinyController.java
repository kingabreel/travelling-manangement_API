package org.proway.student.travel_manangement.controllers;

import org.proway.student.travel_manangement.models.Destiny;
import org.proway.student.travel_manangement.models.dtos.DestinyDto;
import org.proway.student.travel_manangement.services.DestinyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destiny")
public class DestinyController {
    @Autowired
    private DestinyService service;

    @PostMapping
    public ResponseEntity<Destiny> createDestiny(@RequestBody DestinyDto destinyDTO) {
        return service.createDestiny(destinyDTO);
    }

    @GetMapping
    public ResponseEntity<List<Destiny>> getAllDestinies() {
        return service.getAllDestinies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destiny> getDestinyById(@PathVariable Long id) {
        return service.getDestinyById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destiny> updateDestiny(@PathVariable Long id, @RequestBody DestinyDto destinyDTO) {
        return service.updateDestiny(id, destinyDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDestiny(@PathVariable Long id) {
        return service.deleteDestiny(id);
    }
}
