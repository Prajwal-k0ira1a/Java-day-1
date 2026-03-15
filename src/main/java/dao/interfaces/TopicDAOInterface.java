package dao.interfaces;

import model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDAOInterface {
    List<Topic> getAllTopics() throws SQLException, ClassNotFoundException;
    boolean createTopic(Topic topic) throws SQLException, ClassNotFoundException;
}
