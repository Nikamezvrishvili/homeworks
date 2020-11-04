import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;


public class Quiz implements ActionListener {
    String[] questions = {

                    "Grand Central Terminal, Park Avenue, New York is the world's",
                    "Entomology is the science that studies",
                    "Eritrea, which became the 182nd member of the UN in 1993, is in the continent of"
    };
    String[][] options =    {
            {
                    "largest railway station","highest railway station","longest railway station", "None of the above"
            },
            {
                "Behavior of human beings","Insects","The origin and history of technical and scientific terms","The formation of rocks"
            },
            {
                "Asia","Africa","Europe","Australia"
            }
                            };
    char[] answers={
            'A',
            'B',
            'B'
    };
    /**
     * guess
     */
    char guess;
    char answer;
    int index;
    int correct_guess = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 15;

    //Buttons
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer =  new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }

        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(000000));
        frame.setLayout(null);
        frame.setResizable(false);
        textField.setBounds(0,0,650,50);
        frame.add(textField);
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(seconds_left);
        frame.add(time_label);





        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Courier",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Quiz");

        textArea.setBackground(new Color(25,25,25));
        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("Courier",Font.BOLD,20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setText("Quiz");

        buttonA.setBounds(0,100,50,50);
        buttonA.setFont(new Font("Courier",Font.BOLD,20));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        answer_labelA.setBounds(125,100,500,50);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("Courier",Font.BOLD,20));


        buttonB.setBounds(0,200,50,50);
        buttonB.setFont(new Font("Courier",Font.BOLD,20));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        answer_labelB.setBounds(125,200,500,50);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("Courier",Font.BOLD,20));




        buttonC.setBounds(0,300,50,50);
        buttonC.setFont(new Font("Courier",Font.BOLD,20));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        answer_labelC.setBounds(125,300,500,50);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("Courier",Font.BOLD,20));


        buttonD.setBounds(0,400,50,50);
        buttonD.setFont(new Font("Courier",Font.BOLD,20));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelD.setBounds(125,400,500,50);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("Courier",Font.BOLD,20));


        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Courier",Font.BOLD,50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("Courier",Font.PLAIN,15));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Time");

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Courier",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Courier",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        nextQuestion();



    }
    public void nextQuestion(){
        if (index>=total_questions){
            results();
        }
        else {
            textField.setText("Question " + (index+1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer= 'A';
            if(answer == answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonB){
            answer= 'B';
            if(answer == answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonC){
            answer= 'C';
            if(answer == answers[index]){
                correct_guess++;
            }
        }
        if(e.getSource()==buttonD){
            answer= 'D';
            if(answer == answers[index]){
                correct_guess++;
            }
        }
        displayAnswer();

    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if(answers[index]!='A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index]!='B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index]!='C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index]!='D')
            answer_labelD.setForeground(new Color(255,0,0));

        Timer pause =  new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));
                answer = ' ';
                seconds = 15 ;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();


            }
        });
        pause.start();
        pause.setRepeats(false);

    }

    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        result=(int)((correct_guess/(double)total_questions)*100);

        textField.setText("Results: ");
        textArea.setText("");
        answer_labelA.setText(" ");
        answer_labelB.setText(" ");
        answer_labelC.setText(" ");
        answer_labelD.setText(" ");

        number_right.setText("("+correct_guess+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(percentage);
        frame.add(number_right);



    }
}
