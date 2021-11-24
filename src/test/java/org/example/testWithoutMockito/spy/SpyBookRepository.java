package org.example.testWithoutMockito.spy;

import org.example.testWithoutMockito.fake.Book;
import org.example.testWithoutMockito.fake.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpyBookRepository implements BookRepository {

    Map<String, Book> bookMap = new HashMap<>();
    private int timesCalled = 0;

    @Override
    public Collection<Book> findAllBooks() {
        return bookMap.values();
    }

    @Override
    public void saveBook(Book book) {
        timesCalled++;
        bookMap.put(book.getBookId(), book);
    }

    public int getTimesCalled() {
        return timesCalled;
    }
}
