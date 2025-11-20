import view.View;
import controller.SortingMethods;
import controller.SearchMethods;
import controller.Controller;

public class App {
    public static void main(String[] args) throws Exception {
        View view = new View();
        SortingMethods sorter = new SortingMethods();
        SearchMethods searcher = new SearchMethods();
        Controller controller = new Controller(view, sorter, searcher);
        controller.start();
    }
}
