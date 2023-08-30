package model.entities;

import model.entities.enums.Status;

public class Task {

    private static int nextId = 1;
    private Integer id;
    private String title;
    private String description;
    private Status status;

    public Task(){
    }

    public Task(String title, String description, Status status){
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.status = status;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: " + getId() + "\n");
        sb.append("Título: " + getTitle() + "\n");
        sb.append("Descrição: " + getDescription()  + "\n");
        sb.append("Status: " + String.valueOf(getStatus()));
        return sb.toString();
    }

    
}
