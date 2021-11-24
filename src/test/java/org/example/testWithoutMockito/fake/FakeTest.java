package org.example.testWithoutMockito.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class FakeTest {

    @Test
    void takeFakeTest() {
        BookRepository bookRepository = new FakeBookRepository();
        BookService service = new BookService(bookRepository);

        service.addBook(new Book("1", "title_1", 123, LocalDate.now()));
        service.addBook(new Book("2", "title_2", 321, LocalDate.now()));


        Assertions.assertEquals(2, service.findNumberOfBooks());
    }

}