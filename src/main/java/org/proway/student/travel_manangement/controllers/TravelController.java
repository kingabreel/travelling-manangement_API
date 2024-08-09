package org.proway.student.travel_manangement.controllers;

import org.proway.student.travel_manangement.models.Travel;
import org.proway.student.travel_manangement.models.dtos.TravelDto;
import org.proway.student.travel_manangement.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travel")
public class TravelController {
    @Autowired
    private TravelService service;

    @PostMapping
    public ResponseEntity<Travel> createTravel(@RequestBody TravelDto travel){
        return service.createTravel(travel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        return service.getTravelById(id);
    }

    @GetMapping
    public ResponseEntity<List<Travel>> getTravels() {
        return service.getTravels();
    }

    @GetMapping("/destiny/{destinyId}/travel")
    public ResponseEntity<List<Travel>> getTravelsByDestiny(@PathVariable Long destinyId) {
        return service.getTravelsByDestiny(destinyId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody TravelDto travelDTO) {
        return service.updateTravel(id, travelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTravel(@PathVariable Long id) {
        return service.deleteTravel(id);
    }
}
