package dao.interfaces;

import model.Entry;

import java.sql.SQLException;
import java.util.List;

public interface EntryDAOInterface {
    boolean createEntry(Entry entry) throws SQLException, ClassNotFoundException;
    List<Entry> getEntriesByTopicId(int topicId) throws SQLException, ClassNotFoundException;
}
