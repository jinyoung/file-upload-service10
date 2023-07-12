package file.upload.service.domain;

import file.upload.service.domain.*;
import file.upload.service.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class NotificationSent extends AbstractEvent {

    public NotificationSent(File aggregate) {
        super(aggregate);
    }

    public NotificationSent() {
        super();
    }
}
