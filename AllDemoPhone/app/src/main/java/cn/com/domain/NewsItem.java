package cn.com.domain;

/**
 * Created by admin on 2015/8/18.
 */
public class NewsItem {
    private String title;
    private String description;

    private String image;
    private String type;

    public NewsItem() {
    }

    public NewsItem(String title, String description, String image, String type, int comment) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.type = type;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", comment=" + comment +
                '}';
    }

    private int comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
