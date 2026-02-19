package View;

import Controller.TopicController;
import Model.Topic;

import java.util.List;
import java.util.Scanner;

public class TopicView {

    private TopicController controller;
    private Scanner scanner;

    public TopicView(TopicController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {

        while (true) {
            System.out.println("\n Welcome to Topic Management ");
            System.out.println("1. Add Topic");
            System.out.println("2. View Topics");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTopicUI();
                    break;
                case 2:
                    viewTopicsUI();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addTopicUI() {
        System.out.print("Enter name of Topic : ");
        String name = scanner.nextLine();

        boolean added = controller.addTopic(name);

        if (added) {
            System.out.println("Topic was added successfully.");
        } else {
            System.out.println("Topic was not added.");
        }
    }

    private void viewTopicsUI() {

        if (controller.isEmpty()) {
            System.out.println("No topics available.");
            return;
        }

        List<Topic> topics = controller.getAllTopics();

        System.out.println("\n--- Topics ---");
        for (Topic topic : topics) {
            System.out.println("ID: " + topic.getId() +
                    " | Name: " + topic.getName() +
                    " | CreatedAt: " + topic.getCreatedAt() +
                    " | UpdatedAt: " + topic.getUpdatedAt());
        }
    }
}
