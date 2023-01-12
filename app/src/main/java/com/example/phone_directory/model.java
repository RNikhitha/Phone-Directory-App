package com.example.phone_directory;

public class model {
    public String id;
    public String title;
    public String body;
    public String mobile;
    public String emptype;
    public String designation;
    public String department;

    public model(String id, String title, String body, String mobile, String emptype, String designation, String department) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.mobile=mobile;
        this.emptype=emptype;
        this.designation=designation;
        this.department=department;

    }

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        this.emptype = emptype;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
