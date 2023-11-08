package AlaaElmeleh.U2W2D3.controllers;


import AlaaElmeleh.U2W2D3.entities.Author;
import AlaaElmeleh.U2W2D3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController{
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public Page<Author> getAuthor(@RequestParam(defaultValue = "0")int page,
                                    @RequestParam(defaultValue = "10")int size,
                                  @RequestParam(defaultValue = "id")String orderBy)
    {return authorService.getAuthors(page,size,orderBy);}

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author body){return authorService.save(body);}

    @GetMapping("/{id}")
    public Author findById(@PathVariable long id ){
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author findByAndUpdate (@PathVariable  long id , @RequestBody Author body){
        return authorService.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id){
        authorService.findByIdAndDelete(id);
    }


}