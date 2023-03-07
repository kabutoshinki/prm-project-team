package com.example.team_project.dto.response;


import android.media.Image;

import java.io.Serializable;

public class ProductUserResponse implements Serializable {
    private Long id;
    private String name;
    private String imageUrl;
    private Integer modalYear;
    private Double price;
    private String branch;
    private String category;

    public ProductUserResponse() {
    }

    public ProductUserResponse(Long id, String name, String imageUrl,Integer modalYear, Double price, String branch, String category) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.modalYear = modalYear;
        this.price = price;
        this.branch = branch;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getModalYear() {
        return modalYear;
    }

    public void setModalYear(Integer modalYear) {
        this.modalYear = modalYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductUserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", modalYear=" + modalYear +
                ", price=" + price +
                ", branch='" + branch + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
