package org.proway.student.travel_manangement.services;

import jakarta.persistence.EntityNotFoundException;
import org.proway.student.travel_manangement.models.Destiny;
import org.proway.student.travel_manangement.models.Travel;
import org.proway.student.travel_manangement.models.dtos.TravelDto;
import org.proway.student.travel_manangement.repositories.DestinyRepository;
import org.proway.student.travel_manangement.repositories.TravelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {
    @Autowired
    private TravelRepository repository;

    @Autowired
    private DestinyRepository destinyRepository;

    public ResponseEntity<Travel> createTravel(TravelDto travelDto) {
        var travel = new Travel();
        BeanUtils.copyProperties(travelDto, travel);
        var destiny = destinyRepository.findById(travelDto.destiny().getId());

        try {
            if (destiny.isEmpty()) throw new EntityNotFoundException();
            travel.setDestiny(destiny.get());

            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(travel));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Travel> getTravelById(Long id) {
        try {
            var travel = repository.findById(id);
            if (travel.isEmpty()) throw new EntityNotFoundException();

            return ResponseEntity.status(HttpStatus.OK).body(travel.get());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<List<Travel>> getTravels() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    public ResponseEntity<List<Travel>> getTravelsByDestiny(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findTravelByDestiny(id));
    }

    public ResponseEntity<Travel> updateTravel(Long id, TravelDto travelDTO) {
        try {
            Optional<Travel> travelOptional = repository.findById(id);

            if (travelOptional.isEmpty()) throw new EntityNotFoundException();

            Travel travel = travelOptional.get();

            Destiny destiny = destinyRepository.findById(travelDTO.destiny().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Destiny not found"));

            BeanUtils.copyProperties(travelDTO, travel);
            travel.setDestiny(destiny);

            return ResponseEntity.status(HttpStatus.OK).body(repository.save(travel));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<String> deleteTravel(Long id) {
        try {
            repository.getReferenceById(id);
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Travel canceled");
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }
}
