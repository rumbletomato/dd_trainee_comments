package itboard_comments.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@MappedSuperclass
public class AbstractCreatableEntity extends AbstractEntity {
    @Column(name = "created_ts", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Calendar createdTs;

    @Column(name = "updated_ts", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Calendar updatedTs;

    public AbstractCreatableEntity() {
        super();

        createdTs = Calendar.getInstance();
        updatedTs = Calendar.getInstance();
    }

    public Calendar getCreatedTs() {
        return createdTs;
    }

    public Calendar getUpdatedTs() {
        return updatedTs;
    }

    public void setCreatedTs(Calendar createdTs) {
        this.createdTs = createdTs;
    }

    public void setUpdatedTs(Calendar updatedTs) {
        this.updatedTs = updatedTs;
    }
}
