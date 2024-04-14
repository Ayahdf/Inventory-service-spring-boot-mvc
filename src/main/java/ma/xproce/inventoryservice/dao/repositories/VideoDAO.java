package ma.xproce.inventoryservice.dao.repositories;

import ma.xproce.inventoryservice.dao.entites.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoDAO extends JpaRepository<Video,Long> {
    List<Video> findByUrl (String url);
}
