package pl.eventura.eventuraserver.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/events")
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewEvent (@RequestParam String name, @RequestParam String summary, @RequestParam Integer event_category_id, @RequestParam Integer venue_id, @RequestParam String date, @RequestParam String logo) {
        Event n = new Event();
        n.setName(name);
        n.setSummary(summary);
        n.setEvent_category_id(event_category_id);
        n.setVenue_id(venue_id);
        n.setDate(date);
        n.setLogo(logo);
        eventRepository.save(n);
        return "New event saved!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping(path="/search")
    public @ResponseBody
    List<Event> getEvent(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "date", required = false) String date){
        if((name == null) && (date == null)) {
            return Collections.emptyList();
        }
        return eventRepository.findEvent(name, date);
    }

    @GetMapping(path="/search/{id}")
    public @ResponseBody
    Optional<Event> getSpecificEvent(@PathVariable int id) {
        return eventRepository.findById(id);
    }

}
