package org.example.testWithMockito.fake;


import java.util.Collection;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAllBooks().size();
    }

    public Collection<Book> getNewBooksWithAppliedDiscount(int discountRate){
        Collection<Book> newBooks = bookRepository.findAllBooks();
        // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450

        for(Book book : newBooks){
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }

        return newBooks;
    }
}
