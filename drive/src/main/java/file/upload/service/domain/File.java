package file.upload.service.domain;

import file.upload.service.DriveApplication;
import file.upload.service.domain.FileIndexed;
import file.upload.service.domain.FileUploaded;
import file.upload.service.domain.NotificationSent;
import file.upload.service.domain.VideoProcessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String fileId;

    private String fileName;

    private Long fileSize;

    private Boolean isUploaded;

    private Boolean isIndexed;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();

        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();

        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();

        NotificationSent notificationSent = new NotificationSent(this);
        notificationSent.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
