package com.coding.bookmark.domain;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class BookmarksDTO {
   private List<BookmarkDTO> data;
   private long totalElements;
   private long totalPages;
   private int currentPage;
   private boolean isFirst;
   private boolean isLast;
   private boolean hasPrevious;
   private boolean hasNext;

   public BookmarksDTO(Page<BookmarkDTO> page){
      this.setData(page.getContent());
      this.setTotalElements(page.getTotalElements());
      this.setTotalPages(page.getTotalPages());
      this.setCurrentPage(page.getNumber() + 1);
      this.setFirst(page.isFirst());
      this.setLast(page.isLast());
      this.setHasPrevious(page.hasPrevious());
      this.setHasNext(page.hasNext());
   }
}
