package cybersoft.javabackend.java18.gira.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import cybersoft.javabackend.java18.gira.common.utils.DateTimeUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)

@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    @Column(name = Columns.ID)
    protected UUID id;

    @Version
    @Column(name = Columns.VERSION)
    protected int version;
    @CreatedBy
    @Column(name = Columns.CREATED_BY)
    protected String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT)
    @DateTimeFormat(pattern = DateTimeUtils.DATETIME_FORMAT)
    @CreatedDate
    @Column(name = Columns.CREATED_AT)
    protected LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = Columns.LAST_MODIFIED_BY)
    protected String lastModifiedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT)
    @DateTimeFormat(pattern = DateTimeUtils.DATETIME_FORMAT)
    @LastModifiedDate
    @Column(name = Columns.LAST_MODIFIED_AT)
    protected LocalDateTime lastModifiedAt;

    @UtilityClass
    static class Columns {
        static final String ID = "ID";
        static final String VERSION = "VERSION";

        static final String CREATED_BY = "CREATED_BY";
        static final String CREATED_AT = "CREATED_AT";
        static final String LAST_MODIFIED_BY = "LAST_MODIFIED_BY";
        static final String LAST_MODIFIED_AT = "LAST_MODIFIED_AT";
    }


}
