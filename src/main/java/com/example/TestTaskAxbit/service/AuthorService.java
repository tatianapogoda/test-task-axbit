package com.example.TestTaskAxbit.service;

import com.example.TestTaskAxbit.model.Author;

import java.util.List;

public interface AuthorService {
    void create(Author author);

    List<Author> readAll();

    Author read(long id);

    boolean update(Author author, long id);

    boolean delete(long id);
}
