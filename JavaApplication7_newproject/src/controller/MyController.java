package controller;

import java.util.LinkedList;
import model.FeedBack;
import model.FeedBackDao;
import model.TeacherDao;
import model.Teacher;
import model.StudentDao;
import model.Student;

public class MyController {

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public int signUp(String user, String password, int id, String name, String subject) {

        Teacher t = new Teacher(user, password, id, name, subject);
        TeacherDao td = new TeacherDao();
        int i;
        i = td.signUp(t);
        return i;

    }

    public LinkedList<Teacher> logInTeacher(String user, String password) {

        Teacher t = new Teacher(user, password);
        TeacherDao td = new TeacherDao();
        LinkedList<Teacher> ll = td.logInTeacher(t);
        return ll;

    }

    public void updatePassword(String user, String password) {
        Teacher t = new Teacher(user, password);
        t.setUser(user);
        t.setPassword(password);
        TeacherDao td = new TeacherDao();
        td.updatePassword(t);
    }

    public void deleteAccount(String user) {
        Teacher t = new Teacher();
        t.setUser(user);
        TeacherDao td = new TeacherDao();
        td.deleteAccount(t);

    }

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    
    public int signUpStudent(int roll, int password, int id, String name, String program, String section) {

        Student s = new Student(roll, password, id, name, program, section);
        StudentDao sd = new StudentDao();
        int i = sd.signUpStudent(s);
        return i;
    }

    public LinkedList logInStudent(int roll, int password) {

        Student s = new Student(roll, password);
        StudentDao sd = new StudentDao();
        LinkedList l = sd.logInStudent(s);
        return l;

    }

    public LinkedList<Student> viewStudent(int id) {
        Student s = new Student(id);
        StudentDao sd = new StudentDao();
        LinkedList<Student> l = sd.viewStudent(s);
        return l;
    }

    public void updateStudentPassword(int roll, int password) {
        Student s = new Student(roll, password);

        StudentDao sd = new StudentDao();
        sd.updateStudentPassword(s);
    }

    public void deleteStudentAccount(int roll) {
        Student s = new Student();
        s.setRoll(roll);
        StudentDao sd = new StudentDao();
        sd.deleteStudentAccount(s);

    }

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
   
    public int feedBackInsert(int sId, int tId, int fb[]) {//this method is used by student

        FeedBack f = new FeedBack(tId, sId);
        f.setFb(fb);
        FeedBackDao fd = new FeedBackDao();
        int j = fd.feedBackInsert(f);
        return j;
    }

    public LinkedList calc(int tId) {//this method is used by teacher
        try {
            FeedBack f = new FeedBack(tId);
            FeedBackDao fd = new FeedBackDao();

            LinkedList l = fd.cg(f);
            return l;
        } catch (Exception e) {
            System.out.println("mc problem");
        }
        return null;
    }
}
