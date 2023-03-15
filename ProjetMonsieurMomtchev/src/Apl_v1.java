import javax.swing.*;

import java.awt.List;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

import java.io.Serial;
import java.util.ArrayList;


public class Apl_v1 extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    protected JButton button;
    protected JTextField[] textFields = new JTextField[2];
    protected List list;
    protected JPanel controlPanel, personPanel;
    protected addStudent addStudent;
    protected ArrayList<Student> studentArrayList;

    public Apl_v1(int x, int y, int length, int height) {
        this.setLayout(new BorderLayout());
        this.setBounds(x, y, length, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student's directory - version 1");
        controlPanel = new JPanel(new FlowLayout());
        personPanel = new JPanel(new FlowLayout());
        button = new JButton("add");
        controlPanel.add(button);
        textFields[0] = new JTextField("name?", 10);
        textFields[1] = new JTextField("note?", 3);
        controlPanel.add(textFields[0]);
        controlPanel.add(textFields[1]);
        button.addActionListener(addStudent = new addStudent());
        add("North", controlPanel);

        studentArrayList = new ArrayList<>();
        list = new List(10);
        personPanel.add(list);
        add("Center", personPanel);
        revalidate();
    }

    class addStudent implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Student student;
            int note;
            String n = textFields[0].getText();
            if (n.equals("name?")) {
                textFields[1].setText("note?");
                return;
            }

            try {
                note = Integer.parseInt(textFields[1].getText());
            } catch (NumberFormatException ex) {
                textFields[1].setText("note?");
                return;
            }
            studentArrayList.add(student = new Student(n, note));
            textFields[0].setText("name?");
            textFields[1].setText("note?");
            list.add("" + student);
            revalidate();
        }
    }

//    public static void main(String[] arg) {
//        new Apl_v1(20, 20, 400, 300);
//    }
}