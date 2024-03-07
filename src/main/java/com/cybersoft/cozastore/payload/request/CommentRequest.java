package com.cybersoft.cozastore.payload.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CommentRequest {
    @NotNull(message = "blog_id must not be null")
    @NotEmpty(message = "blog_id must not be empty")
    private int blog_id;
    @NotNull(message = "comment must not be null")
    @NotEmpty(message = "comment must not be empty")
    private String comment;
    @NotNull(message = "date must not be null")
    @NotEmpty(message = "date must not be empty")
    private Date date;
    @NotNull(message = "name must not be null")
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotNull(message = "email must not be null")
    @NotEmpty(message = "email must not be empty")
    private String email;
    private String website;

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
