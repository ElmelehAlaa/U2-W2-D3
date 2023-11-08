package AlaaElmeleh.U2W2D3.services;

import AlaaElmeleh.U2W2D3.entities.Author;

import AlaaElmeleh.U2W2D3.exceptions.NotFoundException;
import AlaaElmeleh.U2W2D3.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class AuthorService {
    @Autowired
    private AuthorsRepository authorsRepository;


    public Author save(Author body){


        return authorsRepository.save(body);
    }

    public Page<Author> getAuthors(int page , int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return authorsRepository.findAll(pageable);}

    public Author findById(long id) throws NotFoundException{
       return authorsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) throws NotFoundException{
        Author found = this.findById(id);
        authorsRepository.delete(found);
    }


    public Author findByIdAndUpdate (long id , Author body) throws NotFoundException{
               Author found = this.findById(id);
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataNascita(body.getDataNascita());
                found.setAvatar(body.getAvatar());
            return authorsRepository.save(found);


    }
}
