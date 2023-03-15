import java.awt.event.*;

public class Apl_v3 extends Apl_v2 {
    private static final long serialVersionUID = 1L;
    protected InName in_f;
    protected InNote int_f;

//    public static void main(String[] args) {
//        new Apl_v3();
//    }

    Apl_v3() {
        textFields[0].addFocusListener(in_f = new InName());
        textFields[1].addFocusListener(int_f = new InNote());
        textFields[1].addActionListener(addStudent);
        this.setTitle("Student's directory - version 3");
    }

    class InName implements FocusListener {
        public void focusGained(FocusEvent e) {
            if (textFields[0].getText().equals("name?"))
                textFields[0].setText("");
        }

        public void focusLost(FocusEvent e) {
            if (textFields[0].getText().equals(""))
                textFields[0].setText("name?");
        }
    }

    class InNote implements FocusListener {
        public void focusGained(FocusEvent e) {
            if (textFields[1].getText().equals("note?"))
                textFields[1].setText("");
        }

        public void focusLost(FocusEvent e) {
            if (textFields[1].getText().equals(""))
                textFields[1].setText("note?");
        }
    }
}
