package timeOffRequests.monolith.mainApp.factory;

import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.time.LocalDateTime;

public class HalfPaidDaysOffFactory implements DaysOffFactory {

    @Override
    public DaysOff createDaysOff() {
        DaysOff daysOff = new DaysOff();
        daysOff.setReason("Car Problem");
        daysOff.setComments("I have a flat tire and I want to go to the mechanic");
        daysOff.setCreatedDate(LocalDateTime.now());

        return daysOff;
    }
}
