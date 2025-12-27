package com.sum.specification;
import com.sum.entity.Video;
import org.springframework.data.jpa.domain.Specification;
public class VideoSpecification {
    public static Specification<Video> filterBy(
            String videoId,
            String category,
            String s) {
        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (videoId != null && !videoId.isEmpty()) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("videoId"), videoId));
            }

            if (category != null && !category.isEmpty()) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("category"), category));
            }

            return predicate;
        };
    }
}
