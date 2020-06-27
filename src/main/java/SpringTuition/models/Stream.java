package SpringTuition.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Stream")
public class Stream {
    @Id
    int id;
    String streamName;
    String streamDuration;
    String streamDescription;

    public Stream() {

    }

    public Stream(int id, String streamName, String streamDuration, String streamDescription) {
        this.id = id;
        this.streamName = streamName;
        this.streamDuration = streamDuration;
        this.streamDescription = streamDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getStreamDuration() {
        return streamDuration;
    }

    public void setStreamDuration(String streamDuration) {
        this.streamDuration = streamDuration;
    }

    public String getStreamDescription() {
        return streamDescription;
    }

    public void setStreamDescription(String streamDescription) {
        this.streamDescription = streamDescription;
    }

    @Override
    public String toString() {
        return "Stream [id=" + id + ", streamDescription=" + streamDescription + ", streamDuration=" + streamDuration
                + ", streamName=" + streamName + "]";
    }

}