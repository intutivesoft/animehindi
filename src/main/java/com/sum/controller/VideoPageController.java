package com.sum.controller;

import com.sum.entity.Video;
import com.sum.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class VideoPageController {

    private final VideoService videoService;

    public VideoPageController(VideoService videoService) {
        this.videoService = videoService;
    }

    // Open form page
    @GetMapping("/add-video")
    public String showForm() {
        return "add-video"; // maps to add-video.html
    }

    // Handle form submit
    @PostMapping("/videos/save")
    public String saveVideo(
            @RequestParam String videoName,
            @RequestParam String category
    ) {
        Video video = new Video(videoName, category);
        videoService.saveVideo(video);
        return "redirect:/add-video";
    }
}
