import java.awt.event.*;
public class Apl_v3 extends Apl_v2{
    private static final long serialVersionUID = 1L;
    protected InName in_f;
    protected InNote int_f;
    public static void main(String[] args) {
        new Apl_v3();
    }
    Apl_v3(){
        tf[0].addFocusListener(in_f=new InName());
        tf[1].addFocusListener(int_f=new InNote());
        tf[1].addActionListener(adSt);
        this.setTitle("Student's directory - version 3");
    }
    class InName implements FocusListener{
        public void focusGained(FocusEvent e) {
            if (tf[0].getText().equals("name?"))
                tf[0].setText("");
        }
        public void focusLost(FocusEvent e){
            if (tf[0].getText().equals(""))
                tf[0].setText("name?");
        }
    }
    class InNote implements FocusListener{
        public void focusGained(FocusEvent e) {
            if (tf[1].getText().equals("note?"))
                tf[1].setText("");
        }
        public void focusLost(FocusEvent e){
            if (tf[1].getText().equals(""))
                tf[1].setText("note?");
        }
    }
}
