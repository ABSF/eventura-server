package pl.eventura.eventuraserver.events;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer event_category_id;

    private String name;

    public Integer getEvent_category_id() {
        return event_category_id;
    }

    public void setEvent_category_id(Integer event_category_id) {
        this.event_category_id = event_category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
