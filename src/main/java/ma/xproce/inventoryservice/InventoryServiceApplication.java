package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entites.Creator;
import ma.xproce.inventoryservice.dao.entites.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorDAO;
import ma.xproce.inventoryservice.dao.repositories.VideoDAO;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    //Test couche dao
//    @Bean
//    CommandLineRunner start(CreatorDAO creatorDAO, VideoDAO videoDAO){
//        return args -> {
//
////            //Creation d'un createur
////            Creator creator = new Creator();
////            creator.setEmail("aya@gmail.com");
////            creator.setName("Aya");
////            creatorDAO.save(creator);
////            //creation d'une video
////            Video video = new Video();
////            video.setUrl("https://mncwieh");
////            video.setName("video 1");
////            video.setDescription("premiere video");
////            video.setDatePublication(new Date(2023,12,3));
////            videoDAO.save(video);
////            //faire la liaison avec creator
////            video.setCreator(creator);
////            videoDAO.save(video);
////            //faire la liaison avec video
////            List<Video> videos = new ArrayList<>();
////            videos.add(video);
////            creator.setVideo(videos);
////            creatorDAO.save(creator);
////            //read
////            List<Creator> listCreator = creatorDAO.findAll();
////            listCreator.forEach(creatorFromList ->{
////                System.out.println(creatorFromList.toString());
////            });
////            List<Video> listVideo = videoDAO.findAll();
////            listVideo.forEach(videoFromList ->{
////                System.out.println(videoFromList.toString());
////            });

//    };}

    //Test couche service

    @Bean
    CommandLineRunner start(CreatorManager creatorManager , VideoManager videoManager){
        return args -> {
            Creator creator=new Creator();
            creator.setName("Aya");
            creator.setEmail("aya@gmail.com");
            creatorManager.createCreator(creator);
            Video video = new Video();
            video.setName("Video 1");
            video.setDatePublication(new Date(2024,01,13));
            video.setDescription("Video explicative");
            video.setUrl("https://classroom.google.com/c/NjY0MzU4NzA0Mzcz/a/NjU2MjAzNDI5MTg5/details");

            videoManager.createVideo(video);

            List<Video> videos = new ArrayList<>();
            videos.add(video);

            video.setCreator(creator);
            creator.setVideo(videos);
            videoManager.createVideo(video);
            creatorManager.createCreator(creator);


            List<Video> videosList = videoManager.getAllVideos();
            videosList.forEach(videoFromList ->{
                System.out.println(videoFromList.toString());
            });

            List<Creator> creatorsList = creatorManager.getAllCreator();
            creatorsList.forEach(creatorFromList ->{
                System.out.println(creatorFromList.toString());
            });


        };
    }


}
