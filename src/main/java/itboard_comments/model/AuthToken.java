package itboard_comments.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import itboard_comments.serializer.AuthTokenSerializer;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "authtoken_token")
@JsonSerialize(using = AuthTokenSerializer.class)
public class AuthToken {
    @Id
    @Column(name = "key", nullable = false)
    private String key;

    @Column(name = "created", nullable = false)
    private ZonedDateTime created;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
