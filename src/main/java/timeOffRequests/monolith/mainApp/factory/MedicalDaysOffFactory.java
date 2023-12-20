package timeOffRequests.monolith.mainApp.factory;

import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.time.LocalDateTime;

public class MedicalDaysOffFactory implements DaysOffFactory {

    @Override
    public DaysOff createDaysOff() {
        DaysOff daysOff = new DaysOff();
        daysOff.setReason("Sick");
        daysOff.setComments("In the last period, I contacted a virus");
        daysOff.setCreatedDate(LocalDateTime.now());

        return daysOff;
    }
}
