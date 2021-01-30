package javaldz26.eventaggregationservicecollection.dto;

import java.time.LocalDateTime;

public class EventDto {

    private Long id;

    private String eventTitle;

    private String eventDescription;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public EventDto(Long id, String eventTitle, String eventDescription, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
