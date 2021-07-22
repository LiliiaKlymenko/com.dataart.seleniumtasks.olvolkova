package json;

import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "description",
        "title",
        "numberOfDownloads",
        "uploadedTimeStamp",
        "author",
        "imageData",
        "iconData"
})
@Generated("jsonschema2pojo")
public class ApplicationJson {

    @JsonProperty("category")
    private CategoryJson category;
    @JsonProperty("description")
    private String description;
    @JsonProperty("title")
    private String title;
    @JsonProperty("numberOfDownloads")
    private Integer numberOfDownloads;
    @JsonProperty("uploadedTimeStamp")
    private Long uploadedTimeStamp;
    @JsonProperty("author")
    private AuthorJson author;
    @JsonProperty("imageData")
    private Object imageData;
    @JsonProperty("iconData")
    private Object iconData;

    @JsonProperty("category")
    public CategoryJson getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(CategoryJson category) {
        this.category = category;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("numberOfDownloads")
    public Integer getNumberOfDownloads() {
        return numberOfDownloads;
    }

    @JsonProperty("numberOfDownloads")
    public void setNumberOfDownloads(Integer numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    @JsonProperty("uploadedTimeStamp")
    public Long getUploadedTimeStamp() {
        return uploadedTimeStamp;
    }

    @JsonProperty("uploadedTimeStamp")
    public void setUploadedTimeStamp(Long uploadedTimeStamp) {
        this.uploadedTimeStamp = uploadedTimeStamp;
    }

    @JsonProperty("author")
    public AuthorJson getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(AuthorJson author) {
        this.author = author;
    }

    @JsonProperty("imageData")
    public Object getImageData() {
        return imageData;
    }

    @JsonProperty("imageData")
    public void setImageData(Object imageData) {
        this.imageData = imageData;
    }

    @JsonProperty("iconData")
    public Object getIconData() {
        return iconData;
    }

    @JsonProperty("iconData")
    public void setIconData(Object iconData) {
        this.iconData = iconData;
    }

}
