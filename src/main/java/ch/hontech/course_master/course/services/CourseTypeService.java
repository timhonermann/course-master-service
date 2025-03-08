package ch.hontech.course_master.course.services;

import ch.hontech.course_master.common.exception.NotFoundException;
import ch.hontech.course_master.course.entities.CourseType;
import ch.hontech.course_master.course.repositories.CourseTypeRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseTypeService {
    private final CourseTypeRepository courseTypeRepository;

    public CourseType create(CourseType courseType) {
        courseType.setId(UUID.randomUUID());

        return courseTypeRepository.save(courseType);
    }

    public List<CourseType> getAll() {
        return courseTypeRepository.findAll();
    }

    public CourseType get(UUID id) {
        return courseTypeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Course Type with ID" + id + "not found"));
    }

    public CourseType update(CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }

    public void delete(UUID id) {
        courseTypeRepository.deleteById(id);
    }
}
