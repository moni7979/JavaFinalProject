import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class Apl_v4 extends Apl_v3 {
    private static final long serialVersionUID = 1L;


    protected JButton orderButton;
    protected JComboBox<String> chiffres1;
    protected JMenuBar menuBar;
    protected JMenu fileMenu;
    protected static JTextField message = new JTextField();

    Apl_v4() {


        String[] chiffresValues = new String[]{"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10", "11",
                "12", "13", "14", "15", "16",
                "17", "18", "19", "20"};
        chiffres1 = new JComboBox<String>(chiffresValues);
        chiffres1.setBounds(10, 10, 20, 50);
        chiffres1.setVisible(true);
        chiffres1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFields[1].setText((String) chiffres1.getSelectedItem());
            }
        });
        controlPanel.add(chiffres1);


        orderButton = new JButton("Order by note desc.");
        orderButton.setBounds(15, 15, 20, 50);
        orderButton.setVisible(true);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentArrayList.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        int student1Note = o1.note;
                        int student2Note = o2.note;
                        if (student1Note < student2Note) {
                            return 1;
                        } else if (student1Note > student2Note) {
                            return -1;
                        } else {
                            return 0;
                        }

                    }
                });
                list.removeAll();
                for (int i = 0; i < studentArrayList.size(); i++) {
                    list.add("" + studentArrayList.get(i));
                }
                revalidate();
            }

        });


        message.setBounds(20, 20, 200, 20);
        personPanel.add(message);
        revalidate();


        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.add(loadButton);
        fileMenu.add(saveButton);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        Icon saveIcon = new ImageIcon("saveIcon.png");
        Icon uploadIcon = new ImageIcon("uploadIcon.png");
        saveButton.setIcon(saveIcon);
        loadButton.setIcon(uploadIcon);


        this.setTitle("Student's directory - version 4");
        //controlPanel.add(menuBar);
        //controlPanel.add(fileMenu);
        controlPanel.add(chiffres1);
        controlPanel.add(orderButton);
    }

//    public static void main(String[] args) {
//
//
//        String[] responses = {"La meilleure classe  à l'université",
//                "Ils ont besoin de plus d'exercices", "Ils doivent quitter l'université"};
//        String JOpane = (String) JOptionPane.showInputDialog(null,
//                "Choisir le commentaire",
//                "Commentaire sur les resultats",
//                JOptionPane.QUESTION_MESSAGE,
//                null,
//                responses,
//                responses[0]);
//
//        if (JOpane == null) {
//            message.setVisible(false);
//        } else {
//            message.setText(JOpane);
//            message.setVisible(true);
//        }
//        new Apl_v4();
//
//    }
}
