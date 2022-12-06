package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> countries = new ArrayList<String>(){
        {
            add("UK");
            add("France");
            add("Spain");
            add("Germany");
            add("Russia");
            add("Italy");
            add("Poland");
            add("Romania");
            add("Netherlands");
            add("Belgium");
            add("Czechia");
            add("Greece");
            add("Portugal");
            add("Sweden");
            add("Hungary");
            add("Austria");
            add("Switzerland");
            add("Denmark");
            add("Norway");
            add("Ireland");
        }
    };

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setSize(1920,1080);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS));
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JLabel picture = new JLabel();
        picture.setIcon(new ImageIcon());
        Box buttonsholder = Box.createVerticalBox();

        ButtonGroup buttons = new ButtonGroup();

        for(String country : countries){
            JRadioButton europe = new JRadioButton(country);
            europe.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String imageURL = this.getClass().getClassLoader().getResource(country + ".jpg").getFile();
                    System.out.println(imageURL);
                    BufferedImage myPicture = null;
                    try {
                        myPicture = ImageIO.read(new File(imageURL));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    picture.setIcon(new ImageIcon(myPicture));
                    }
                }
            );
            buttons.add(europe);
            buttonsholder.add(europe);
        }

        left.add(buttonsholder);
        frame.add(left);
        frame.add(right);
        right.add(picture);
        picture.setVisible(true);
        right.setVisible(true);
        left.setVisible(true);
        frame.setVisible(true);
    }

}
