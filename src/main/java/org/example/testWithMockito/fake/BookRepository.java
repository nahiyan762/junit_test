package org.example.testWithMockito.fake;

import java.util.Collection;

public interface BookRepository {
    Collection<Book> findAllBooks();

    void saveBook(Book book);
}
