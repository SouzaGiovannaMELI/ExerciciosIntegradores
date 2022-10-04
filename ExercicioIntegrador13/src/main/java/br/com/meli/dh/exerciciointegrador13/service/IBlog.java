package br.com.meli.dh.exerciciointegrador13.service;

import br.com.meli.dh.exerciciointegrador13.exception.HasExistsException;
import br.com.meli.dh.exerciciointegrador13.exception.NotFoundException;
import br.com.meli.dh.exerciciointegrador13.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlog {
    Blog getBlog(int id) throws NotFoundException;
    Optional<Integer> saveBlog(Blog blog) throws HasExistsException;
    List<Blog> getAllBlogs() throws NullPointerException;
}
