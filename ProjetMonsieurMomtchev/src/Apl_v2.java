
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Apl_v2 extends Apl_v1 {

    private static final long serialVersionUID = 1L;
    protected JButton loadButton, saveButton;
    protected Load ld;
    protected Save sv;

    Apl_v2() {

        super(20, 20, 500, 250);
        loadButton = new JButton("loadButton");
        loadButton.addActionListener(ld = new Load());
        controlPanel.add(loadButton);
        saveButton = new JButton("saveButton");
        saveButton.addActionListener(sv = new Save());
        controlPanel.add(saveButton);
        setTitle("Student's directory - version 2");
        revalidate();
    }

//    public static void main(String arg[]) {
//        new Apl_v2();
//    }

    class Save implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(
                        new FileOutputStream("saveButton.ser"));
                oos.writeObject(studentArrayList);
            } catch (IOException ex) {
                System.out.println(ex);
            }
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
            }
        }
    }

    class Load implements ActionListener {
        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {
            ObjectInputStream ios = null;
            try {
                ios = new ObjectInputStream(new FileInputStream("saveButton.ser"));
                studentArrayList = (ArrayList<Student>) ios.readObject();
            } catch (Exception ex) {
                textFields[0].setText("Error");
            }
            try {
                if (ios != null) ios.close();
            } catch (IOException ex) {
            }
            list.removeAll();
            for (int i = 0; i < studentArrayList.size(); i++) {
                list.add("" + studentArrayList.get(i));
            }
        }
    }
}