package com.sum.repository;

import com.sum.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long>,JpaSpecificationExecutor<Video> {

    List<Video> findByCategory(String category);
}