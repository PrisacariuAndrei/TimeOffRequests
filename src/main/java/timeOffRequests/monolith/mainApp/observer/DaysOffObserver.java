package timeOffRequests.monolith.mainApp.observer;

import org.springframework.stereotype.Service;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.entity.Administrator;

@FunctionalInterface
public interface DaysOffObserver {
    void notifyNewDaysOffRequestCreated(AdministratorDTO admin);
}
