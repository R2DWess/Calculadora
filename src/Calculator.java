import controller.CalculatorController;
import model.CalculatorModel;
import service.CalculatorService;
import view.CalculatorView;

public class Calculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorService service = new CalculatorService();
        CalculatorController controller = new CalculatorController(view, model, service);

        view.setVisible(true);
    }
}
