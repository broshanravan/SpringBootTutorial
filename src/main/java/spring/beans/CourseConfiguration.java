package spring.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
public class CourseConfiguration {

    private String name ;
    private int chapters;
    private int rating;
    private String author;

    public CourseConfiguration(String name, int chapters, int rating, String author) {
        this.name = name;
        this.chapters = chapters;
        this.rating = rating;
        this.author = author;
    }

    public CourseConfiguration(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
