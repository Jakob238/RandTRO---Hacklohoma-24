import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class RandomRetros extends JPanel
{
    // Instances Variables
    private static final String WINDOW_TITLE = "Random Retro Project!";
    private String stringURL = "https://shorturl.at/oxQ23";

    public void setStringURL(String stringURL) {
        this.stringURL = stringURL;
    }
    public String getStringURL() {
        return this.stringURL;
    }
    public static void main(String[] args) {
        RandomRetros panel = new RandomRetros();
        JFrame frame = new JFrame(WINDOW_TITLE);
        JLabel label = new JLabel("");

        int width = 1920;
        int height = 1080;
        

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); 
        frame.setVisible(true);

        panel.setFocusable(true);
        panel.requestFocus();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // Call a method to handle space bar press
                    System.out.println("Space bar pressed!");
                    // Call a method to get a random image here
                    panel.setStringURL(panel.generateRandomPicture());
                    panel.repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            Image image = new ImageIcon(new URL(stringURL)).getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 
    public int randomIndex(String [] ar){
        return (int) (Math.random() * ar.length);
    }

    public String generateRandomPicture()
    {
        //array of pictures
        String[] arrOfPictures = {"https://shorturl.at/hlovE", "https://shorturl.at/eimzV", "https://shorturl.at/gkPRY", "https://shorturl.at/puIW0", "https://shorturl.at/oxQ23","https://shorturl.at/sMNQ7", "https://shorturl.at/FIU49", "https://shorturl.at/cknrU"};
        return arrOfPictures[randomIndex(arrOfPictures)];
    }
}
