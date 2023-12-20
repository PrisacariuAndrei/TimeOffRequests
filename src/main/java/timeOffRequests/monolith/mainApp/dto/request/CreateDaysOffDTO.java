package timeOffRequests.monolith.mainApp.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CreateDaysOffDTO {

    private Long requestId;
    private LocalDate date;
    private String reason;
    private int duration;
    private String status;
    private String employeeId;
    private String approverId;
    private String comments;
    private String attachment;
    private String category;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String location;
}
