package com.coding.bookmark.domain;

import jakarta.validation.constraints.NotEmpty;

public record BookmarkRequest(
        @NotEmpty(message=" Title should not be empty")
        String title,
        @NotEmpty(message=" Url should not be empty")
        String url
) {
}
