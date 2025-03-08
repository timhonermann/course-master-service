package ch.hontech.course_master.course.mappers;

import ch.hontech.course_master.course.dtos.CourseTypeDto;
import ch.hontech.course_master.course.entities.CourseType;
import org.springframework.stereotype.Component;

@Component
public class CourseTypeMapper {
    public CourseTypeDto courseTypeToDto(CourseType courseType) {
        return CourseTypeDto.builder()
            .id(courseType.getId())
            .name(courseType.getName())
            .build();
    }

    public CourseType dtoToCourseType(CourseTypeDto courseTypeDto) {
        return CourseType.builder()
            .id(courseTypeDto.id())
            .name(courseTypeDto.name())
            .build();
    }
}
