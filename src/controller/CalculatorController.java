package controller;

import model.CalculatorModel;
import service.CalculatorService;
import view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorView view;
    private CalculatorModel model;
    private CalculatorService service;

    public CalculatorController(CalculatorView view, CalculatorModel model, CalculatorService service) {
        this.view = view;
        this.model = model;
        this.service = service;

        for (JButton button : view.getNumberButtons()) {
            button.addActionListener(this);
        }

        for (JButton button : view.getFunctionButtons()) {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < view.getNumberButtons().length; i++) {
            if (e.getSource() == view.getNumberButtons()[i]) {
                view.getDisplay().setText(view.getDisplay().getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == view.getFunctionButtons()[4]) {
            view.getDisplay().setText(view.getDisplay().getText().concat("."));
        }

        if (e.getSource() == view.getFunctionButtons()[0]) {
            model.setNum1(Double.parseDouble(view.getDisplay().getText()));
            model.setOperator('+');
            view.getDisplay().setText("");
        }

        if (e.getSource() == view.getFunctionButtons()[1]) {
            model.setNum1(Double.parseDouble(view.getDisplay().getText()));
            model.setOperator('-');
            view.getDisplay().setText("");
        }

        if (e.getSource() == view.getFunctionButtons()[2]) {
            model.setNum1(Double.parseDouble(view.getDisplay().getText()));
            model.setOperator('*');
            view.getDisplay().setText("");
        }

        if (e.getSource() == view.getFunctionButtons()[3]) {
            model.setNum1(Double.parseDouble(view.getDisplay().getText()));
            model.setOperator('/');
            view.getDisplay().setText("");
        }

        if (e.getSource() == view.getFunctionButtons()[5]) {
            model.setNum2(Double.parseDouble(view.getDisplay().getText()));
            double result = service.calculate(model.getNum1(), model.getNum2(), model.getOperator());
            view.getDisplay().setText(String.valueOf(result));
        }

        if (e.getSource() == view.getFunctionButtons()[7]) {
            view.getDisplay().setText("");
        }

        if (e.getSource() == view.getFunctionButtons()[6]) {
            String string = view.getDisplay().getText();
            view.getDisplay().setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                view.getDisplay().setText(view.getDisplay().getText() + string.charAt(i));
            }
        }
    }
}
