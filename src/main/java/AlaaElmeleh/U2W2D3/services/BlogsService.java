package AlaaElmeleh.U2W2D3.services;

import AlaaElmeleh.U2W2D3.entities.Blog;
import AlaaElmeleh.U2W2D3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
@Service
public class BlogsService {
    private List<Blog> blogs = new ArrayList<>();

    public Blog save(Blog body){
        Random rndm = new Random();
        body.setId(rndm.nextLong(1,100000));
        this.blogs.add(body);
        return body;
    }

    public List<Blog> getBlogs(){return this.blogs;}

    public Blog findById(long id){
        Blog b= null;
        for( Blog blog : this.blogs){
            if(blog.getId()==id){
                b= blog;
            }
        }
        if(b == null){
            throw new NotFoundException(id);
        }else{
            return b;
        }
    }

    public void findByIdAndDelete(long id){
        ListIterator<Blog>iterator = this.blogs.listIterator();
        while (iterator.hasNext()){
            Blog current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }

    public Blog findByIdAndUpdate (long id , Blog body){
        Blog found = null;
        for(Blog blog:this.blogs){
            if(blog.getId()== id){
                found = blog;
                found.setId(id);
                found.setContenuto(body.getContenuto());
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setCover(body.getCover());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (found==null){
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }
}
