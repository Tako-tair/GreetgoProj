package user;

public class User {
    private int id;
    private String login;
    private String pass;
    private String name;
    private String surname;
    private String school;
    private int degree;
    private double avr_point;

    public User(){}
    public User(int id){this.id = id;}
    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    public User(int id, String name, String surname, String school, int degree, double avr_point) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.school = school;
        this.degree = degree;
        this.avr_point = avr_point;
    }
    public User(String login, String pass, String name, String surname, String school, int degree, double avr_point) {
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.school = school;
        this.degree = degree;
        this.avr_point = avr_point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public double getAvr_point() {
        return avr_point;
    }

    public void setAvr_point(double avr_point) {
        this.avr_point = avr_point;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + school + " " + degree + " " + avr_point + "\n";
    }
}
