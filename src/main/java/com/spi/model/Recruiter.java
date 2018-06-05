package com.spi.model;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recruiter")
public class Recruiter implements Comparable<Recruiter> {

    @Id
    @GeneratedValue
    private String id;

    @NotNull
    @Min(value = 0, message = "Recruiter Id cannot be null or empty")
    private String recruiterId;

    @NotNull(message = "Recruiter First Name cannot be null")
    @Size(min = 2, max = 100, message = "Recruiter First Name must be atleast 2 and 100 characters")
    private String firstName;

    @NotNull(message = "Recruiter Last Name cannot be null")
    @Size(min = 0, max = 100, message = "Recruiter Last Name must be atleast 2 and 100 characters")
    private String lastName;

    private String emailId;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Phone number")
    private String contactNumber;
    private boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(String recruiterId) {
        this.recruiterId = recruiterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return isDeleted == recruiter.isDeleted &&
                Objects.equals(id, recruiter.id) &&
                Objects.equals(recruiterId, recruiter.recruiterId) &&
                Objects.equals(firstName, recruiter.firstName) &&
                Objects.equals(lastName, recruiter.lastName) &&
                Objects.equals(emailId, recruiter.emailId) &&
                Objects.equals(contactNumber, recruiter.contactNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, recruiterId, firstName, lastName, emailId, contactNumber, isDeleted);
    }


    @Override
    public String toString() {
        return "Recruiter{" +
                "id='" + id + '\'' +
                ", recruiterId='" + recruiterId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public int compareTo(Recruiter o) {
        int val = 0;
        if (this.getFirstName().compareTo(o.getFirstName()) == -1) {
            val = -1;
        } else if (this.getFirstName().compareTo(o.getFirstName()) == 1) {
            val = 1;
        }
        return val;
    }
}
