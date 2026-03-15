package dao.interfaces;

import model.Entry;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntryDAOImpl implements EntryDAOInterface {

    private static final String INSERT_ENTRY_SQL =
            "INSERT INTO entries (topic_id, created_at, updated_at) VALUES (?, ?, ?)";
    private static final String SELECT_BY_TOPIC_SQL =
            "SELECT * FROM entries WHERE topic_id = ? ORDER BY created_at DESC";

    @Override
    public boolean createEntry(Entry entry) throws SQLException, ClassNotFoundException {
        int rowsAffected = 0;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_ENTRY_SQL)) {

            ps.setInt(1, entry.getTopicId());
            ps.setTimestamp(2, entry.getCreatedAt());
            ps.setTimestamp(3, entry.getUpdatedAt());

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected > 0;
    }

    @Override
    public List<Entry> getEntriesByTopicId(int topicId) throws SQLException, ClassNotFoundException {
        List<Entry> entries = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_TOPIC_SQL)) {

            ps.setInt(1, topicId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Entry entry = new Entry();
                    entry.setId(rs.getInt("id"));
                    entry.setTopicId(rs.getInt("topic_id"));
                    entry.setCreatedAt(rs.getTimestamp("created_at"));
                    entry.setUpdatedAt(rs.getTimestamp("updated_at"));
                    entries.add(entry);
                }
            }
        }

        return entries;
    }
}
