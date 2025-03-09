package ch.hontech.course_master.course.services;

import ch.hontech.course_master.common.exception.NotFoundException;
import ch.hontech.course_master.course.entities.Course;
import ch.hontech.course_master.course.repositories.CourseRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course create(Course course) {
        course.setId(UUID.randomUUID());
        course.setCreatedAt(LocalDateTime.now());

        return courseRepository.save(course);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course get(UUID id) {
        return courseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Course with ID" + id + "not found"));
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public void delete(UUID id) {
        courseRepository.deleteById(id);
    }
}
