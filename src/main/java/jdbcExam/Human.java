package jdbcExam;

public class Human {
    private int id;
    private String name;
    private String surname;
    private String middlename;
    private String branch;
    private String gender;
    private int salary;
    private int age;

    public Human(){

    }

    public Human(int id, String name, String surname, String middlename, String branch, String gender, int salary, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.branch = branch;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: "+ id
                +", name: "+ name
                +", surname: "+ surname
                +", middlename: "+ middlename
                +", branch: "+ branch
                +", gender: "+ gender
                +", salary: "+ salary
                +", age: "+ age
                + "}";
    }
}
