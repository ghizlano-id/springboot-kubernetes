package com.coding.bookmark;

import com.coding.bookmark.domain.Bookmark;
import com.coding.bookmark.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<35;i++) {
            Faker faker = new Faker();
            String title = faker.book().title();
            bookmarkRepository.save(Bookmark.builder()
                    .title(title)
                    .url("https://" + title.replace(" ","_") + ".com")
                    .createdAt(Instant.now())
                    .build()
            );
        }
    }
}
