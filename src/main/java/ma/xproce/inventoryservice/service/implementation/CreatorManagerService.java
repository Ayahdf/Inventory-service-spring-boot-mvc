package ma.xproce.inventoryservice.service.implementation;

import ma.xproce.inventoryservice.dao.entites.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorDAO;
import ma.xproce.inventoryservice.service.CreatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorManagerService implements CreatorManager {
    @Autowired
    private CreatorDAO creatorDAO;

    @Override
    public Creator createCreator(Creator creator) {
        if (creatorDAO.findByEmail(creator.getEmail()) != null) {
            creatorDAO.save(creator);
            return creator;
            }
        else {
            System.out.println("Email existant");
            return null;

            }

    }

    @Override
    public List<Creator> getAllCreator() {

        return creatorDAO.findAll();
    }

    @Override
    public Creator updateCreator(Creator creator) {

        return creatorDAO.save(creator);
    }

    @Override
    public boolean deleteCreator(Long Id) {
        try {
            creatorDAO.deleteById(Id);
            return true;
        } catch (Exception exception) {
            System.out.println("impossible de supprimer le createur");
            return false;
        }
    }
}
