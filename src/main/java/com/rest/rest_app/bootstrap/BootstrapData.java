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
        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Smith");

        Author author2 = new Author();
        author2.setFirstName("Roronova");
        author2.setLastName("zoro");

        Book book1 = new Book();
        book1.setTitle("The Book");
        book1.setIsbn("1234567890");

        Book book2 = new Book();
        book2.setTitle("The Anil");
        book2.setIsbn("1234567890");

        Publisher publisher = new Publisher();
        publisher.setName("luffy");
        publisher.setCity("east blue");

        Author authorSaved1 = authorRepository.save(author1);
        Author authorSaved2 = authorRepository.save(author2);

        Book bookSaved1 =  bookRepository.save(book1);
        Book bookSaved2 =  bookRepository.save(book2);

        Publisher publisherSaved =  publisherRepository.save(publisher);

        authorSaved1.getBooks().add(bookSaved1);
        authorSaved2.getBooks().add(bookSaved2);

        bookSaved1.getAuthors().add(authorSaved1);
        bookSaved2.getAuthors().add(authorSaved2);

        bookSaved1.setPublisher(publisherSaved);
        bookSaved2.setPublisher(publisherSaved);

        authorRepository.save(authorSaved1);
        authorRepository.save(authorSaved2);
        bookRepository.save(bookSaved1);
        bookRepository.save(bookSaved2);

        System.out.println("Bootstrap:");
        System.out.println("Author Count " + authorRepository.count());
        System.out.println("Book Count " + bookRepository.count());
        System.out.println("Publisher Count " + publisherRepository.count());

    }
}
