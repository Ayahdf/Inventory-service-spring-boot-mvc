package ma.xproce.inventoryservice.dao.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Video")

public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "AdresseWeb")
    private String url;
    @Column(name = "description")
    private String description;
    @Column(name = "DatedePublication")
    private Date datePublication;

    //association avec creator
    @ManyToOne(cascade = CascadeType.ALL)
    private Creator creator;
    
}
