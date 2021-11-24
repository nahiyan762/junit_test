package org.example.testWithMockito.spy;

import org.example.testWithMockito.fake.Book;
import org.example.testWithMockito.fake.BookRepository;
import org.example.testWithMockito.fake.BookService;
import org.example.testWithoutMockito.spy.SpyBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SpyTest {
    private BookService bookService;
    @Spy
    private BookRepository bookRepository;

    @BeforeEach
    void init() {
        bookService = new BookService(bookRepository);
    }

    @Test
    void takeSpyTest() {
        Book book_1 = new Book("1", "title_1", 123, LocalDate.now());
        Book book_2 = new Book("2", "title_2", 321, LocalDate.now());

        bookService.addBook(book_1);
//        bookService.addBook(book_2);

        Mockito.verify(bookRepository, Mockito.times(1)).saveBook(book_1);

    }
}
