package timeOffRequests.monolith.mainApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import timeOffRequests.monolith.mainApp.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
