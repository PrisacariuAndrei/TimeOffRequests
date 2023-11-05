package timeOffRequests.monolith.mainApp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class DaysOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private Long employeeId;

    private String employeeSurname;
    
    private String employeeName;

    @Nonnull
    private int numberOfDayTaken;

    private String reason;
}
