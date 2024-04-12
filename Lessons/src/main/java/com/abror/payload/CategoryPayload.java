package com.abror.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryPayload {
    private String name;
    private String authorName;
    private String authorDescription;
    private Long authorPhotoId;
    private String categoryType;
}
