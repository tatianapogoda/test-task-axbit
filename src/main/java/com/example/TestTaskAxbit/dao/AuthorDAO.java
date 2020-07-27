package com.example.TestTaskAxbit.dao;

import com.example.TestTaskAxbit.model.Author;

import java.util.List;

public interface AuthorDAO {

    void create(Author author);

    List<Author> readAll();

    Author read(long id);

    boolean update(Author author, long id);

    boolean delete(long id);

}
