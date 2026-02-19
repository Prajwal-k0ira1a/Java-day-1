package Model;

import java.sql.Timestamp;

public class Topic {

    private int id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Topic(int id, String name) {
        this.id = id;
        this.name = name;

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
