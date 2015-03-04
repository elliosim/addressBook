package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by simon on 02/03/15.
 */
public class Person {

    private String name;
    private String sex;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yy", timezone="GMT")
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
