package org.balbucio.frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(){
        super("Calculadora");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(480, 265);
        this.setLayout(new BorderLayout());
        JPanel cima = new JPanel();
        cima.setBackground(Color.MAGENTA);
        cima.add(new JLabel("CALCULADORA DO PAE"), BorderLayout.CENTER);
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(new EmptyBorder(15, 15, 15, 15));
        addOptions(center);
        setVisible(true);
        this.add(cima, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
    }

    public void addOptions(JPanel panel){
        JPanel first = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //
        first.add(new JLabel("Número 1: "));
        JTextField firstField = new JTextField();
        firstField.setPreferredSize(new Dimension(128, 20));
        first.add(firstField);
        //
        JPanel second = new JPanel(new FlowLayout(FlowLayout.CENTER));
        second.add(new JLabel("Número 2: "));
        JTextField secondField = new JTextField();
        secondField.setPreferredSize(new Dimension(128, 20));
        second.add(secondField);
        JPanel sin = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JComboBox<String> sinais = new JComboBox<>(new String[]{"+", "-", "/", "*"});
        sinais.setSize(192, 40);
        sin.add(sinais);

        JPanel result = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setPreferredSize(new Dimension(128, 20));
        result.add(new JLabel("Resultado: "));
        result.add(resultField);

        JPanel btn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("Calcular");
        button.addActionListener((e) -> {
            Integer firstNumber = Integer.parseInt(firstField.getText());
            Integer secondNumber = Integer.parseInt(secondField.getText());
            switch (sinais.getItemAt(sinais.getSelectedIndex())){
                case "+":
                    resultField.setText(String.valueOf(firstNumber+secondNumber));
                    break;
                case "-":
                    resultField.setText(String.valueOf(firstNumber-secondNumber));
                    break;
                case "/":
                    resultField.setText(String.valueOf(firstNumber/secondNumber));
                    break;
                case "*":
                    resultField.setText(String.valueOf(firstNumber*secondNumber));
                    break;
            }
        });
        JButton limpar = new JButton("Limpar");
        limpar.addActionListener((e) -> {
            firstField.setText("");
            secondField.setText("");
            resultField.setText("");
        });
        btn.add(button);
        btn.add(limpar);


        panel.add(first);
        panel.add(second);
        panel.add(sin);
        panel.add(result);
        panel.add(btn);
    }
}
