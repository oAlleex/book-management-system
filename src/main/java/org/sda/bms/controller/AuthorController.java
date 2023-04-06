package org.sda.bms.controller;

import org.sda.bms.repository.exception.EntityCreationFailedException;
import org.sda.bms.service.AuthorService;

import java.util.Scanner;

public class AuthorController {
    //dependencies
    private final AuthorService authorService;
    private final Scanner scanner;


    public AuthorController(AuthorService authorService, Scanner scanner) {
        this.authorService = authorService;
        this.scanner = scanner;
    }

    public void create(){
        try {
            System.out.println("Please provide first name: ");
            String firstName = scanner.nextLine().trim();
            System.out.println("\n");
            System.out.println("Please provide last name: ");
            String lastName = scanner.nextLine().trim();

            System.out.println("\n");
            authorService.create(firstName, lastName);
            System.out.println("Author created successfully");
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } catch (EntityCreationFailedException e){
            System.err.println(e.getMessage());
        } catch (Exception e){
            System.err.println("Internal server error. Please contact your administrator.");
        }
    }
}