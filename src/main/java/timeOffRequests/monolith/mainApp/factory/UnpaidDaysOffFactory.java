package timeOffRequests.monolith.mainApp.factory;

import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.time.LocalDateTime;

public class UnpaidDaysOffFactory implements DaysOffFactory {

    @Override
    public DaysOff createDaysOff() {
        DaysOff daysOff = new DaysOff();
        daysOff.setReason("Some problems");
        daysOff.setComments("I have some family problems");
        daysOff.setCreatedDate(LocalDateTime.now());

        return daysOff;
    }
}
