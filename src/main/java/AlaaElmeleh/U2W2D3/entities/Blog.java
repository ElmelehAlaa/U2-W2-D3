package AlaaElmeleh.U2W2D3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Blog {
    @Id
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;
    @CreationTimestamp
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
