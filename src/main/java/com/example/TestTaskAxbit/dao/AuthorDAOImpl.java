package com.example.TestTaskAxbit.dao;

import com.example.TestTaskAxbit.model.Author;
import com.example.TestTaskAxbit.repository.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
  /*  private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
    }

    @Override
    public List<Author> readAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Author").list();
    }

    @Override
    public Author read(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, id);
    }

    @Override
    public boolean update(Author author, long id) {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
        return true;
    }

    @Override
    public boolean delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Author.class, id));
        return true;
    }
*/

    private final AuthorRepository authorRepository;

    public AuthorDAOImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public void create(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> readAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author read(long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public boolean update(Author author, long id) {
        if(authorRepository.existsById(id)) {
            author.setId(id);
            authorRepository.save(author);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
