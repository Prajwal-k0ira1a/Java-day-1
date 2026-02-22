package Controller;

import Model.Topic;
import java.util.ArrayList;

public class TopicController {
    private ArrayList<Topic> topicList = new ArrayList<>();
    private int idCounter = 1;

    public boolean addTopic(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        Topic topic = new Topic(idCounter++, name.trim());
        topicList.add(topic);
        return true;
    }

    public ArrayList<Topic> getAllTopics() {
        return topicList;
    }

    public boolean isEmpty() {
        return topicList.isEmpty();
    }

}
