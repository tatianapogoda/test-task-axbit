package com.example.TestTaskAxbit.service;

import com.example.TestTaskAxbit.dao.AuthorDAO;
import com.example.TestTaskAxbit.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    private AuthorDAO authorDAO;

    @Autowired
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }
    @Override
    public void create(Author author) {
        authorDAO.create(author);
    }

    @Transactional
    @Override
    public List<Author> readAll() {
        return authorDAO.readAll();
    }

    @Override
    @Transactional
    public Author read(long id) {
        return authorDAO.read(id);
    }

    @Override
    @Transactional
    public boolean update(Author author, long id) {
        return authorDAO.update(author, id);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return authorDAO.delete(id);
    }
}
