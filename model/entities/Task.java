package model.entities;

import model.entities.enums.Status;

public class Task {

    private static int nextId = 1;
    private Integer id;
    private String title;
    private String description;
    private Status status;
    private Integer percentage;

    public Task(){
    }

    public Task(String title, String description, Status status, Integer percentage){
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.status = status;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId() + " - ");
        sb.append(getTitle() + " - ");
        sb.append(getDescription() + " - ");
        sb.append(getStatus() + " - ");
        sb.append(getPercentage() + "%");
        return sb.toString();
    }

    
}
