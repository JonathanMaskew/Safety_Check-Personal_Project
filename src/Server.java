import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class Server {
    public static void main(String[] args) throws IOException, MessagingException {
        /*
        Socket socket = null;
        ServerSocket serverSocket = new ServerSocket(1234);

        BufferedReader bfr;
        PrintWriter pw;
         */

        File checkFile = new File("check.txt");
        FileReader fr = new FileReader(checkFile);
        BufferedReader bfr = new BufferedReader(fr);
        //PrintWriter pw = new PrintWriter(checkFile);

        while (true) {
            if (LocalDateTime.now().getHour() == 13)    {
                if (bfr.readLine().equals("No"))   {
                    sendNotifications();
                    break;
                    //pw.write("Yes");
                }
            }

            /*
            socket = serverSocket.accept();

            bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            */
        }
    }

    public static void sendNotifications() throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jmaskew1.compsci@gmail.com", "compSci@PU");
            }
        });

        Message message = new MimeMessage(session);
        message.setText("This message was sent from my Java program via email using JavaMail and JAF.");

        File phoneNums = new File("phoneNums.txt");
        FileReader fr = new FileReader(phoneNums);
        BufferedReader bfr = new BufferedReader(fr);
        InternetAddress emails[] = InternetAddress.parse(bfr.readLine());

        for (int i = 0; i < emails.length; i++) {
            InternetAddress newAddress = new InternetAddress(emails[i].toString() + "@vtext.com");
            message.addRecipient(Message.RecipientType.TO, newAddress);
        }

        Address addressFrom = new InternetAddress("jmaskew1.compsci@gmail.com");
        message.setFrom(addressFrom);

        Transport.send(message);
    }
}
