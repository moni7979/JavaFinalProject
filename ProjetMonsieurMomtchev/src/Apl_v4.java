import javax.swing.*;
import java.io.Serial;


public class Apl_v4 extends Apl_v3 {

    @Serial
    private static final long serialVersionUID = 1L;
    protected JButton orderButton;
    protected JComboBox<String> notesToClick;
    protected JMenuBar menuBar;
    protected JMenu fileMenu;
    protected static JTextField message = new JTextField();

    Apl_v4() {

        this.setTitle("Student's directory - version 4");
        String[] noteValues = new String[]{"1", "2", "3", "4", "5",
                                            "6", "7", "8", "9", "10", "11",
                                            "12", "13", "14", "15", "16",
                                            "17", "18", "19", "20"};
        notesToClick = new JComboBox<>(noteValues);
        notesToClick.setBounds(10, 10, 20, 50);
        notesToClick.setVisible(true);
        notesToClick.addActionListener(e -> textFields[1].setText((String) notesToClick.getSelectedItem()));
        controlPanel.add(notesToClick);


        orderButton = new JButton("Order by note desc.");
        orderButton.setBounds(15, 15, 20, 50);
        orderButton.setVisible(true);
        orderButton.addActionListener(e -> {
            studentArrayList.sort((o1, o2) -> {
                int student1Note = o1.note;
                int student2Note = o2.note;
                return Integer.compare(student2Note, student1Note);

            });
            list.removeAll();
            for (int i = 0; i < studentArrayList.size(); i++) {
                list.add("" + studentArrayList.get(i));
            }
            revalidate();
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

        controlPanel.add(notesToClick);
        controlPanel.add(orderButton);

    }

    public static void main(String[] args) {

        String[] responses = {"The best class in the whole world",
                "They have to do more exercises", "They have to quit"};
        String JOOpine = (String) JOptionPane.showInputDialog(null,
                "Choose comment",
                "Comment over their results",
                JOptionPane.QUESTION_MESSAGE,
                null,
                responses,
                responses[0]);

        if (JOOpine == null) {
            message.setVisible(false);
        } else {
            message.setText(JOOpine);
            message.setVisible(true);
        }

        new Apl_v4();

    }
}
