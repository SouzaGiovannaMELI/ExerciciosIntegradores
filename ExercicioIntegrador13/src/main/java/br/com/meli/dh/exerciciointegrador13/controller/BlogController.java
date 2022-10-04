package br.com.meli.dh.exerciciointegrador13.controller;

import br.com.meli.dh.exerciciointegrador13.model.Blog;
import br.com.meli.dh.exerciciointegrador13.service.BlogService;
import br.com.meli.dh.exerciciointegrador13.service.IBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {
    private IBlog blogService = new BlogService();

    @PostMapping("/")
    public ResponseEntity<Integer> saveBlog(@RequestBody Blog blog){
        System.out.println(blog.toString());
        return new ResponseEntity<>(blogService.saveBlog(blog).get(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable int id){
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
}
