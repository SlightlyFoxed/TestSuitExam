package api;

import java.util.ArrayList;

public class RootPojo {
    private Integer id;
    private CategoryPojo category;
    private String name;
    private ArrayList<PhotoUrlsPojo> photoUrls;
    private ArrayList<TagPojo> tags;
    private String status;

    public RootPojo(Integer id, CategoryPojo category, String name, ArrayList<PhotoUrlsPojo> photoUrls, ArrayList<TagPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public CategoryPojo getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public ArrayList<PhotoUrlsPojo> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<TagPojo> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(CategoryPojo category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(ArrayList<PhotoUrlsPojo> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(ArrayList<TagPojo> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
