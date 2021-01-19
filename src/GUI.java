import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import javafx.geometry.Insets;
import javax.swing.*;

public class GUI {

    public JButton next;
    public JButton back;
    public Label step;
    public JFrame f;
    public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;


    void setTheFrame(){
          b1=new JButton();
          b2=new JButton();
          b3=new JButton();
          b4=new JButton();
          b5=new JButton();
          b6=new JButton();
          b7=new JButton();
          b8=new JButton();
          b9=new JButton();
          f=new JFrame();
          next = new JButton("Next");
          back = new JButton("Back");
         Label empty=new Label("");
          step=new Label("Initial state");

         f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
         f.add(b6);f.add(b7);f.add(b8);f.add(b9);f.add(next);f.add(empty);f.add(back);
         f.add(step);
         back.setEnabled(false);
         next.setBackground(Color.GRAY);
         back.setBackground(Color.GRAY);
         step.setSize(20,20);
         f.setLayout(new GridLayout(5,3));
         f.setSize(550,550);
     }
    void draw(ArrayList<int[][]> array,int cost) {

        setTheFrame();

        int size=array.size();
        final int[] i = {0};

        setText(array,i);
        checkColor();


        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                back.setBackground(Color.GRAY);

                 if(i[0]>0){
                    i[0]--;
                    next.setEnabled(true);
                     if(i[0]==cost) step.setText("Final step :"+i[0]);
                     else step.setText("step :"+i[0]);
                     setText(array,i);

                     if(i[0]==0){
                        back.setEnabled(false);
                        step.setText("Initial state");
                    }
                    checkColor();

                 }
            }
        });
        next.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                if(i[0]<size-1){

                        i[0]++;
                        if (i[0] == cost) step.setText("Final step :" + i[0]);
                        else step.setText("step :" + i[0]);
                        back.setEnabled(true);
                        setText(array, i);

                        checkColor();

                    if(i[0]==size-1) {
                        next.setEnabled(false);
                    }
                }

            }
        });
        f.setVisible(true);

        }
        public void checkColor(){

            if (b1.getText().equals("0")) b1.setBackground(Color.white);
            else b1.setBackground(Color.lightGray);
            if (b2.getText().equals("0")) b2.setBackground(Color.white);
            else b2.setBackground(Color.lightGray);
            if (b3.getText().equals("0")) b3.setBackground(Color.white);
            else b3.setBackground(Color.lightGray);
            if (b4.getText().equals("0")) b4.setBackground(Color.white);
            else b4.setBackground(Color.lightGray);
            if (b5.getText().equals("0")) b5.setBackground(Color.white);
            else b5.setBackground(Color.lightGray);
            if (b6.getText().equals("0")) b6.setBackground(Color.white);
            else b6.setBackground(Color.lightGray);
            if (b7.getText().equals("0")) b7.setBackground(Color.white);
            else b7.setBackground(Color.lightGray);
            if (b8.getText().equals("0")) b8.setBackground(Color.white);
            else b8.setBackground(Color.lightGray);
            if (b9.getText().equals("0")) b9.setBackground(Color.white);
            else b9.setBackground(Color.lightGray);
        }
        public void setText(ArrayList<int[][]> array,int[] i){
            b1.setText(String.valueOf(array.get(i[0])[0][0]));
            b2.setText(String.valueOf(array.get(i[0])[0][1]));
            b3.setText(String.valueOf(array.get(i[0])[0][2]));
            b4.setText(String.valueOf(array.get(i[0])[1][0]));
            b5.setText(String.valueOf(array.get(i[0])[1][1]));
            b6.setText(String.valueOf(array.get(i[0])[1][2]));
            b7.setText(String.valueOf(array.get(i[0])[2][0]));
            b8.setText(String.valueOf(array.get(i[0])[2][1]));
            b9.setText(String.valueOf(array.get(i[0])[2][2]));
        }
    }
