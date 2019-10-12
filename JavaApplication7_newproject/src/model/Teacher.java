package model;

public class Teacher {

    String user;
    String password;
    int id = 0;
    String name;
    String subject;

    public Teacher(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Teacher() {
    }

    public Teacher(String user, String password, int id, String name, String subject) {
        this.user = user;
        this.password = password;
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
