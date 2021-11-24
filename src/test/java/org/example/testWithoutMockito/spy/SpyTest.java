package org.example.testWithoutMockito.spy;

import org.example.testWithoutMockito.fake.Book;
import org.example.testWithoutMockito.fake.BookRepository;
import org.example.testWithoutMockito.fake.BookService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpyTest {

    @Test
    void takeSpyTest() {
        SpyBookRepository spyBookRepository = new SpyBookRepository();
        BookService service = new BookService(spyBookRepository);

        service.addBook(new Book("1", "title_1", 123, LocalDate.now()));
        service.addBook(new Book("2", "title_2", 321, LocalDate.now()));


        Assertions.assertEquals(2, spyBookRepository.getTimesCalled());
    }
}
