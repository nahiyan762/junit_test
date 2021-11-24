package org.example.testWithoutMockito.dummy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class DummyTest {

    @Test
    void getTest() {
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService service = new BookService(bookRepository, emailService);

        service.addBook(new Book("1", "title_1", 123, LocalDate.now()));
        service.addBook(new Book("2", "title_2", 321, LocalDate.now()));

        Assertions.assertEquals(2, service.findNumberOfBooks());
    }

}