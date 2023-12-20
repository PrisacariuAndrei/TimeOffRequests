package timeOffRequests.monolith.mainApp.observer;

import org.springframework.stereotype.Component;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.entity.Administrator;

@Component
public class SmsObserver implements DaysOffObserver{
    @Override
    public void notifyNewDaysOffRequestCreated(AdministratorDTO admin) {
        sendSMS();
    }
    private void sendSMS() {
        System.out.println("Sending SMS notification");
    }
}
