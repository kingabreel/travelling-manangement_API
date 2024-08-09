package org.proway.student.travel_manangement.controllers;

import org.proway.student.travel_manangement.models.Travel;
import org.proway.student.travel_manangement.models.dtos.TravelDto;
import org.proway.student.travel_manangement.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    // It must return a list of travels that have a departure date after the first entered date and an arrival date before the next entered date
    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<List<Travel>> getTravelsBetweenDates(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return service.getTravelsBetweenDates(startDate, endDate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody TravelDto travelDTO) {
        return service.updateTravel(id, travelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTravel(@PathVariable Long id) {
        return service.deleteTravel(id);
    }

    // It must return a list of travels that have a departure date after the date entered
    @GetMapping("/start/{startDate}")
    public ResponseEntity<List<Travel>> getTravelsByDepartureDate(@PathVariable LocalDate startDate) {
        System.out.println("OK");
        return service.getTravelsByStartDate(startDate);
    }

    // It must return a list of travels that have an arrival date before the date entered
    @GetMapping("/end/{endDate}")
    public ResponseEntity<List<Travel>> getTravelsByArrivalDate(@PathVariable LocalDate endDate) {
        return service.getTravelsByArrivalDate(endDate);
    }

    // returns the list of travels with the price below the inputted price
    @GetMapping("/price/{price}")
    public ResponseEntity<List<Travel>> getTravelsByPriceLessThan(@PathVariable double price) {
        return service.getTravelsByPrice(price);
    }
}
