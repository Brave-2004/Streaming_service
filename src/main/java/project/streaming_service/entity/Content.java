package project.streaming_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import project.streaming_service.entity.templates.AbsLong;
import project.streaming_service.enums.AgeLimitEnum;
import project.streaming_service.enums.ContentTypeEnum;
import project.streaming_service.enums.PremiumSatusEnum;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class Content extends AbsLong {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer issueDate;

    @Column(nullable = false)
    private Integer duration;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ContentTypeEnum contentTypeEnum;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private AgeLimitEnum ageLimitEnum;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private PremiumSatusEnum premiumSatusEnum;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name = "content_actor",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name = "content_genre",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Rating> ratings;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<WatchHistory> watchHistories;

}
