package org.example.testWithoutMockito.stub;

import org.example.testWithoutMockito.fake.Book;
import org.example.testWithoutMockito.fake.BookRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StubBookRepository implements BookRepository {

    Map<String, Book> bookMap = new HashMap<>();

    @Override
    public Collection<Book> findAllBooks() {
        bookMap.put("1", new Book("1", "title_1", 500, LocalDate.now()));
        bookMap.put("2", new Book("2", "title_2", 400, LocalDate.now()));
        return bookMap.values();
    }

    @Override
    public void saveBook(Book book) {

    }
}
