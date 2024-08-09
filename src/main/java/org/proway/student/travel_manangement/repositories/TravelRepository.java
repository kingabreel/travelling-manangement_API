package org.proway.student.travel_manangement.repositories;

import org.proway.student.travel_manangement.models.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("SELECT t FROM Travel t WHERE t.destiny.id = :id")
    List<Travel> findTravelByDestiny(Long id);

    @Query("SELECT t FROM Travel t WHERE t.departure >= :startDate AND t.arrival <= :endDate")
    List<Travel> findTravelBetweenDate(LocalDate startDate, LocalDate endDate);

    List<Travel> findTravelByDepartureIsAfter(LocalDate date);

    List<Travel> findTravelByArrivalIsBefore(LocalDate date);

    List<Travel> findTravelByPriceLessThanEqual(double price);
}
