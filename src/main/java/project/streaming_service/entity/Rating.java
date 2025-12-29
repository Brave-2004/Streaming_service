package project.streaming_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.*;
import project.streaming_service.entity.templates.AbsLong;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Rating extends AbsLong {

    private Integer rate;
    @Size(min = 1,max = 10,message = "The rate of the content should be between 1 and 10")
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Content content;
}
