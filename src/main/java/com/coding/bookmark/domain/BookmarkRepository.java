package com.coding.bookmark.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {

    @Query("select new com.coding.bookmark.domain.BookmarkDTO(b.id,b.title,b.url,b.createdAt) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

    /*@Query("""
            select new com.coding.bookmark.domain.BookmarkDTO(b.title,b.url,b.creatAt) from Bookmark b
            where lower(b.title) like lower(concat('%',:query,'%' ))
            """)
    Page<BookmarkDTO> searchBookmarks(String query, Pageable pageable);*/

    Page<BookmarkDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);
}
