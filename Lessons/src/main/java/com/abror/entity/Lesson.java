package com.abror.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Lesson {
    @Id
    @SequenceGenerator(
            name = "lesson_id_sequence",
            sequenceName = "lesson_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="lesson_id_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String videoId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @CreationTimestamp
    Date createdAt;
}
