package ma.xproce.inventoryservice.web;


import ma.xproce.inventoryservice.dao.entites.Video;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
            List<Video> videos = videoManager.getAllVideos();
            model.addAttribute("videos", videos);
            System.out.println("hello");
            return "listVideos";
        }
        Optional<Video> video = videoManager.getVideoById(Id);
        if (video.isPresent()) {
            model.addAttribute("videoToBeEdited", video.get());
            return "editVideo";
        } else {
            System.out.println("Nooooooot hello");
            return "error";
        }


    }

    @PostMapping("/editVideo/{id}")
    public String editVideo(@PathVariable("id") Long id, @ModelAttribute("videoToBeEdited") Video videoToBeEdited, BindingResult result, Model model) {


        videoManager.updateVideo(videoToBeEdited);
        List<Video> videos = videoManager.getAllVideos();
        model.addAttribute("videos", videos);
        return "redirect:/listVideos";
    }
    @GetMapping("/deleteVideo/{id}")
    public String deleteVideo(@PathVariable("id") Long id, Model model) {
        boolean test = videoManager.deleteVideo(id);
        if (test) {
            System.out.println("c valide");
            return "redirect:/listVideos";
        } else {
            System.out.println("rien ne se passe");
            return "error";
        }
    }

}
