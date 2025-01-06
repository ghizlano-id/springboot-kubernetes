package com.coding.bookmark.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
public class BookmarkDTO{
    private long id;
    private String title;
    private String url;
    private Instant createdAt;
}
