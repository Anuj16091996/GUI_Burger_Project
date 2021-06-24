import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToppingSection extends JPanel {
    private FormListener formListener;

    private JLabel toppingsLabel;
    ArrayList<Topping> toppings;
    private JLabel tomatoLabel;
    private JLabel lettuceLabel;
    private JLabel cheeseLabel;
    private JLabel carrotLabel;
    private JButton toppingsSubmit;
    private JTextField tomatoField;
    private JTextField lettuceField;
    private JTextField cheeseField;
    private JTextField carrotField;

    private JButton tomatoPlus;
    private JButton tomatoMinus;
    private JButton lettucePlus;
    private JButton lettuceMinus;
    private JButton cheesePlus;
    private JButton cheeseMinus;
    private JButton carrotPlus;
    private JButton carrotMinus;

    ToppingSection(){
        setLayout(new GridLayout(5,4));

        tomatoLabel = new JLabel("Tomato: ");
        tomatoMinus = new JButton("—");
        tomatoField = new JTextField("0");
        tomatoPlus = new JButton("+");
        add(tomatoLabel);
        add(tomatoMinus);
        add(tomatoField);
        add(tomatoPlus);

        lettuceLabel = new JLabel("Lettuce: ");
        lettuceMinus = new JButton("—");
        lettuceField = new JTextField("0");
        lettucePlus = new JButton("+");
        add(lettuceLabel);
        add(lettuceMinus);
        add(lettuceField);
        add(lettucePlus);

        cheeseLabel = new JLabel("Cheese: ");
        cheeseMinus = new JButton("—");
        cheeseField = new JTextField("0");
        cheesePlus = new JButton("+");
        add(cheeseLabel);
        add(cheeseMinus);
        add(cheeseField);
        add(cheesePlus);

        carrotLabel = new JLabel("Carrot: ");
        carrotMinus = new JButton("—");
        carrotField = new JTextField("0");
        carrotPlus = new JButton("+");
        add(carrotLabel);
        add(carrotMinus);
        add(carrotField);
        add(carrotPlus);

        toppingsSubmit = new JButton("Submit");

        Dimension dim = new Dimension();
        dim.width = getWidth();
        toppingsSubmit.setHorizontalAlignment(SwingConstants.CENTER);

        add(toppingsSubmit);
    }
}
