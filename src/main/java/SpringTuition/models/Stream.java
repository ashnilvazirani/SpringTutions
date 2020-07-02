package SpringTuition.models;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Stream")
public class Stream {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    @Column(name = "streamName")
    String streamName;
    @Column(name = "streamDuration")
    String streamDuration;
    @Column(name = "streamDescription")
    String streamDescription;

    public Stream() {

    }

    public Stream(String id, String streamName, String streamDuration, String streamDescription) {
        this.id = id;
        this.streamName = streamName;
        this.streamDuration = streamDuration;
        this.streamDescription = streamDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "Stream [id=" + ", streamDescription=" + streamDescription + ", streamDuration=" + streamDuration
                + ", streamName=" + streamName + "]";
    }

}