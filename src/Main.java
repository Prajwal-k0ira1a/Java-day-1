import Controller.TopicController;
import View.TopicView;

public class Main {

    public static void main(String[] args) {

        TopicController controller = new TopicController();
        TopicView view = new TopicView(controller);

        view.showMenu();
    }
}
