package ma.xproce.inventoryservice.dao.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity@Data
@AllArgsConstructor@NoArgsConstructor
@Table(name = "Createur")

public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "email")
    private String email;

    //association avec video
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL
    )
    private List<Video> video;

    @Override
    public String toString() {
        return "Creator{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
