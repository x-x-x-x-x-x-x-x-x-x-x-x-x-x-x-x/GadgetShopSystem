import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener
{
private ArrayList<Gadget> gadgets;

private JTextField modelField, priceField, weightField, sizeField;
private JTextField creditField, memoryField;
private JTextField phoneField, durationField;
private JTextField downloadField, displayField;

private JButton addMobile, addMP3, clear, displayAll, makeCall, downloadMusic, remove;

public GadgetShop()
{
    gadgets = new ArrayList<>();

    setTitle("Gadget Shop");
    setSize(550,450); // slightly bigger for better layout
    setLayout(new GridLayout(13,2)); // increased rows

    getContentPane().setBackground(Color.LIGHT_GRAY);

    modelField = new JTextField();
    priceField = new JTextField();
    weightField = new JTextField();
    sizeField = new JTextField();
    creditField = new JTextField();
    memoryField = new JTextField();
    phoneField = new JTextField();
    durationField = new JTextField();
    downloadField = new JTextField();
    displayField = new JTextField();

    add(new JLabel("Model")); add(modelField);
    add(new JLabel("Price")); add(priceField);
    add(new JLabel("Weight")); add(weightField);
    add(new JLabel("Size")); add(sizeField);
    add(new JLabel("Credit")); add(creditField);
    add(new JLabel("Memory")); add(memoryField);
    add(new JLabel("Phone Number")); add(phoneField);
    add(new JLabel("Duration")); add(durationField);
    add(new JLabel("Download Size")); add(downloadField);
    add(new JLabel("Display Number")); add(displayField);

    addMobile = new JButton("Add Mobile");
    addMP3 = new JButton("Add MP3");
    clear = new JButton("Clear");
    displayAll = new JButton("Display All");
    makeCall = new JButton("Make Call");
    downloadMusic = new JButton("Download Music");
    remove = new JButton("Remove Gadget");

    add(addMobile);
    add(addMP3);
    add(clear);
    add(displayAll);
    add(makeCall);
    add(downloadMusic);
    add(remove); // NEW BUTTON

    addMobile.addActionListener(this);
    addMP3.addActionListener(this);
    clear.addActionListener(this);
    displayAll.addActionListener(this);
    makeCall.addActionListener(this);
    downloadMusic.addActionListener(this);
    remove.addActionListener(this); // NEW LISTENER

    setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
    try
    {
        if(e.getSource() == addMobile)
        {
            String model = modelField.getText();
            String size = sizeField.getText();

            if(model.isEmpty() || size.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Fill all fields");
                return;
            }

            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            int credit = Integer.parseInt(creditField.getText());

            Mobile m = new Mobile(model,price,weight,size,credit);
            gadgets.add(m);

            JOptionPane.showMessageDialog(this,"Mobile added successfully");
        }

        if(e.getSource() == addMP3)
        {
            String model = modelField.getText();
            String size = sizeField.getText();

            if(model.isEmpty() || size.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Fill all fields");
                return;
            }

            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            int memory = Integer.parseInt(memoryField.getText());

            MP3 mp = new MP3(model,price,weight,size,memory);
            gadgets.add(mp);

            JOptionPane.showMessageDialog(this,"MP3 added successfully");
        }

        if(e.getSource() == displayAll)
        {
            if(gadgets.size() == 0)
            {
                JOptionPane.showMessageDialog(this,"No gadgets available");
                return;
            }

            String output = "";

            for(int i=0;i<gadgets.size();i++)
            {
                output += "Gadget " + i + "\n";
                output += gadgets.get(i).display() + "\n";
            }

            JOptionPane.showMessageDialog(this, output);
        }

        if(e.getSource() == clear)
        {
            modelField.setText("");
            priceField.setText("");
            weightField.setText("");
            sizeField.setText("");
            creditField.setText("");
            memoryField.setText("");
            phoneField.setText("");
            durationField.setText("");
            downloadField.setText("");
            displayField.setText("");
        }

        if(e.getSource() == makeCall)
        {
            int index = Integer.parseInt(displayField.getText());
            String phone = phoneField.getText();
            int duration = Integer.parseInt(durationField.getText());

            if(index < 0 || index >= gadgets.size())
            {
                JOptionPane.showMessageDialog(this,"Invalid display number");
                return;
            }

            if(!(gadgets.get(index) instanceof Mobile))
            {
                JOptionPane.showMessageDialog(this,"Not a Mobile");
                return;
            }

            Mobile m = (Mobile) gadgets.get(index);

            String result = m.makeCall(phone,duration);
            JOptionPane.showMessageDialog(this, result);
        }

        if(e.getSource() == downloadMusic)
        {
            int index = Integer.parseInt(displayField.getText());
            int size = Integer.parseInt(downloadField.getText());

            if(index < 0 || index >= gadgets.size())
            {
                JOptionPane.showMessageDialog(this,"Invalid display number");
                return;
            }

            if(!(gadgets.get(index) instanceof MP3))
            {
                JOptionPane.showMessageDialog(this,"Not an MP3");
                return;
            }

            MP3 mp = (MP3) gadgets.get(index);

            String result = mp.downloadMusic(size);
            JOptionPane.showMessageDialog(this, result);
        }

        // REMOVE FEATURE
        if(e.getSource() == remove)
        {
            int index = Integer.parseInt(displayField.getText());

            if(index < 0 || index >= gadgets.size())
            {
                JOptionPane.showMessageDialog(this,"Invalid display number");
                return;
            }

            gadgets.remove(index);

            JOptionPane.showMessageDialog(this,"Gadget removed successfully");
        }
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,"Invalid input");
    }
}

public static void main(String[] args)
{
    new GadgetShop();
}

}