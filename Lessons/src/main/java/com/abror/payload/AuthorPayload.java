package com.abror.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorPayload {
    private String authorName;
    private String authorDescription;
    private String authorPhotoId;
    private String authorType;
}
