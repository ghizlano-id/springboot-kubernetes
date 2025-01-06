package com.coding.bookmark.api;

import com.coding.bookmark.domain.BookmarkDTO;
import com.coding.bookmark.domain.BookmarkRequest;
import com.coding.bookmark.domain.BookmarksDTO;
import com.coding.bookmark.domain.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getAllBookmark(@RequestParam(name="page",defaultValue = "1") int page,
                                       @RequestParam(name="query",defaultValue = "") String query){
        if(StringUtils.isEmpty(query))
        {
            return bookmarkService.getAllBookmark(page);
        }
        return bookmarkService.searchBookmarks(query,page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid BookmarkRequest bookmarkRequest){
        return bookmarkService.createBookmark(bookmarkRequest);
    }
}
