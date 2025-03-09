package ch.hontech.course_master.course.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course_type", schema = "course")
public class CourseType {
    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "courseType")
    @ToString.Exclude
    private List<Course> courses;
}
