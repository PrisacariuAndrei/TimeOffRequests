package timeOffRequests.monolith.mainApp;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Collections;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Value
public class ApiException extends RuntimeException{

    ErrorCode code;
    private Map<String, String> details;

    public ApiException(ErrorCode code) {
        this.code = code;
        this.details = Collections.emptyMap();
    }
}
