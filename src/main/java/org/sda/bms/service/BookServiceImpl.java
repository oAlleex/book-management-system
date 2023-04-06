package org.sda.bms.service;

import org.sda.bms.model.Author;
import org.sda.bms.model.Book;
import org.sda.bms.repository.AuthorRepository;
import org.sda.bms.repository.BookRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(String title, String description, int authorId) {
        if (title == null || title.isBlank() || title.isEmpty()){
            throw new IllegalArgumentException(
                    "Provided title is empty or blank. Provide a valid value."
            );
        }

        if (description == null || description.isBlank() || description.isEmpty()){
            throw new IllegalArgumentException(
                    "Provided description is empty or blank. Provide a valid value."
            );
        }

        if (authorId <= 0){
            throw new IllegalArgumentException(
                    "Provided id is negative or zero. Please provide a valid id."
            );
        }

        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if(authorOptional.isEmpty()){
            throw new EntityNotFoundException(
                    "Author with provided id was not found in the system."
            );
        }

        Author author = authorOptional.get();
        Book book = new Book(title,description);
        book.setAuthor(author);
        bookRepository.create(book);
    }
}
