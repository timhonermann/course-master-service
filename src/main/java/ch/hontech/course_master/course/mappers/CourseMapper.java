package ch.hontech.course_master.course.mappers;

import ch.hontech.course_master.course.dtos.CourseCreationDto;
import ch.hontech.course_master.course.dtos.CourseDto;
import ch.hontech.course_master.course.entities.Course;
import ch.hontech.course_master.course.services.ClientService;
import ch.hontech.course_master.course.services.CourseTypeService;
import ch.hontech.course_master.course.services.PartnerService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final ClientService clientService;
    private final PartnerService partnerService;
    private final CourseTypeService courseTypeService;

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

    public Course dtoToCourse(UUID id, CourseDto courseDto) {
        return Course.builder()
            .id(id)
            .createdAt(courseDto.createdAt())
            .startsAt(courseDto.startsAt())
            .endsAt(courseDto.endsAt())
            .client(clientMapper.dtoToClient(courseDto.client()))
            .partner(partnerMapper.dtoToPartner(courseDto.partner()))
            .courseType(courseTypeMapper.dtoToCourseType(courseDto.courseType()))
            .build();
    }

    public Course dtoToCourse(CourseCreationDto courseCreationDto) {
        final var client = clientService.get(courseCreationDto.clientId());
        final var partner = partnerService.get(courseCreationDto.partnerId());
        final var courseType = courseTypeService.get(courseCreationDto.courseTypeId());

        return Course.builder()
            .startsAt(courseCreationDto.startsAt())
            .endsAt(courseCreationDto.endsAt())
            .client(client)
            .partner(partner)
            .courseType(courseType)
            .build();
    }
}
