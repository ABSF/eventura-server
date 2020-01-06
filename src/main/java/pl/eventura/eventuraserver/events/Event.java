package pl.eventura.eventuraserver.events;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="event_id_seq", initialValue=1, allocationSize = 1)
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="event_id_seq")
    private Integer event_id;

    private String name;

    private String summary;

    private String event_category;

    private String venue;

    private LocalDate date;

    private String logo;

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEvent_category() {
        return event_category;
    }

    public void setEvent_category(String event_category) {
        this.event_category = event_category;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
