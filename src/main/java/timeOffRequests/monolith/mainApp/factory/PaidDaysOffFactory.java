package timeOffRequests.monolith.mainApp.factory;

import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.time.LocalDateTime;

public class PaidDaysOffFactory implements DaysOffFactory {

    @Override
    public DaysOff createDaysOff() {
        DaysOff daysOff = new DaysOff();
        daysOff.setReason("Vacation");
        daysOff.setComments("I want to visit Barcelona");
        daysOff.setCreatedDate(LocalDateTime.now());

        return daysOff;
    }
}
