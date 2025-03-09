package ch.hontech.course_master.course.controllers;

import ch.hontech.course_master.course.dtos.CourseTypeDto;
import ch.hontech.course_master.course.mappers.CourseTypeMapper;
import ch.hontech.course_master.course.services.CourseTypeService;
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
@RequestMapping("/api/v1/course-types")
public class CourseTypeController {
    private final CourseTypeService courseTypeService;

    private final CourseTypeMapper courseTypeMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseTypeDto create(@RequestBody CourseTypeDto courseTypeDto) {
        final var courseType =
            courseTypeService.create(courseTypeMapper.dtoToCourseType(courseTypeDto));

        return courseTypeMapper.courseTypeToDto(courseType);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseTypeDto> getAll() {
        return courseTypeService.getAll().stream()
            .map(courseTypeMapper::courseTypeToDto)
            .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseTypeDto get(@PathVariable("id") UUID id) {
        final var courseType = courseTypeService.get(id);

        return courseTypeMapper.courseTypeToDto(courseType);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseTypeDto update(@PathVariable("id") UUID id,
                                @RequestBody CourseTypeDto courseTypeDto) {
        final var courseType =
            courseTypeService.update(courseTypeMapper.dtoToCourseType(id, courseTypeDto));

        return courseTypeMapper.courseTypeToDto(courseType);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        courseTypeService.delete(id);
    }
}
