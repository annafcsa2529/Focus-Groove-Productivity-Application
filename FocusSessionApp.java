import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class User {
     String name;
     int totalSessions;

    public User(String name) {
        this.name = name;
        this.totalSessions = 0;
    }

    public void completeSession() {
        totalSessions++;
    }
}

class BaseTimer {
    private int studyTime;
    private int breakTime;
    private boolean isRunning;

    public BaseTimer() {
        studyTime = 15;
        breakTime = 5;
        isRunning = false;
    }

    public void pause() {
        isRunning = false;
    }

    public void reset() {
        isRunning = false;
    }
}

class StudyTimer extends BaseTimer {
        int duration = 15;
        int remainingTime = 15;

    public StudyTimer() {
        duration = 15;
        remainingTime = duration;
    }

    public void reset() {
        remainingTime = duration;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void decrementTime() {
        remainingTime--;
    }
}

class BreakTimer extends BaseTimer {
    int duration = 5;
         int remainingTime = 5;

    public BreakTimer() {
        duration = 5;
        remainingTime = duration;
    }

    public void reset() {
        remainingTime = duration;
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    public void decrementTime() {
        remainingTime--;
    }
}

public class FocusSessionApp extends JFrame implements ActionListener {

    User user = new User("Student");
    StudyTimer studyTimer = new StudyTimer();
    BreakTimer breakTimer = new BreakTimer();

    int unlockedCount = 0;
    String mode = "NONE";

    javax.swing.Timer countdown;

   
    JPanel topPanel, centerPanel;
    JPanel p1, p2;

   
    JLabel l1, l2, l3, l4;
    JTextField t1;
    JButton b1, b2, b3, b4, b5;
    JButton b6, b7, b8, b9;
    JButton b10, b11, b12, b13;
    JButton b14, b15, b16, b17;
    JButton b18, b19, b20, b21;

    public FocusSessionApp() {
        setTitle("Focus Groove");
        setSize(480, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        countdown = new javax.swing.Timer(1000, this);

       
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5, 1, 5, 5));


        p1 = new JPanel();

        l1 = new JLabel("Student Name: ");
        t1 = new JTextField("Student", 12);
        b1 = new JButton("Set Name");
        b1.addActionListener(this);
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);


        l2 = new JLabel("FOCUS GROOVE", JLabel.CENTER);
        l3 = new JLabel("15s", JLabel.CENTER);

        p2 = new JPanel();
        b2 = new JButton("Start Study");
        b3 = new JButton("Pause");
        b4 = new JButton("Reset");
        b5 = new JButton("Start Break");

        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

       
        l4 = new JLabel("Completed Sessions: 0 / 16", JLabel.CENTER);

       
        topPanel.add(p1);
        topPanel.add(l2);
        topPanel.add(l3);
        topPanel.add(p2);
        topPanel.add(l4);

        add(topPanel, BorderLayout.NORTH);

       
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 4, 4));

        b6 = new JButton("?");
        b7 = new JButton("?");
        b8 = new JButton("?");
        b9 = new JButton("?");
        b10 = new JButton("?");
        b11 = new JButton("?");
        b12 = new JButton("?");
        b13 = new JButton("?");
        b14 = new JButton("?");
        b15 = new JButton("?");
        b16 = new JButton("?");
        b17 = new JButton("?");
        b18 = new JButton("?");
        b19 = new JButton("?");
        b20 = new JButton("?");
        b21 = new JButton("?");

        centerPanel.add(b6);
        centerPanel.add(b7);
        centerPanel.add(b8);
        centerPanel.add(b9);
        centerPanel.add(b10);
        centerPanel.add(b11);
        centerPanel.add(b12);
        centerPanel.add(b13);
        centerPanel.add(b14);
        centerPanel.add(b15);
        centerPanel.add(b16);
        centerPanel.add(b17);
        centerPanel.add(b18);
        centerPanel.add(b19);
        centerPanel.add(b20);
        centerPanel.add(b21);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void unlockNextTile() {
        unlockedCount++;

         if (unlockedCount == 1) {
                    b6.setText("⭐");
 }
          else if (unlockedCount == 2) {
             b7.setText("🎯");
          }
 else if (unlockedCount == 3) {
                    b8.setText("🔥");
          }
 else if (unlockedCount == 4) {
             b9.setText("💡");
          }
 else if (unlockedCount == 5) {
                    b10.setText("📚");
          }
 else if (unlockedCount == 6) {
                    b11.setText("🚀");
          }
 else if (unlockedCount == 7) {
                    b12.setText("🧠");
          }
 else if (unlockedCount == 8) {
                   b13.setText("🏆");
          }
 else if (unlockedCount == 9) {
             b14.setText("🎨");
          }
 else if (unlockedCount == 10) {
                    b15.setText("☕");
          }  
          else if (unlockedCount == 11) {
                    b16.setText("💻");
          }
          else if (unlockedCount == 12) {
               b17.setText("✨");
          }
 else if (unlockedCount == 13) {
                    b18.setText("⚡");
          }
 else if (unlockedCount == 14) {
                    b19.setText("🌟");
          }
 else if (unlockedCount == 15) {
               b20.setText("🏅");
          }
 else if (unlockedCount == 16) {
           b21.setText("👑");
          }
    }

    public void actionPerformed(ActionEvent e) {

       
        if (e.getSource() == b1) {
            user.name = t1.getText();
            JOptionPane.showMessageDialog(this, "Name updated to: " + user.name);
        }

       
        else if (e.getSource() == b2) {
            mode = "STUDY";
            countdown.start();
        }

       
        else if (e.getSource() == b3) {
            countdown.stop();
        }

       
        else if (e.getSource() == b4) {
            countdown.stop();
            studyTimer.reset();
            breakTimer.reset();
            mode = "NONE";
            l3.setText("15");
        }

       
        else if (e.getSource() == b5) {
            mode = "BREAK";
            countdown.start();
        }

       
        else if (e.getSource() == countdown) {

            if (mode.equals("STUDY")) {
                studyTimer.decrementTime();
                l3.setText("" + studyTimer.getRemainingTime());

                if (studyTimer.getRemainingTime() <= 0) {
                    countdown.stop();
                    user.completeSession();
                    unlockNextTile();
                    l4.setText("Completed Sessions: " + unlockedCount + " / 16");
                    studyTimer.reset();
                    l3.setText("Done!");
                }
            }
            else if (mode.equals("BREAK")) {
                breakTimer.decrementTime();
                l3.setText("" + breakTimer.getRemainingTime());

                if (breakTimer.getRemainingTime() <= 0) {
                    countdown.stop();
                    breakTimer.reset();
                    l3.setText("Ready!");
                }
            }
        }
    }

    public static void main(String[] args) {
        new FocusSessionApp();
    }
}