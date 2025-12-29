package project.streaming_service.entity;

import jakarta.persistence.Column;
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
public class Actor extends AbsLong {

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors")
    @ToString.Exclude
    private Set<Content> contents;

}
