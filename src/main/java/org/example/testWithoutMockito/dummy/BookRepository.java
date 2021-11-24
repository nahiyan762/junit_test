package org.example.testWithoutMockito.dummy;

import java.util.Collection;

public interface BookRepository {
    Collection<Book> findAllBooks();

    void saveBook(Book book);
}
