package AlaaElmeleh.U2W2D3.services;

import AlaaElmeleh.U2W2D3.entities.Author;

import AlaaElmeleh.U2W2D3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public Author save(Author body){
        Random rndm = new Random();
        body.setId(rndm.nextLong(1,100000));
        this.authors.add(body);
        return body;
    }

    public List<Author> getAuthors(){return this.authors;}

    public Author findById(long id){
        Author a= null;
        for( Author author : this.authors){
            if(author.getId()==id){
                a= author;
            }
        }
        if(a == null){
            throw new NotFoundException(id);
        }else{
            return a;
        }
    }

    public void findByIdAndDelete(long id){
        ListIterator<Author> iterator = this.authors.listIterator();
        while (iterator.hasNext()){
            Author current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }


    public Author findByIdAndUpdate (long id , Author body){
        Author found = null;
        for(Author author:this.authors){
            if(author.getId()== id){
                found = author;
                found.setId(id);
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataNascita(body.getDataNascita());
                found.setAvatar(body.getAvatar());
            }
        }
        if (found==null){
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }
}
