package pl.eventura.eventuraserver.events;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {


    @Query(value = "SELECT e FROM Event e WHERE (:name is null or e.name LIKE CONCAT('%',:name,'%')) or ( e.date LIKE CONCAT('%',:date,'%') or (:date is null))")
    List<Event> findEventByNameAndDate(@Param("name") String name, @Param("date") String date);

}
