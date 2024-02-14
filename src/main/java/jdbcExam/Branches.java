package jdbcExam;

public class Branches {
    private String city;
    private int numberOfEmployees;
    private int cityId;

    public Branches() {
    }

    public Branches(String city, int numberOfEmployees, int cityId) {
        this.city = city;
        this.numberOfEmployees = numberOfEmployees;
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
