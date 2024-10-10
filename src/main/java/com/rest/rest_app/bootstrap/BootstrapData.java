package com.rest.rest_app.bootstrap;


import com.rest.rest_app.domain.Author;
import com.rest.rest_app.domain.Book;
import com.rest.rest_app.domain.Publisher;
import com.rest.rest_app.repositories.AuthorRepository;
import com.rest.rest_app.repositories.BookRepository;
import com.rest.rest_app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =  publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");

        Book book = new Book();
        book.setTitle("The Book");
        book.setIsbn("1234567890");

        Publisher publisher = new Publisher();
        publisher.setName("luffy");
        publisher.setCity("east blue");

        Author authorSaved = authorRepository.save(author);
        Book bookSaved =  bookRepository.save(book);
        Publisher publisherSaved =  publisherRepository.save(publisher);

        authorSaved.getBooks().add(bookSaved);
        authorRepository.save(authorSaved);
        bookSaved.setPublisher(publisherSaved);

        System.out.println("Bootstrap:");
        System.out.println("Author Count " + authorRepository.count());
        System.out.println("Book Count " + bookRepository.count());
        System.out.println("Publisher Count " + publisherRepository.count());

    }
}
