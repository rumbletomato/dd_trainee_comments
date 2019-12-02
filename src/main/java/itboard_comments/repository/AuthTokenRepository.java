package itboard_comments.repository;

import itboard_comments.model.AuthToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthTokenRepository extends CrudRepository<AuthToken, String> {
    Optional<AuthToken> findByKey(String key);
}
