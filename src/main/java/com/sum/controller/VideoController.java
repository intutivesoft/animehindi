package com.sum.controller;
import com.sum.entity.Video;
import com.sum.service.VideoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public Video addVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }

    @GetMapping("/category/{category}")
    public List<Video> getVideosByCategory(@PathVariable String category) {
        return videoService.getVideosByCategory(category);
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }
    @GetMapping("/filter")
    public List<Video> getVideos(@RequestParam(required = false) String videoId,
                                 @RequestParam(required = false) String category,
                                 @RequestParam(required = false) String genre) {
        return videoService.getVideos(videoId, category, genre);
    }
}
