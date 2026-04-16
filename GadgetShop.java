import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.*;

public class GadgetShop extends JFrame implements ActionListener
{
private ArrayList<Gadget> gadgets;

private JTextField modelField;
private JTextField priceField;
private JTextField weightField;
private JTextField sizeField;
private JTextField creditField;
private JTextField memoryField;
private JTextField phoneField;
private JTextField durationField;
private JTextField downloadField;
private JTextField displayField;

private JButton addMobile;
private JButton addMP3;
private JButton clear;
private JButton displayAll;
private JButton makeCall;
private JButton downloadMusic;

public GadgetShop()
{
    gadgets = new ArrayList<>();

    setTitle("Gadget Shop");
    setSize(500,400);
    setLayout(new GridLayout(12,2));

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

    add(addMobile);
    add(addMP3);
    add(clear);
    add(displayAll);
    add(makeCall);
    add(downloadMusic);

    addMobile.addActionListener(this);
    addMP3.addActionListener(this);
    clear.addActionListener(this);
    displayAll.addActionListener(this);
    makeCall.addActionListener(this);
    downloadMusic.addActionListener(this);

    setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
    try
    {
        if(e.getSource() == addMobile)
        {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());

            Mobile m = new Mobile(model,price,weight,size,credit);
            gadgets.add(m);
        }

        if(e.getSource() == addMP3)
        {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int memory = Integer.parseInt(memoryField.getText());

            MP3 mp = new MP3(model,price,weight,size,memory);
            gadgets.add(mp);
        }

        if(e.getSource() == displayAll)
        {
            for(int i=0;i<gadgets.size();i++)
            {
                System.out.println("Gadget number: " + i);
                gadgets.get(i).display();
                System.out.println();
            }
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

            Mobile m = (Mobile) gadgets.get(index);
            m.makeCall(phone,duration);
        }

        if(e.getSource() == downloadMusic)
        {
            int index = Integer.parseInt(displayField.getText());
            int size = Integer.parseInt(downloadField.getText());

            MP3 mp = (MP3) gadgets.get(index);
            mp.downloadMusic(size);
        }
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,"Input error");
    }
}

public static void main(String[] args)
{
    new GadgetShop();
}

}