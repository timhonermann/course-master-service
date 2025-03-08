package ch.hontech.course_master.course.mappers;

import ch.hontech.course_master.course.dtos.CourseDto;
import ch.hontech.course_master.course.entities.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final ClientMapper clientMapper;
    private final PartnerMapper partnerMapper;
    private final CourseTypeMapper courseTypeMapper;

    public CourseDto courseToDto(Course course) {
        return CourseDto.builder()
            .id(course.getId())
            .createdAt(course.getCreatedAt())
            .startsAt(course.getStartsAt())
            .endsAt(course.getEndsAt())
            .client(clientMapper.clientToDto(course.getClient()))
            .partner(partnerMapper.partnerToDto(course.getPartner()))
            .courseType(courseTypeMapper.courseTypeToDto(course.getCourseType()))
            .build();
    }

    public Course dtoToCourse(CourseDto courseDto) {
        return Course.builder()
            .id(courseDto.id())
            .createdAt(courseDto.createdAt())
            .startsAt(courseDto.startsAt())
            .endsAt(courseDto.endsAt())
            .client(clientMapper.dtoToClient(courseDto.client()))
            .partner(partnerMapper.dtoToPartner(courseDto.partner()))
            .courseType(courseTypeMapper.dtoToCourseType(courseDto.courseType()))
            .build();
    }
}
