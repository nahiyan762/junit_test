package org.example.testWithMockito.stub;

import org.example.testWithMockito.fake.Book;
import org.example.testWithMockito.fake.BookRepository;
import org.example.testWithMockito.fake.BookService;
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

@ExtendWith(MockitoExtension.class)
public class StubTest {
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void init() {
        bookService = new BookService(bookRepository);
    }

    @Test
    void getFakeTest() {
        Book book_1 = new Book("1", "title_1", 500, LocalDate.now());
        Book book_2 = new Book("2", "title_2", 400, LocalDate.now());
        Collection<Book> books = new ArrayList<>();
        books.add(book_1);
        books.add(book_2);

        Mockito.when(bookRepository.findAllBooks()).thenReturn(books);

        ArrayList<Book> newBookPrice = new ArrayList<>(bookService.getNewBooksWithAppliedDiscount(10));

        Assertions.assertEquals(450, newBookPrice.get(0).getPrice());
    }
}
