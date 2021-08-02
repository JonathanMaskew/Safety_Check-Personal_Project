import javax.swing.*;
import java.awt.*;

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
        mainFrame.setSize(600, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);

        //Container centerContent = new Container();

        JButton checkInButton = new JButton("Check In Now");
        mainFrame.add(checkInButton, BorderLayout.CENTER);

        JLabel introText = new JLabel("Click \"Check In Now\" below to let your family know you're okay.");
        introText.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(introText, BorderLayout.NORTH);

        Container bottomContainer = new Container();
        bottomContainer.setLayout(new GridLayout(2, 0));

        JLabel bottomText = new JLabel("If you do not check in any day, the people you've specified will be contacted to check on you.");
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);
        bottomContainer.add(bottomText);

        JButton contactsButton = new JButton("Edit Contacts");
        bottomContainer.add(contactsButton);

        mainFrame.add(bottomContainer, BorderLayout.SOUTH);
    }
}