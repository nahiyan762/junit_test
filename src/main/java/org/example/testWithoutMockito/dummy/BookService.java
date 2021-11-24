package org.example.testWithoutMockito.dummy;


import org.example.practicalunittesting.chp07.EmailServer;

public class BookService {
    private BookRepository bookRepository;
    private EmailService emailService;

    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAllBooks().size();
    }

    public void sendMailToBookReader(String message) {
        emailService.sendEmail(message);
    }
}
