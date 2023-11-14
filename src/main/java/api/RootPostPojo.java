package api;

import java.util.ArrayList;

public class RootPostPojo {
    private Integer id;

    private CategoryPostPojo category;

    private String name;

    private String[] photoUrls;

    private TagsPostPojo[] tags;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryPostPojo getCategory() {
        return category;
    }

    public void setCategory(CategoryPostPojo category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public TagsPostPojo[] getTags() {
        return tags;
    }

    public void setTags(TagsPostPojo[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
