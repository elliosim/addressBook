package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by simon on 02/03/15.
 */
public class Person {

    private String name;
    private String gender;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yy", timezone="GMT")
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
