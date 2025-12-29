package project.streaming_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import project.streaming_service.entity.templates.AbsLong;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class WatchHistory extends AbsLong {

    private LocalDate watchDate;

    private Integer progress;

    @ManyToOne
    private User user;

    @ManyToOne
    private Content content;

}
