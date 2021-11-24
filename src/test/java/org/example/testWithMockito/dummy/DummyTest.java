package org.example.testWithMockito.dummy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DummyTest {
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private EmailService emailService;

    @BeforeEach
    void init() {
        bookService = new BookService(bookRepository, emailService);
    }

    @Test
    void getDummyTest() {
        Book book_1 = new Book("1", "title_1", 123, LocalDate.now());
        Book book_2 = new Book("2", "title_2", 321, LocalDate.now());
        Collection<Book> books = new ArrayList<>();
        books.add(book_1);
        books.add(book_2);

        Mockito.when(bookRepository.findAllBooks()).thenReturn(books);

        Assertions.assertEquals(2, bookService.findNumberOfBooks());

    }
}