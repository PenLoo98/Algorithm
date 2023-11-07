package lecture.week10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KoreanKeyboardTextArea extends JFrame {
    private JPanel panel;
    //    private JTextField tField;
    private JTextArea tField;
    private JButton[] buttons;

    public KoreanKeyboardTextArea() {
        setTitle("한글 줄바꿈 키보드");
        setSize(600, 1000);

//        tField = new JTextField(35);
        tField = new JTextArea(10,10);
        tField.setText("");
        tField.setEnabled(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,13, 3, 3));


        String[] buttonLabels = {
                "ㅂ", "ㅈ", "ㄷ", "ㄱ", "ㅅ", "ㅛ", "ㅕ", "ㅑ", "ㅐ", "ㅔ", "7", "8", "9",
                "ㅁ", "ㄴ", "ㅇ", "ㄹ", "ㅎ", "ㅗ", "ㅓ", "ㅏ", "ㅣ", ";", "4", "5", "6",
                "ㅋ", "ㅌ", "ㅊ", "ㅍ", "ㅠ", "ㅜ", "ㅡ", ",", "Enter", "0", "1", "2", "3",
        };
        buttons = new JButton[buttonLabels.length];
        int index = 0;

        for(int rows=0; rows<3 ; rows++){
            for(int cols=0; cols<13; cols++){
                buttons[index] = new JButton(buttonLabels[index]);
                if(cols >= 10){
                    buttons[index].setForeground(Color.red);
                }
                else if(cols == 9 && rows == 2){
                    buttons[index].setForeground(Color.red);
                }
                else{
                    buttons[index].setForeground(Color.blue);
                }
                buttons[index].setOpaque(true);
                buttons[index].setBorderPainted(false);
                buttons[index].setBackground(Color.yellow);// 배경색 설정
                if(buttonLabels[index].equals("Enter")){
                    buttons[index].addActionListener(e -> {
                        tField.setText(tField.getText() + "\n");
                    });
                }
                else{
                    buttons[index].addActionListener(new TypeListener());
                }

                panel.add(buttons[index]);
                index++;
            }
        }

        add(tField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    class TypeListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String actionCommand = e.getActionCommand();
            tField.setText(tField.getText() + actionCommand);
        }
    }


    public static void main(String[] args) {
        KoreanKeyboardTextArea k = new KoreanKeyboardTextArea();
    }
}
