package mocktextgenerator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MockTextGenerator extends JFrame {

    public static void main(String[] args) {

        testing();

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JTextArea input = new JTextArea("Input Text");
        JScrollPane inScroll = new JScrollPane(input);
        JTextArea output = new JTextArea("Output Text");
        JScrollPane outScroll = new JScrollPane(output);
        JButton convert = new JButton("Convert");
        String[] styleoptions = {"SongeBob Mocking Text", "All Caps", "All Lower", "Weebify", "1337"};
        JComboBox style = new JComboBox(styleoptions);
        BorderLayout layout = new BorderLayout();

        frame.add(panel);

        panel.setLayout(layout);
        

        //Addd stuff to the panel
        panel.add(style, BorderLayout.PAGE_START);
        panel.add(inScroll, BorderLayout.LINE_START);
        panel.add(convert, BorderLayout.CENTER);
        panel.add(outScroll, BorderLayout.LINE_END);

        //setup the panel
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        //re-align components
        input.setLineWrap(true);
        input.setSize(300, 600);
        output.setLineWrap(true);
        output.setSize(300,600);
        
        //methods
        convert.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                String newtext = convertText(input.getText());
                output.setText(newtext);
            }
        });

    }

    public static ArrayList<Character> charList = new ArrayList<Character>();
    public static int random = 0;
    public static String t = "";

    public static String convertText(String text) {
        t = "";
        charList.clear();
        recursiveConvert(text, text.length());
        for (int j = charList.size() - 1; j > -1; j--) {
            t += charList.get(j);
        }
        return t;
    }

    public static void recursiveConvert(String text, int length) {
        if (length == 1) {
            //base case
            String x = text.substring(length - 1, length);
            random = (int) Math.floor(Math.random() * 2);
            String z = "";
            if (random == 1) {
                z = x.toLowerCase();
            } else {
                z = x.toUpperCase();
            }
            char y = z.charAt(0);
            charList.add(y);
        } else {
            //recursion
            String x = text.substring(length - 1, length);
            String z = "";
            if (random == 1) {
                z = x.toLowerCase();
            } else {
                z = x.toUpperCase();
            }
            char y = z.charAt(0);
            charList.add(y);
            random = (int) Math.floor(Math.random() * 2);
            recursiveConvert(text, length - 1);
        }
    }

//<editor-fold desc="Testing">
    public static void testing() {
        String str = "testString";
        ArrayList<Character> list = new ArrayList<Character>();
        int rnd = 0;
        for (int i = 0; i < str.length(); i++) {

            if (rnd == 0) {
                String x = str.substring(i, i + 1);
                String z = x.toLowerCase();
                char y = z.charAt(0);
                list.add(y);
                rnd = (int) Math.floor(Math.random() * 2);
            } else if (rnd == 1) {
                String x = str.substring(i, i + 1);
                String z = x.toUpperCase();
                char y = z.charAt(0);
                list.add(y);
                rnd = (int) Math.floor(Math.random() * 2);
            } else {
                System.out.println("ERROR");
            }

        }

        str = "";

        for (int j = 0; j < list.size(); j++) {
            str += list.get(j);
        }

        System.out.println(str);

    }
    //</editor-fold>

}


