package com.example.test2.DTO;

public class RequesProductDTO {
    private int id;
    private String name;
    private String details;
    private String category;

    public RequesProductDTO() {
    }

    public RequesProductDTO(int id, String name, String details,String category) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
