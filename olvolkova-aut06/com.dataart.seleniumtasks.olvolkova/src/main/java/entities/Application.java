package entities;

public class Application {
    private String category;
    private String description;
    private String title;
    private Integer numberOfDownloads;
    private String author;
    private String imageData;
    private String iconData;



    public String getCategory() {
        return category;
    }

    public Application withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Application withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Application withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public Application withNumberOfDownloads(Integer numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Application withAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getImageData() {
        return imageData;
    }

    public Application withImageData(String imageData) {
        this.imageData = imageData;
        return this;
    }

    public String getIconData() {
        return iconData;
    }

    public Application withIconData(String iconData) {
        this.iconData = iconData;
        return this;
    }

    @Override
    public String toString() {
        return "Application{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
