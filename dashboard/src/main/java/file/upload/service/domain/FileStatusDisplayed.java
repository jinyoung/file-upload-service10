package file.upload.service.domain;

import file.upload.service.domain.*;
import file.upload.service.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileStatusDisplayed extends AbstractEvent {

    public FileStatusDisplayed(FileStatus aggregate) {
        super(aggregate);
    }

    public FileStatusDisplayed() {
        super();
    }
}
