package org.sda.bms.controller;

import org.sda.bms.repository.exception.EntityCreationFailedException;
import org.sda.bms.repository.exception.EntityFetchingFailedException;
import org.sda.bms.service.BookService;

import javax.persistence.EntityNotFoundException;
import java.util.Scanner;

public class BookController {
    //dependencies
    private final BookService bookService;
    private final Scanner scanner;

    public BookController(BookService bookService, Scanner scanner) {
        this.bookService = bookService;
        this.scanner = scanner;
    }

    public void create() {
        try {
            System.out.println("Please provide the book title: ");
            String title = scanner.nextLine().trim();
            System.out.println("\n");
            System.out.println("Please provide book description: ");
            String description = scanner.nextLine().trim();
            System.out.println("Please insert the author's id: ");
            int authorId = Integer.parseInt(scanner.nextLine());

            System.out.println("\n");
            bookService.create(title, description, authorId);
            System.out.println("Book created successfully.");
        } catch (NumberFormatException e) {
            System.err.println("Provided id is not a number. Please provide a valid id.");
        } catch (EntityFetchingFailedException e) {
            System.err.println(e.getMessage());
        } catch (EntityCreationFailedException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error. Please contact your administrator.");
        }
    }
}
