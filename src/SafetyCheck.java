import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class SafetyCheck {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    showMainFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void showMainFrame() throws IOException {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Safety Check");
        mainFrame.setSize(600, 250);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(4,0));
        mainFrame.setVisible(true);

        /*
        Socket socket = new Socket("localhost", 1234);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
         */

        JButton checkInButton = new JButton("Check In Now");
        mainFrame.add(checkInButton);

        JButton requestButton = new JButton("Send Emergency Alert Immediately");
        mainFrame.add(requestButton);

        JLabel bottomText = new JLabel("If you do not check in any day, the people you've specified will be contacted to check on you.");
        bottomText.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(bottomText);

        Container bottomButtonsContainer = new Container();
        bottomButtonsContainer.setLayout(new GridLayout(0, 2));
        JButton contactsButton = new JButton("Edit Contacts");
        bottomButtonsContainer.add(contactsButton);
        JButton timeButton = new JButton("Edit Alert Time");
        bottomButtonsContainer.add(timeButton);
        mainFrame.add(bottomButtonsContainer);

        contactsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                try {
                    showContactsFrame();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void showContactsFrame() throws IOException {
        File phoneFile = new File("phoneNums.txt");

        JFrame contactsFrame = new JFrame();
        contactsFrame.setTitle("Safety Check");
        contactsFrame.setSize(800, 150);
        contactsFrame.setLocationRelativeTo(null);
        contactsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contactsFrame.setLayout(new GridLayout(4,0));
        contactsFrame.setVisible(true);

        JLabel instructions = new JLabel("Insert the phone numbers below, separated by only a comma, that you'd like to be contacted in the case you don't check in.");
        contactsFrame.add(instructions);

        JLabel example = new JLabel("Formatting example: \"1111111111,0000000000,...\"");
        contactsFrame.add(example);

        FileReader fr = new FileReader(phoneFile);
        BufferedReader bfr = new BufferedReader(fr);
        JTextField phoneNums = new JTextField(bfr.readLine());
        contactsFrame.add(phoneNums);
        fr.close();
        bfr.close();

        JButton doneButton = new JButton("Done");
        contactsFrame.add(doneButton);

        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean satisfied = true;

                for (int i = 0; i < phoneNums.getText().length(); i++) {
                    if (Character.isAlphabetic(phoneNums.getText().charAt(i))) {
                        JOptionPane.showMessageDialog(null, "Your phone numbers should only contain numbers separated by commas.\nPlease ensure no letters are present.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        satisfied = false;
                        break;
                    } else if (!Character.isDigit(phoneNums.getText().charAt(i)) && phoneNums.getText().charAt(i) != ',') {
                        JOptionPane.showMessageDialog(null, "Your phone numbers should only contain numbers separated by commas.\nPlease ensure no spaces, parenthesis, or dashes are present.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        satisfied = false;
                        break;
                    }
                }
                //parse the string to remove spaces, dashes, parenthesis to put less restrictions on the user?
                //also check to make sure numbers are 10 digits in length?

                if (satisfied) {
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter(phoneFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        fw.write(phoneNums.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        fw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    contactsFrame.dispose();
                    try {
                        showMainFrame();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}