import java.io.*;
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String name;
    protected int note;
    public Student(String name, int note){this.name = name;this.note = note;}
    public String toString(){
        return name+"   "+note;
    }
}