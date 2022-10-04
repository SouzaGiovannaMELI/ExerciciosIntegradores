package br.com.meli.dh.exerciciointegrador13.repository;

import br.com.meli.dh.exerciciointegrador13.exception.HasExistsException;
import br.com.meli.dh.exerciciointegrador13.exception.NotFoundException;
import br.com.meli.dh.exerciciointegrador13.model.Blog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;

@Repository
public class BlogRepo {
    private HashMap<Integer, Blog> blogs = new HashMap<>();

    public Optional<Integer> saveBlog(Blog blog){

        System.out.println(blog);
        if(blogs.containsKey(blog.getId()))
            throw new HasExistsException("O id informado já está cadastrado!");

        blogs.put(blog.getId(), blog);


        return Optional.of(blog.getId());
    }

    public Optional<Blog> getBlog(int id){
        if(!blogs.containsKey(id))
            throw new NotFoundException("Blog não encontrado!");

        return Optional.of(blogs.get(id));
    }

    public Collection<Blog> getAll(){
        return blogs.values();
    }
}
