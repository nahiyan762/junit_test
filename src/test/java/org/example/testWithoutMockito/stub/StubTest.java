package org.example.testWithoutMockito.stub;

import org.example.testWithoutMockito.fake.Book;
import org.example.testWithoutMockito.fake.BookRepository;
import org.example.testWithoutMockito.fake.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StubTest {

    @Test
    void getTest() {
        BookRepository bookRepository = new StubBookRepository();
        BookService service = new BookService(bookRepository);

        Assertions.assertEquals(2, service.findNumberOfBooks());

        ArrayList<Book> newBookPrice = new ArrayList<>(service.getNewBooksWithAppliedDiscount(10));

        Assertions.assertEquals(450, newBookPrice.get(0).getPrice());
    }
}
