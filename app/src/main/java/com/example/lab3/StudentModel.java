package com.example.lab3;

public class StudentModel {
    private String firstname, lastname, studentcode, studentmail,studentphone;
    public StudentModel(String firstname, String lastname, String studentcode, String studentmail, String studentphone) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.studentcode=studentcode;
        this.studentmail=studentmail;
        this.studentphone=studentphone;
    }
    public StudentModel(){

    }
    public String toString(){

        return studentcode + ", " + studentphone + ", "+ firstname.substring(0,1)+"."+lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getStudentmail() {
        return studentmail;
    }

    public void setStudentmail(String studentmail) {
        this.studentmail = studentmail;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }
}
