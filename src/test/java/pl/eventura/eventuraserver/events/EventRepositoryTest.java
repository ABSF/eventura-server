package pl.eventura.eventuraserver.events;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @Test
    void findByNameOrSummaryContainingOrDateIsBetween_returnEvent() {
        LocalDate date = LocalDate.parse("2019-01-01");
        LocalDate startDate = date.plusDays(-7);
        LocalDate endDate = date.plusDays(7);
        Event testEvent = new Event("test", "testsummary", "testCategory", "testVenue", date, "testlogo");
        entityManager.persist(testEvent);
        entityManager.flush();

        List<Event> foundTestEvent = eventRepository.findByNameOrSummaryContainingOrDateIsBetween(testEvent.getName(), startDate, endDate);

        assertEquals(testEvent.getName(), foundTestEvent.get(0).getName());
    }

    @Test
    void findByNameContaining_returnEvent() {
        LocalDate date = LocalDate.parse("2019-01-01");
        Event testEvent = new Event("test", "testsummary", "testCategory", "testVenue", date, "testlogo");
        entityManager.persist(testEvent);
        entityManager.flush();

        List<Event> foundTestEvent = eventRepository.findByNameContaining(testEvent.getName());

        assertEquals(testEvent.getName(), foundTestEvent.get(0).getName());
    }

}