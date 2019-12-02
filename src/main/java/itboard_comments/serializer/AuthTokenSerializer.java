package itboard_comments.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import itboard_comments.model.AuthToken;

import java.io.IOException;

public class AuthTokenSerializer extends StdSerializer<AuthToken> {
    protected AuthTokenSerializer() {
        this(null);
    }

    protected AuthTokenSerializer(Class<AuthToken> t) {
        super(t);
    }

    @Override
    public void serialize(AuthToken value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("key", value.getKey());
        gen.writeStringField("created", value.getCreated().toOffsetDateTime().toString());
        gen.writeNumberField("user_id", value.getUser().getId());
        gen.writeEndObject();
    }
}
