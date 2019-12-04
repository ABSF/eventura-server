package pl.eventura.eventuraserver.events;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="event_id_seq", initialValue=1, allocationSize = 1)
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="event_id_seq")
    private Integer event_id;

    private String name;

    private String summary;

    private Integer event_category_id;

    private Integer venue_id;

    private String date;

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

    public Integer getEvent_category_id() {
        return event_category_id;
    }

    public void setEvent_category_id(Integer event_category_id) {
        this.event_category_id = event_category_id;
    }

    public Integer getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Integer venue_id) {
        this.venue_id = venue_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
