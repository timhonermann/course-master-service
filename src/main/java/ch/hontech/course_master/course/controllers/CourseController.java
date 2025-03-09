package ch.hontech.course_master.course.controllers;

import ch.hontech.course_master.course.dtos.CourseCreationDto;
import ch.hontech.course_master.course.dtos.CourseDto;
import ch.hontech.course_master.course.mappers.CourseMapper;
import ch.hontech.course_master.course.services.CourseService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    private final CourseMapper courseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto create(@RequestBody CourseCreationDto courseCreationDto) {
        final var course = courseService.create(courseMapper.dtoToCourse(courseCreationDto));

        return courseMapper.courseToDto(course);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getAll() {
        return courseService.getAll().stream()
            .map(courseMapper::courseToDto)
            .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto get(@PathVariable("id") UUID id) {
        final var course = courseService.get(id);

        return courseMapper.courseToDto(course);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto update(@PathVariable("id") UUID id, @RequestBody CourseDto courseDto) {
        final var course = courseService.update(courseMapper.dtoToCourse(id, courseDto));

        return courseMapper.courseToDto(course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        courseService.delete(id);
    }
}
