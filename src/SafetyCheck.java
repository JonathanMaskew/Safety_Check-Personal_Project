import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafetyCheck {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showMainFrame();
            }
        });
    }

    public static void showMainFrame()  {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Safety Check");
        mainFrame.setSize(600, 150);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(3,0));
        mainFrame.setVisible(true);

        JButton checkInButton = new JButton("Check In Now");
        mainFrame.add(checkInButton);

        JLabel bottomText = new JLabel("If you do not check in any day, the people you've specified will be contacted to check on you.");
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(bottomText);

        JButton contactsButton = new JButton("Edit Contacts");
        mainFrame.add(contactsButton);

        contactsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                showContactsFrame();
            }
        });
    }

    public static void showContactsFrame()  {
        JFrame contactsFrame = new JFrame();
        contactsFrame.setTitle("Safety Check");
        contactsFrame.setSize(800, 150);
        contactsFrame.setLocationRelativeTo(null);
        contactsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contactsFrame.setLayout(new GridLayout(4,0));
        contactsFrame.setVisible(true);

        JLabel instructions = new JLabel("Insert the phone numbers below, separated by a comma, that you'd like to be contacted in the case you don't check in.");
        contactsFrame.add(instructions);

        JLabel example = new JLabel("Formatting example: \"1111111111, 0000000000, ...\"");
        contactsFrame.add(example);

        JTextField phoneNums = new JTextField();
        contactsFrame.add(phoneNums);

        JButton doneButton = new JButton("Done");
        contactsFrame.add(doneButton);

        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contactsFrame.dispose();
                showMainFrame();
            }
        });
    }
}