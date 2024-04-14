package ma.xproce.inventoryservice.web;


import ma.xproce.inventoryservice.dao.entites.Video;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class VideoController {
    @Autowired
    VideoManager videoManager;

    @GetMapping("/")
    public String start() {
        return "indexpage";
    }

    @GetMapping("/addVideo")
    public String addVideo(Model model) {
    model.addAttribute("video", new Video());
        return "addVideo";
    }



    @PostMapping("/addVideo")
    public  String addVideo(Model model, @RequestParam(name = "name") String name,
                            @RequestParam(name = "url") String url,
                            @RequestParam(name = "description")String description,
                            @RequestParam (name = "datePublication")@DateTimeFormat(pattern = "yyyy-MM-dd") Date datePublication){
//        Video video = new Video(Id,name,url,description,);
        Video video = new Video();
        video.setName(name);
        video.setUrl(url);
        video.setDescription(description);
        video.setDatePublication(datePublication);
        videoManager.createVideo(video);
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("videos",videos);
        return "listVideos";
    }
    @GetMapping("/listVideos")
    public String listVideo(Model model)
    {
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("videos", videos);
        return "listVideos";
    }
    @GetMapping("/editVideo")
    public String editVideo(Model model, @RequestParam(name="Id", required=false) Long Id)
    {
        if (Id == null) {
            return "listVideos";
        }
        Optional<Video> video = videoManager.getVideoById(Id);
        if (video.isPresent()) {
            model.addAttribute("videoToBeEdited", video.get());
            return "editVideo";
        } else {
            return "editVideo";
        }


    }

}
