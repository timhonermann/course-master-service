package ch.hontech.course_master.course.repositories;

import ch.hontech.course_master.course.entities.Partner;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, UUID> {
}
