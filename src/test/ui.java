package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;




/**
 * Created by Administrator on 2017/4/17 0017.
 */
public class ui {

    public static void ManageView(){

        JFrame jFrame=new JFrame("SwingwithIP");
        //JMenuBar jMenuBar=new JMenuBar();
       // JMenu menu_opening=new JMenu("open excel file");
       // JMenu menu_ping=new JMenu("start ping");

        JButton opening=new JButton("open-ping");


        Object data[][]=null;
        String[] headers={"ip","name","state"};
        DefaultTableModel model=new DefaultTableModel(data,headers){
          public boolean isCellEditable(int row,int column){
              return false;
          }
        };

        JTable jTable=new JTable(model);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane=new JScrollPane(jTable);
        JPanel jPanel=new JPanel();
        jPanel.add(opening);

       // Container container=jFrame.getContentPane();
      //  container.setLayout(new FlowLayout());
      //  jMenuBar.add(menu_opening);
      //  jMenuBar.add(menu_ping);
        jFrame.add(jPanel,BorderLayout.EAST);
        jFrame.add(pane,BorderLayout.WEST);
        jFrame.setSize(600,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);




    }
}
