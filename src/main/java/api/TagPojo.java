package api;

public class TagPojo {
    private Integer id;
    private String name;

    public TagPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public TagPojo() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
