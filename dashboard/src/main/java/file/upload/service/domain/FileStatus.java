package file.upload.service.domain;

import file.upload.service.DashboardApplication;
import file.upload.service.domain.FileStatusDisplayed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FileStatus_table")
@Data
public class FileStatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String fileId;

    private Long fileSize;

    private String fileName;

    private Boolean isIndexed;

    private Boolean isUploaded;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        FileStatusDisplayed fileStatusDisplayed = new FileStatusDisplayed(this);
        fileStatusDisplayed.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FileStatusRepository repository() {
        FileStatusRepository fileStatusRepository = DashboardApplication.applicationContext.getBean(
            FileStatusRepository.class
        );
        return fileStatusRepository;
    }
}
