package pl.eventura.eventuraserver.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/events")
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewEvent (@RequestParam int id, @RequestParam String name, @RequestParam String summary, @RequestParam Integer event_category_id, @RequestParam Integer venue_id, @RequestParam String date, @RequestParam String logo) {
        Event n = new Event();
        n.setEvent_id(id);
        n.setName(name);
        n.setSummary(summary);
        n.setEvent_category_id(event_category_id);
        n.setVenue_id(venue_id);
        n.setDate(date);
        n.setLogo(logo);
        eventRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Event> getSpecificEvent(@PathVariable int id) {
        return eventRepository.findById(id);
    }




}
