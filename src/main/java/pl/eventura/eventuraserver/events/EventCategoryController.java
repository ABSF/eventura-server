package pl.eventura.eventuraserver.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/events-category")
public class EventCategoryController {
    private final EventCategoryRepository eventCategoryRepository;

    public EventCategoryController(EventCategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<EventCategory> getAllEvents() {
        return eventCategoryRepository.findAll();
    }


    @PostMapping(path="/add")
    public @ResponseBody String addNewEventCategory (@RequestParam String name) {
        EventCategory n = new EventCategory();
        n.setName(name);
        eventCategoryRepository.save(n);
        return "New event category saved!";
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<EventCategory> getSpecificEventCategory(@PathVariable int id) {
        return eventCategoryRepository.findById(id);
    }
}
