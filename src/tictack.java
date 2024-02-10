import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class myframe extends JFrame implements ActionListener{
     JPanel panel1,panel2;

     JButton breset,bexit;

     JButton[] b = new JButton[9] ;

     JLabel l1,l2,head,turn,r1,r2;

     Container c ;

     Random random = new Random();
     boolean player1_turn;

     int countX =0;
     int countO =0;



     myframe() {
         c = getContentPane();
         c.setLayout(null);
         c.setVisible(true);

         panel1 = new JPanel();
         panel1.setBounds(0, 0, 1000, 50);
         panel1.setBackground(Color.black);
         c.add(panel1, BorderLayout.NORTH);

         panel2 = new JPanel();
         panel2.setBounds(50, 100, 400, 400);
         panel2.setLayout(new GridLayout(3, 3));
         panel2.setBackground(Color.white);
         c.add(panel2);

         breset = new JButton("Reset");
         breset.setBounds(500, 370, 100, 50);
         breset.setBackground(Color.black);
         breset.setForeground(Color.WHITE);
         Font font1 = new Font("Arial", Font.PLAIN, 30);
         c.add(breset);

         bexit = new JButton("Exit");
         bexit.setBounds(700, 370, 100, 50);
         bexit.setBackground(Color.black);
         bexit.setForeground(Color.WHITE);
         c.add(bexit);

         l1 = new JLabel("Player X");
         l1.setBounds(500, 150, 100, 50);
         Font font2 = new Font("Arial", Font.PLAIN, 20);
         l1.setFont(font2);
         l1.setForeground(Color.BLACK);
         c.add(l1);

         l2 = new JLabel("Player O");
         l2.setBounds(500, 250, 100, 50);
         l2.setFont(font2);
         l2.setForeground(Color.BLACK);
         c.add(l2);

         r1 = new JLabel("0");
         r1.setBounds(700, 150, 100, 50);
         r1.setFont(font2);
         r1.setForeground(Color.BLACK);
         c.add(r1);

         r2 = new JLabel("0");
         r2.setBounds(700, 250, 100, 50);
         r2.setFont(font2);
         r2.setForeground(Color.BLACK);
         c.add(r2);


         head = new JLabel("Tic Tac Toe");
         head.setBackground(Color.WHITE);
         head.setForeground(Color.RED);
         head.setHorizontalAlignment(JLabel.CENTER);
         Font font3 = new Font("Arial", Font.BOLD, 30);
         head.setFont(font3);
         panel1.add(head);

         turn = new JLabel();
         turn.setBackground(Color.BLACK);
         turn.setForeground(Color.BLACK);
         turn.setFont(font3);
         turn.setBounds(200, 550, 150, 30);
         c.add(turn);


         for (int i = 0; i < 9; i++) {
             b[i] = new JButton();
             panel2.add(b[i]);
             b[i].setBackground(Color.black);

             b[i].setFont(new Font("MV Boli", Font.BOLD, 100));
             b[i].setFocusable(false);
             b[i].addActionListener(this);

         }


         bexit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JFrame exitframe = new JFrame("EXIT");
                 if (JOptionPane.showConfirmDialog(exitframe, "Do you want to exit", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                     System.exit(0);
                 }
             }
         });

         breset.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 for (int i = 0; i < 9; i++) {
                     b[i].setEnabled(true);
                     b[i].setText("");
                     b[i].setBackground(Color.black);
                 }



             }
         });

         firstTurn();
     }

         @Override
         public void actionPerformed (ActionEvent e){
             for (int i = 0; i < 9; i++) {
                 if (e.getSource() == b[i]) {
                     if (player1_turn) {
                         if (b[i].getText() == "") {
                             b[i].setForeground(Color.red);
                             b[i].setText("X");
                             player1_turn = false;
                             turn.setText("O turns");
                             check();
                         }
                     } else {
                         if (b[i].getText() == "") {
                             b[i].setForeground(Color.blue);
                             b[i].setText("O");
                             player1_turn = true;
                             turn.setText("X turns");
                             check();
                         }
                     }
                 }
             }
         }


    public void firstTurn()  {


        if(random.nextInt(2)==0){
                player1_turn=true;
                turn.setText("X turn");

            }
            else{
                player1_turn=false;
                turn.setText("O turns");
            }
    }

    public void check(){
        //for x win conditins
        if((b[0]).getText()=="X" &&
                (b[1]).getText()=="X" &&
                (b[3]).getText()=="X"){
            xWins(0,1,2);

        }
        if((b[3]).getText()=="X" &&
                (b[4]).getText()=="X" &&
                (b[5]).getText()=="X"){
            xWins(3,4,5);

        }
        if((b[6]).getText()=="X" &&
                (b[7]).getText()=="X" &&
                (b[8]).getText()=="X"){
            xWins(6,7,8);

        }
        if((b[0]).getText()=="X" &&
                (b[3]).getText()=="X" &&
                (b[6]).getText()=="X"){
            xWins(0,3,6);

        }
        if((b[1]).getText()=="X" &&
                (b[4]).getText()=="X" &&
                (b[7]).getText()=="X"){
            xWins(1,4,7);

        }
        if((b[2]).getText()=="X" &&
                (b[5]).getText()=="X" &&
                (b[8]).getText()=="X"){
            xWins(2,5,8);

        }
        if((b[0]).getText()=="X" &&
                (b[4]).getText()=="X" &&
                (b[8]).getText()=="X"){
            xWins(0,4,8);

        }
        if((b[2]).getText()=="X" &&
                (b[4]).getText()=="X" &&
                (b[6]).getText()=="X"){
            xWins(2,4,6);

        }

        //for O win conditins
        if((b[0]).getText()=="O" &&
                (b[1]).getText()=="O" &&
                (b[2]).getText()=="O"){
            oWins(0,1,2);

        }
        if((b[3]).getText()=="O" &&
                (b[4]).getText()=="O" &&
                (b[5]).getText()=="O"){
            oWins(3,4,5);

        }
        if((b[6]).getText()=="O" &&
                (b[7]).getText()=="O" &&
                (b[8]).getText()=="O"){
            oWins(6,7,8);

        }
        if((b[0]).getText()=="O" &&
                (b[3]).getText()=="O" &&
                (b[6]).getText()=="O"){
            oWins(0,3,6);

        }
        if((b[1]).getText()=="O" &&
                (b[4]).getText()=="O" &&
                (b[7]).getText()=="O"){
            oWins(1,4,7);

        }
        if((b[2]).getText()=="O" &&
                (b[5]).getText()=="O" &&
                (b[8]).getText()=="O"){
            oWins(2,5,8);

        }
        if((b[0]).getText()=="O" &&
                (b[4]).getText()=="O" &&
                (b[8]).getText()=="O"){
            oWins(0,4,8);

        }
        if((b[2]).getText()=="O" &&
                (b[4]).getText()=="O" &&
                (b[6]).getText()=="O"){
            oWins(2,4,6);

        }
    }

    public void xWins(int a,int b, int c){
         r1.setText(String.valueOf(++countX));
         this.b[a].setBackground(Color.GREEN);
        this.b[b].setBackground(Color.GREEN);
        this.b[c].setBackground(Color.GREEN);
        for (int i=0; i<9;i++)
        {
            this.b[i].setEnabled(false);
            if(this.b[i].getText()==""){
                this.b[i].setText("");
            }
        }



    }
    public void oWins(int a,int b,int c){
        r2.setText(String.valueOf(++countO));
        this.b[a].setBackground(Color.GREEN);
        this.b[b].setBackground(Color.GREEN);
        this.b[c].setBackground(Color.GREEN);
        for (int i=0; i<9;i++)
        {
            this.b[i].setEnabled(false);
            if(this.b[i].getText()==""){
                this.b[i].setText("");
            }
        }

    }

}





public class tictack {
    public static void main(String[] args) {
        myframe frame = new myframe();
        frame.setTitle("Tic Tac Toe");
        frame.setBounds(500,250,1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
}
