package model;

public class Student {

    int roll;
    int password;
    int id;
    String name;
    String program;
    String section;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Student(int roll, int password) {
        this.roll = roll;
        this.password = password;
    }

    public Student(int roll, int password, int id, String name, String program, String section) {
        this.roll = roll;
        this.password = password;
        this.id = id;
        this.name = name;
        this.program = program;
        this.section = section;
    }

    public int getRoll() {
        return roll;
    }

    public int getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public String getSection() {
        return section;
    }

    public void setPassword(int password) {
        this.password = password;
    }

}
