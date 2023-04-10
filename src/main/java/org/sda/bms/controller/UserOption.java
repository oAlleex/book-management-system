package org.sda.bms.controller;

import java.util.Optional;

public enum UserOption {
    CREATE_AUTHOR(1, "Create Author"),
    UPDATE_AUTHOR(2, "Update Author"),
    DELETE_AUTHOR(3, "Delete Author"),
    VIEW_ALL_AUTHORS(4, "View All Authors"),
    CREATE_BOOK(5,"Create Book"),
    VIEW_ALL_BOOKS(6,"View All Books"),
    VIEW_BOOK_BY_ID(7,"View book details"),
    DELETE_BOOK_BY_ID(8,"Delete book"),
    UPDATE_BOOK(9,"Update book"),
    EXIT(99, "Exit"),
    UNKNOWN(9999, "Unknown");

    private final int option;
    private final String displayName;

    UserOption(int option, String displayName) {
        this.option = option;
        this.displayName = displayName;
    }

    public static void printAllOptions() {
        System.out.println("-------------------------------");
        for (UserOption userOption : values()) {
            if (userOption != UNKNOWN) {
                System.out.println(userOption.displayName + " -> " + userOption.option);
            }
        }
    }

    public static Optional<UserOption> findUserOption(int optionInput) {
        for (UserOption userOption : values()) {
            if (userOption.option == optionInput) {
                return Optional.of(userOption);
            }
        }
        return Optional.empty();
    }


}
