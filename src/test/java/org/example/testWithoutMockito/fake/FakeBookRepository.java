package org.example.testWithoutMockito.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository{

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
