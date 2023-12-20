package timeOffRequests.monolith.mainApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import timeOffRequests.monolith.mainApp.entity.DaysOff;

@Repository
public interface DaysOffRepository extends JpaRepository<DaysOff, Long> {
}
