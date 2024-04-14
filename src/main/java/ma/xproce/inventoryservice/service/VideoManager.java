package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entites.Video;

import java.util.List;
import java.util.Optional;

public interface VideoManager {
    public Video createVideo(Video video);
    public List<Video> getAllVideos();
    public Video updateVideo(Video video);
    public boolean deleteVideo(Long Id);
    public Optional<Video> getVideoById(Long Id);
}
