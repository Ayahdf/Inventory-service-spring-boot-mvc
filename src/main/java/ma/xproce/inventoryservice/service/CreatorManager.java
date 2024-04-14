package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entites.Creator;

import java.util.List;

public interface CreatorManager {
    public Creator createCreator(Creator creator);
    public List<Creator> getAllCreator();
    public Creator updateCreator(Creator creator);
    public boolean deleteCreator(Long Id);
}
