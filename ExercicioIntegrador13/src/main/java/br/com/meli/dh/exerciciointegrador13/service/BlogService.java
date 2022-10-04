package br.com.meli.dh.exerciciointegrador13.service;

import br.com.meli.dh.exerciciointegrador13.exception.HasExistsException;
import br.com.meli.dh.exerciciointegrador13.exception.NotFoundException;
import br.com.meli.dh.exerciciointegrador13.model.Blog;
import br.com.meli.dh.exerciciointegrador13.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BlogService implements IBlog{
    BlogRepo repo = new BlogRepo();

    @Override
    public Blog getBlog(int id) throws NotFoundException {
        return repo.getBlog(id).get();
    }

    @Override
    public Optional<Integer> saveBlog(Blog blog) throws HasExistsException {
        return repo.saveBlog(blog);
    }

    @Override
    public List<Blog> getAllBlogs(){
        return new ArrayList<>(repo.getAll());
    }
}
