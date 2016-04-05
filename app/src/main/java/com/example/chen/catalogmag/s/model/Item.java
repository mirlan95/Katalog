package com.example.chen.catalogmag.s.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by chen on 05.04.16.
 */
public class Item {
    @SerializedName("id")
    private int id;

    private String title;

    @SerializedName("price")
    private String price;

    private String text;

    @SerializedName("category_id")
    private int categoryId;

    @SerializedName("created_at")
    private Date createdDate;

    @SerializedName("updated_at")
    private Date updatedDate;

    @SerializedName("picture")
    private String pictureUlr;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getPictureUlr() {
        return pictureUlr;
    }

    public void setPictureUlr(String pictureUlr) {
        this.pictureUlr = pictureUlr;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", text='" + text + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", pictureUlr='" + pictureUlr + '\'' +
                '}';
    }
}
