package com.example.chen.catalogmag.s.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by chen on 04.04.16.
 */

public class Category {
    private int id;

    private String title;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("created_at")
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", updatedAt = " + updatedAt + ", createdAt = " + createdAt + "]";
    }
}
