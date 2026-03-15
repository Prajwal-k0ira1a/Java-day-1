package dao.interfaces;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Topic;
import utils.DBConnection;

public class TopicDAOImpl implements TopicDAOInterface {

    @Override
    public List<Topic> getAllTopics() throws SQLException, ClassNotFoundException {

        List<Topic> topics = new ArrayList<>();

        String sql = "SELECT * FROM topics";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Topic topic = new Topic();

                topic.setId(rs.getInt("id"));
                topic.setName(rs.getString("name"));
                topic.setCreatedAt(rs.getTimestamp("created_at"));
                topic.setUpdatedAt(rs.getTimestamp("updated_at"));

                topics.add(topic);
            }
        }

        return topics;
    }

    @Override
    public boolean createTopic(Topic topic) throws SQLException, ClassNotFoundException {
        int rowsAffected=0;
        String sql = "INSERT INTO topics (name, created_at, updated_at) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, topic.getName());
            ps.setTimestamp(2, topic.getCreatedAt());
            ps.setTimestamp(3, topic.getUpdatedAt());

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected > 0;
    }
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TopicDAOImpl topicsImpl = new TopicDAOImpl();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Topic topic = new Topic("Harry",timestamp,timestamp);
        boolean success = topicsImpl.createTopic(topic);

        if (success) {
            System.out.println("Added successfully");
        } else {
            System.out.println("Not Added");
        }
    }
}
