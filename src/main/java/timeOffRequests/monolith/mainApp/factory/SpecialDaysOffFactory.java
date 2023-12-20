package timeOffRequests.monolith.mainApp.factory;

import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.time.LocalDateTime;

public class SpecialDaysOffFactory implements DaysOffFactory {

    @Override
    public DaysOff createDaysOff() {
        DaysOff daysOff = new DaysOff();
        daysOff.setReason("Wedding");
        daysOff.setComments("On sunday I will get married!");
        daysOff.setCreatedDate(LocalDateTime.now());

        return daysOff;
    }
}
