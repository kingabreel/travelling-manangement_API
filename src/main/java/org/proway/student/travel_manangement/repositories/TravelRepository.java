package org.proway.student.travel_manangement.repositories;

import org.proway.student.travel_manangement.models.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("SELECT t FROM Travel t WHERE t.destiny.id = :id")
    List<Travel> findTravelByDestiny(Long id);
}
