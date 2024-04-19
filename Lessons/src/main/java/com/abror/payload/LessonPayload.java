package com.abror.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LessonPayload {
    private String title;
    private String description;
    private String videoId;
    private Integer authorId;
}
