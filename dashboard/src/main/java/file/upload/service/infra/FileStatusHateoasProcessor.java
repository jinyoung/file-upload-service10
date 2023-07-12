package file.upload.service.infra;

import file.upload.service.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class FileStatusHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FileStatus>> {

    @Override
    public EntityModel<FileStatus> process(EntityModel<FileStatus> model) {
        return model;
    }
}
