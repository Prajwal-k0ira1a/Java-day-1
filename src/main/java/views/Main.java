package views;

import dao.interfaces.EntryDAOImpl;
import dao.interfaces.TopicDAOImpl;
import model.Entry;
import model.Topic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TopicDAOImpl topicDAO = new TopicDAOImpl();
        EntryDAOImpl entryDAO = new EntryDAOImpl();

        while (true) {
            System.out.println("\n===== Topic Management System =====");
            System.out.println("1. View all topics");
            System.out.println("2. Create a topic");
            System.out.println("3. Add a learning entry");
            System.out.println("4. View entries for a topic");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> displayTopics(topicDAO);
                    case 2 -> createTopic(scanner, topicDAO);
                    case 3 -> addEntry(scanner, topicDAO, entryDAO);
                    case 4 -> listEntries(scanner, topicDAO, entryDAO);
                    case 5 -> {
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayTopics(TopicDAOImpl topicDAO) throws Exception {
        List<Topic> topics = topicDAO.getAllTopics();
        if (topics.isEmpty()) {
            System.out.println("\nNo topics found.");
            return;
        }

        System.out.println("\n--- Topics List ---");
        for (Topic topic : topics) {
            System.out.println(topic.getId() + " - " + topic.getName());
        }
    }

    private static void createTopic(Scanner scanner, TopicDAOImpl topicDAO) throws Exception {
        System.out.print("Enter topic name: ");
        String name = scanner.nextLine();

        Topic newTopic = new Topic();
        newTopic.setName(name);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        newTopic.setCreatedAt(now);
        newTopic.setUpdatedAt(now);

        boolean created = topicDAO.createTopic(newTopic);
        if (created) {
            System.out.println("Topic created successfully!");
        } else {
            System.out.println("Failed to create topic.");
        }
    }

    private static void addEntry(Scanner scanner, TopicDAOImpl topicDAO, EntryDAOImpl entryDAO) throws Exception {
        List<Topic> topics = topicDAO.getAllTopics();
        if (topics.isEmpty()) {
            System.out.println("No topics available. Please create a topic first.");
            return;
        }

        displayTopics(topicDAO);
        System.out.print("Enter the topic ID to add an entry: ");
        int topicId = scanner.nextInt();
        scanner.nextLine();

        boolean topicExists = topics.stream().anyMatch(topic -> topic.getId() == topicId);
        if (!topicExists) {
            System.out.println("Topic ID not found.");
            return;
        }

        System.out.print("Enter your learning note: ");
        String note = scanner.nextLine();

        Timestamp now = new Timestamp(System.currentTimeMillis());
        Entry entry = new Entry(topicId, note, now, now);
        boolean created = entryDAO.createEntry(entry);

        System.out.println(created ? "Entry saved!" : "Failed to save entry.");
    }

    private static void listEntries(Scanner scanner, TopicDAOImpl topicDAO, EntryDAOImpl entryDAO) throws Exception {
        List<Topic> topics = topicDAO.getAllTopics();
        if (topics.isEmpty()) {
            System.out.println("No topics exist yet.");
            return;
        }

        displayTopics(topicDAO);
        System.out.print("Enter the topic ID whose entries you want to see: ");
        int topicId = scanner.nextInt();
        scanner.nextLine();

        boolean topicExists = topics.stream().anyMatch(topic -> topic.getId() == topicId);
        if (!topicExists) {
            System.out.println("Topic ID not found.");
            return;
        }

        List<Entry> entries = entryDAO.getEntriesByTopicId(topicId);
        if (entries.isEmpty()) {
            System.out.println("No entries yet for this topic.");
            return;
        }

        System.out.println("\n--- Entries ---");
        for (Entry entry : entries) {
            System.out.printf("[%d] %s (created: %s)%n", entry.getId(), entry.getNote(), entry.getCreatedAt());
        }
    }
}
