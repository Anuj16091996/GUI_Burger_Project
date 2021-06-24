import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BurgerSection extends JPanel /*implements ActionListener*/ {
    private JLabel burgerLabel;
    private JComboBox burgerBox;
    private JButton burgerSubmit;
    private ArrayList<Burger> burgers;

    private FormListener formListener;

    BurgerSection(){
        burgerLabel = new JLabel("Select Your Burger");
        burgerBox = new JComboBox();
        burgerSubmit = new JButton("Submit");

        //Adding Burger to arraylist
        burgers = new ArrayList<Burger>();
        burgers.add(new Burger("Basic",
                "With White With Chicken", 3.56
                , 4));
        burgers.add(new Burger("Healthy",
                "With Brown Rye With Bacon", 5.67
                , 6));
        burgers.add(new Burger("Deluxe",
                "With White with Sausage", 14.54
                , 2));

        //Adding Burger To Combo Box
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        for (Burger b: burgers) {
            comboModel.addElement(b);
        }

        //Setting the model to burger box
        burgerBox.setModel(comboModel);

        setLayout(new GridLayout(3,1));
        burgerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(burgerLabel);
        add(burgerBox);
        add(burgerSubmit);
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        try {
            Burger userSelection= (Burger) burgerBox.getSelectedItem();

            //Calling Form Event
            FormEvent fe = new FormEvent(e,userSelection);

            //Checking That FormListener is not null
            if(formListener!= null)
            {
                burgersSelected.add(userSelection);
                formListener.Form_Event_Trigger(fe);
                burgerBox.setSelectedIndex(-1);
                toppingsLabel = new JLabel("Add "+ userSelection.getMaxToppings() +" toppings -: ");

                Border bor= BorderFactory.createLineBorder(Color.BLACK);
                setBorder(bor);
                alignment_2();
            }
        }catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Please Select An option",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }*/

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}
