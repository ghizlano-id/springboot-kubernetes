package com.coding.bookmark.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkService {
    private final static int PAGE_SIZE = 10;
    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksDTO getAllBookmark(Integer page){
        page = page<0 ? 0 : page-1;
        Pageable pageable = PageRequest.of(page,PAGE_SIZE, Sort.Direction.DESC,"createdAt");
        return new BookmarksDTO(bookmarkRepository.findBookmarks(pageable));
    }

    public BookmarksDTO searchBookmarks(String query, int page) {
        page = page<0 ? 0 : page-1;
        Pageable pageable = PageRequest.of(page,PAGE_SIZE, Sort.Direction.DESC,"createdAt");
        //return new BookmarksDTO(bookmarkRepository.searchBookmarks(query,pageable));
        return new BookmarksDTO(bookmarkRepository.findByTitleContainsIgnoreCase(query,pageable));
    }

    public BookmarkDTO createBookmark(BookmarkRequest bookmarkRequest) {
        Bookmark bookmark = Bookmark.builder()
                .title(bookmarkRequest.title())
                .url(bookmarkRequest.url())
                .createdAt(Instant.now())
                .build();
        bookmarkRepository.saveAndFlush(bookmark);
        return bookmarkMapper.toDTO(bookmark);
    }
}
