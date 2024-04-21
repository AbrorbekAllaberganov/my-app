package com.abror.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Author {
    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="category_id_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private String authorDescription;

    @Enumerated(EnumType.STRING)
    private CategoryType authorType;

    private String authorPhotoId;
}
