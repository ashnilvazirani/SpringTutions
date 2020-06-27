package SpringTuition.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "Student")
public class Student {
    @Id
    int id;
    String studentName;
    String studentField;
    String studentContact;
    String studentEmail;
    String additonalDetails;
    int streamId;
    @OneToOne
    Stream stream;

    public Student() {

    }

    public Student(int id, String studentName, String studentField, String studentContact, String studentEmail,
            String additonalDetails, int streamId) {
        this.id = id;
        this.studentName = studentName;
        this.studentField = studentField;
        this.studentContact = studentContact;
        this.studentEmail = studentEmail;
        this.additonalDetails = additonalDetails;
        this.stream = new Stream(streamId, "", "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreamId() {
        return streamId;
    }

    public void setStreamId(int id) {
        this.streamId = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentField() {
        return studentField;
    }

    public void setStudentField(String studentField) {
        this.studentField = studentField;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getAdditonalDetails() {
        return additonalDetails;
    }

    public void setAdditonalDetails(String additonalDetails) {
        this.additonalDetails = additonalDetails;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Student [additonalDetails=" + additonalDetails + ", stream=" + stream + ", id=" + id
                + ", studentContact=" + studentContact + ", studentEmail=" + studentEmail + ", studentField="
                + studentField + ", studentName=" + studentName + "]" + ", streamID=" + streamId + "]";
    }
}