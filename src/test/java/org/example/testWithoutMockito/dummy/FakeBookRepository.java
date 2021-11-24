package org.example.testWithoutMockito.dummy;

import org.example.testWithoutMockito.dummy.Book;
import org.example.testWithoutMockito.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    Map<String, Book> bookMap = new HashMap<>();

    @Override
    public Collection<Book> findAllBooks() {
        return bookMap.values();
    }

    @Override
    public void saveBook(Book book) {
        bookMap.put(book.getBookId(), book);
    }
}
