package com.sum.service;
import com.sum.entity.Video;
import com.sum.repository.VideoRepository;
import com.sum.specification.VideoSpecification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
    // save a new vedio by this method
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    // We will read data by category in this method
    public List<Video> getVideosByCategory(String category) {
        return videoRepository.findByCategory(category);
    }

    // we will read all in one go
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    public List<Video> getVideos(String genre, String videoId, String category) {
        return videoRepository.findAll(VideoSpecification.filterBy(genre, videoId, category)
        );
    }
}
