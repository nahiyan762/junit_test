package org.example.testWithMockito.dummy;

import java.util.Collection;

public interface BookRepository {
    Collection<Book> findAllBooks();

    void saveBook(Book book);
}
