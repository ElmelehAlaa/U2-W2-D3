package AlaaElmeleh.U2W2D3.controllers;

import AlaaElmeleh.U2W2D3.entities.Blog;
import AlaaElmeleh.U2W2D3.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/blogs")
    public class BlogsController{
        @Autowired
        private BlogsService blogsService;

        @GetMapping("")
        public List<Blog> getBlog(){return blogsService.getBlogs();}

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody Blog body){return blogsService.save(body);}

    @GetMapping("/{id}")
    public Blog findById(@PathVariable long id ){
            return blogsService.findById(id);
    }

    @PutMapping("/{id}")
    public Blog findByAndUpdate (@PathVariable  long id , @RequestBody Blog body){
            return blogsService.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id){
            blogsService.findByIdAndDelete(id);
    }


    }

