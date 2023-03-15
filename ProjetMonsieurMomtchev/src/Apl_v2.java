
import javax.swing.*;
import java.awt.event.*;
//package exam;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Apl_v2 extends Apl_v1{
    private static final long serialVersionUID = 1L;
    protected JButton load,save;
    protected Load ld;
    protected Save sv;
    Apl_v2(){
        super(20,20,500,250);
        load = new JButton("load");
        load.addActionListener(ld = new Load());
        contr.add(load);
        save = new JButton("save");
        save.addActionListener(sv=new Save());
        contr.add(save);
        setTitle("Student's directory - version 2");
        revalidate();
    }
    public static void main(String arg[]){
        new Apl_v2();
    }
    class Save implements ActionListener  {
        public void actionPerformed(ActionEvent e ){
            ObjectOutputStream oos = null;
            try{
                oos = new ObjectOutputStream (
                        new FileOutputStream ("save.ser"));
                oos.writeObject(prs);
            }
            catch (IOException ex){
                System.out.println(ex);
            }
            try{
                if(oos!=null)oos.close();
            }
            catch (IOException ex){}
        }
    }
    class Load implements ActionListener  {
        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e ){
            ObjectInputStream ios = null;
            try{
                ios = new ObjectInputStream (new FileInputStream ("save.ser"));
                prs= (ArrayList<Student>)ios.readObject();
            }
            catch (Exception ex){
                tf[0].setText("Error");
            }
            try{
                if(ios!=null)ios.close();
            }
            catch (IOException ex){}
            lst. removeAll();
            for(int i=0;i<prs.size();i++){
                lst.add(""+prs.get(i));
            }
        }
    }
}