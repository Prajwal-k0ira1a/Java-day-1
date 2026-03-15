package model;

import java.sql.Timestamp;

public class Entry {
    private int id;
    private int topicId;
    private String note;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Entry() {
    }

    public Entry(int id, int topicId, String note, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.topicId = topicId;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Entry(int topicId, String note, Timestamp createdAt, Timestamp updatedAt) {
        this.topicId = topicId;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
