package org.proway.student.travel_manangement.services;

import jakarta.persistence.EntityNotFoundException;
import org.proway.student.travel_manangement.models.Destiny;
import org.proway.student.travel_manangement.models.dtos.DestinyDto;
import org.proway.student.travel_manangement.repositories.DestinyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinyService {

    @Autowired
    private DestinyRepository repository;

    public ResponseEntity<Destiny> createDestiny(DestinyDto destinyDTO) {
        Destiny destiny = new Destiny();
        BeanUtils.copyProperties(destinyDTO, destiny);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(destiny));
    }

    public ResponseEntity<List<Destiny>> getAllDestinies() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    public ResponseEntity<Destiny> getDestinyById(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).orElseThrow(()
                    -> new EntityNotFoundException("Destiny not found")));
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Destiny> updateDestiny(Long id, DestinyDto destinyDTO) {
        try {
            Optional<Destiny> destinyOptional = repository.findById(id);

            if (destinyOptional.isEmpty()) throw new EntityNotFoundException();

            var destiny = destinyOptional.get();

            BeanUtils.copyProperties(destinyDTO, destiny);
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(destiny));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<String> deleteDestiny(Long id) {
        try {
            repository.getReferenceById(id);
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Travel canceled");
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }
}
