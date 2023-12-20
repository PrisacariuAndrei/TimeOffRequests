package timeOffRequests.monolith.mainApp.observer;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.DaysOffDTO;
import timeOffRequests.monolith.mainApp.entity.Administrator;

import java.io.IOException;

@Component
public class EmailObserver implements DaysOffObserver{

    @Override
    public void notifyNewDaysOffRequestCreated(DaysOffDTO reports) {
        sendEmail();
    }
    private void sendEmail() {
        System.out.println("Sending email notification: New day off report created!");
    }

/*  private void sendEmail() {
        Email from = new Email("from@example.com");
        String subject = "New Administrator Created";
        Email to = new Email("to@example.com"); // Replace with the actual recipient email
        Content content = new Content("text/plain", "A new administrator has been created.");

        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request);
            System.out.println("Email sent with status code: " + response.getStatusCode());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
