package com.example.TestTaskAxbit.controller;

import com.example.TestTaskAxbit.dao.AuthorDAO;
import com.example.TestTaskAxbit.dao.AuthorDAOImpl;
import com.example.TestTaskAxbit.model.Author;
import com.example.TestTaskAxbit.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorController(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @RequestMapping(value = "/allAuthors", method = RequestMethod.GET)
    public ModelAndView allAuthors() {
        List<Author> authors = authorDAO.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        modelAndView.addObject("authorList", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/authors")
    public ResponseEntity<?> create(@RequestBody Author author) {
        authorDAO.create(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/authors")
    public ResponseEntity<List<Author>> readAll() {
        final List<Author> authors = authorDAO.readAll();

        return authors != null &&  !authors.isEmpty()
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<Author> read(@PathVariable(name = "id") long id) {
        final Author author = authorDAO.read(id);

        return author != null
                ? new ResponseEntity<>(author, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Author author) {
        final boolean updated = authorDAO.update(author, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/authors/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = authorDAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
