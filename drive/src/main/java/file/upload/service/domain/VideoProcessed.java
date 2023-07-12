package file.upload.service.domain;

import file.upload.service.domain.*;
import file.upload.service.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    public VideoProcessed(File aggregate) {
        super(aggregate);
    }

    public VideoProcessed() {
        super();
    }
}
