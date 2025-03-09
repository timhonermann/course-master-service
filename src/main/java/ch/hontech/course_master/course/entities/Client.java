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
@Table(name = "client", schema = "course")
public class Client {
    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<Course> courses;
}
