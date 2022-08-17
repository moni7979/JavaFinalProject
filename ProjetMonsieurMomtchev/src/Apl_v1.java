import javax.swing.*;

import java.awt.List;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

import java.util.ArrayList;

public class Apl_v1 extends JFrame{
    private static final long serialVersionUID = 1L;
    protected JButton ad;
    protected JTextField tf[]= new JTextField[2];
    protected List lst;

    protected JPanel contr, plst;

    protected AdSt adSt;
    protected ArrayList<Student>  prs;

    Apl_v1(int x, int y, int ln, int ht){
        this.setLayout(new BorderLayout());
        this.setBounds(x, y, ln, ht);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student's directory - version 1");

        contr = new JPanel(new FlowLayout());
        plst = new JPanel(new FlowLayout());

        ad = new JButton("add");
        contr.add(ad);
        tf[0]= new JTextField("name?",10);
        tf[1]= new JTextField("note?",3);
        contr.add(tf[0]);
        contr.add(tf[1]);
        ad.addActionListener(adSt=new AdSt());
        add("North",contr);

        prs=new ArrayList<Student>();
        lst = new List(10);
        plst.add(lst);
        add("Center",plst);     
        revalidate();
    }
    class AdSt implements ActionListener{
        public void actionPerformed(ActionEvent e ){
            Student s;
            int nt;
            String n=tf[0].getText();
            if(n.equals("name?")) {
                tf[1].setText("note?");
                return;
            }
               
            try{
                nt=Integer.parseInt(tf[1].getText());
            }
            catch(NumberFormatException ex){
                tf[1].setText("note?");
                return;
            }
            prs.add( s=new Student(n,nt));
            tf[0].setText("name?");tf[1].setText("note?");
            lst.add(""+s);
            revalidate();
        }
    }
    public static void main(String [] arg){
        new Apl_v1(20,20,400,300);
    }
}