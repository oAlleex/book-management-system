package org.sda.bms.service;

import org.sda.bms.model.Author;

import java.util.List;

public interface AuthorService {

    void create(String firstName, String lastName);

    List<Author> findAll();

    void delete(int id);

    void update(int id, String firstName, String lastName);
}
