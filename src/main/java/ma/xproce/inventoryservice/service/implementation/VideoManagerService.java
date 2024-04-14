package ma.xproce.inventoryservice.service.implementation;

import ma.xproce.inventoryservice.dao.entites.Video;
import ma.xproce.inventoryservice.dao.repositories.VideoDAO;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoManagerService implements VideoManager {
    @Autowired
    private VideoDAO videoDAO;
    @Override
    public Video createVideo(Video video) {
        if(videoDAO.findByUrl(video.getUrl())!=null){
            videoDAO.save(video);
            return video;
        }else {
            System.out.println("Impossible de supprimer la video ");
            return null;
        }

    }

    @Override
    public List<Video> getAllVideos() {
        return videoDAO.findAll();
    }

    @Override
    public Video updateVideo(Video video) {
        return videoDAO.save(video);
    }

    @Override
    public boolean deleteVideo(Long Id) {
        try{
            videoDAO.deleteById(Id);
            return true;
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }

    }
    @Override
    public Optional<Video> getVideoById(Long Id) {
        return videoDAO.findById(Id);

    }
}
