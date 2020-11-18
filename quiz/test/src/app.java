
import java.io.FileOutputStream;

import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class app {


    public static void main(String[] args) {
        String q1="What color are apples?\n"+"(a)red/green\n(b)orange\n(c)black\n";
        String q2="What color are bananas?\n"+"(a)red/green\n(b)yellow\n(c)blue\n";
        String filename = "test.bin";
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(q1);

            os.writeObject(q2);



        } catch (IOException e) {
            e.printStackTrace();
        }


        Question[] questions = {
                new Question(q1,"a"),
                new Question(q2,"b")
        };
        try {
            takeTest(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void takeTest(Question[]questions) throws IOException {
        int score = 0;

        Scanner keyboardInput = new Scanner(System.in);
        int i =0;
        while (i < questions.length) {
            System.out.println(questions[i].prompt);
            String answer = keyboardInput.nextLine();
            if(answer.equals(questions[i].answer)){
                score++;
            }

            i++;
        }
        System.out.println("You got " + score + "/" + questions.length);
        System.out.println("Done Writing");





   }

}
