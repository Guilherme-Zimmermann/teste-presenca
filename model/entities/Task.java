package model.entities;

import model.entities.enums.Status;

public class Task {

    private String title;
    private String description;
    private Status status;

    public Task(){
    }

    public Task( String title, String description, Status status){
        this.title = title;
        this.description = description;
        this.status = status;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + title + "\n");
        sb.append("Description: " + description  + "\n");
        sb.append("Status: " + String.valueOf(status));
        return sb.toString();
    }

    
}
