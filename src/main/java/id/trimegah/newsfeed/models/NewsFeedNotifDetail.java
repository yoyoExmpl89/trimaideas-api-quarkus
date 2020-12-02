package id.trimegah.newsfeed.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "newsfeednotifdetail")
public class NewsFeedNotifDetail extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "newsfeednotifdetailSequence", sequenceName = "newsfeednotifdetail_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsfeednotifSequence")
    private Long id;

    @JsonProperty("postid")
    @Column(name = "postid")
    private String postid;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("content")
    @Column(name = "content")
    private String content;

    @JsonProperty("subtitle")
    @Column(name = "subtitle")
    private String subtitle;

    @JsonProperty("category")
    @Column(name = "category")
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    @JsonProperty("insert_time")
    @Column(name = "insert_time")
    private LocalDateTime insert_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    @JsonProperty("update_time")
    @Column(name = "update_time")
    private LocalDateTime update_time;

    @JsonProperty("username")
    @Column(name = "username")
    private String username;

    @JsonProperty("sessionid")
    @Column(name = "sessionid")
    private String sessionid;

    @Column(name = "flag")
    @JsonProperty("unread")
    private boolean unread;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public LocalDateTime getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(LocalDateTime insert_time) {
        this.insert_time = insert_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsFeedNotifDetail)) return false;
        NewsFeedNotifDetail that = (NewsFeedNotifDetail) o;
        return isUnread() == that.isUnread() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPostid(), that.getPostid()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getSubtitle(), that.getSubtitle()) &&
                Objects.equals(getCategory(), that.getCategory()) &&
                Objects.equals(getInsert_time(), that.getInsert_time()) &&
                Objects.equals(getUpdate_time(), that.getUpdate_time()) &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getSessionid(), that.getSessionid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getTitle(),getCategory(),getContent(), getInsert_time(), getPostid(), getSubtitle(), getUsername());
    }
}
