package project.streaming_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import project.streaming_service.entity.templates.AbsLong;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class Genre extends AbsLong {

    private String name;

    @ManyToMany(mappedBy = "genres")
    @ToString.Exclude
    private Set<Content> contents;

}
