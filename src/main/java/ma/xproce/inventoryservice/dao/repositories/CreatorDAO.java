package ma.xproce.inventoryservice.dao.repositories;

import ma.xproce.inventoryservice.dao.entites.Creator;
import ma.xproce.inventoryservice.service.CreatorManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreatorDAO extends JpaRepository<Creator,Long> {
    List<Creator> findByEmail (String email);
}
