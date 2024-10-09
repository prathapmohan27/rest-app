package com.rest.rest_app.bootstrap;


import com.rest.rest_app.domain.Author;
import com.rest.rest_app.domain.Book;
import com.rest.rest_app.repositories.AuthorRepository;
import com.rest.rest_app.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");

        Book book = new Book();
        book.setTitle("The Book");
        book.setIsbn("1234567890");

        Author authorSaved = authorRepository.save(author);
        Book bookSaved =  bookRepository.save(book);

        authorSaved.getBooks().add(bookSaved);
        authorRepository.save(authorSaved);

        System.out.println("Bootstrap:");
        System.out.println("Author Count" + authorRepository.count());
        System.out.println("Book Count" + bookRepository.count());

    }
}
