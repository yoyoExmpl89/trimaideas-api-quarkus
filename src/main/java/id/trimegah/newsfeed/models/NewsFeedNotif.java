package id.trimegah.newsfeed.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "newsfeednotif")
public class NewsFeedNotif extends PanacheEntityBase {
    /*
    	id serial NOT NULL,
	title varchar(500) NULL,
	subtitle varchar(500) NULL,
	category varchar(500) NULL,
	status varchar(500) NULL,
	postid varchar(500) NULL,
	"content" varchar(500) NULL,
	flag bool NULL,
	insert_time timestamp NULL
     */
    @Id
    //@SequenceGenerator(name = "newsfeednotifSequen")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name ="category")
    private String category;

    @Column(name = "status")
    private String status;

    @Column(name = "postid")
    private String postid;

    @Column(name = "content")
    private String content;

    @Column(name = "flag")
    private boolean flag;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    @JsonProperty("insert_time")
    @Column(name = "insert_time")
    private LocalDateTime insert_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LocalDateTime getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(LocalDateTime insert_time) {
        this.insert_time = insert_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsFeedNotif)) return false;
        NewsFeedNotif that = (NewsFeedNotif) o;
        return isFlag() == that.isFlag() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getSubtitle(), that.getSubtitle()) &&
                Objects.equals(getCategory(), that.getCategory()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getPostid(), that.getPostid()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getInsert_time(), that.getInsert_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSubtitle(), getCategory(), getStatus(), getPostid(), getContent(), isFlag(), getInsert_time());
    }
}
