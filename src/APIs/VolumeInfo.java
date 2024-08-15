package Modelos;

import java.util.List;

public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String publishedDate;

    // Getters e Setters para title, authors, e publishedDate
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
}