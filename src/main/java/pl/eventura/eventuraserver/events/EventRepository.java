package pl.eventura.eventuraserver.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {


    @Query(value = "SELECT e FROM Event e WHERE ((:text is null or lower(e.name) LIKE lower(CONCAT('%',:text,'%'))) or (:text is null or lower(e.summary) LIKE lower(CONCAT('%',:text,'%')))) and (CAST(:dateStart as date) is null or CAST(:dateEnd as date) is null or e.date >= CAST(:dateStart as date) and e.date <= CAST(:dateEnd as date)) order by e.date asc")
    List<Event> findByNameOrSummaryContainingOrDateIsBetween(String text, LocalDate dateStart, LocalDate dateEnd);

    List<Event> findByNameContaining(String name);

}
