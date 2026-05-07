import java.util.Scanner;

/**
 * Console-based quiz application.
 * Contains multiple questions, options, and a scoring system.
 * it also includes a high score tracker and replay functionality.
 * the quiz covers basic Java programming concepts.
 */
public class JavaQuizgame {

    // Static variable to track highest score
    static int highScore = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n================================");
            System.out.println("         JAVA QUIZ GAME");
            System.out.println("================================");
            System.out.println("1. Start Quiz");
            System.out.println("2. View Rules");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                startQuiz(sc);
            }
            else if (choice == 2) {
                showRules();
            }
            else if (choice == 3) {
                System.out.println("Thank you for playing!");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    // Method to display rules
    public static void showRules() {

        System.out.println("\n------ QUIZ RULES ------");
        System.out.println("1. Total 10 Questions");
        System.out.println("2. Each correct answer = 1 mark");
        System.out.println("3. No negative marking");
        System.out.println("4. Enter option A/B/C/D");
        System.out.println("------------------------");
    }

    // Method to start quiz
    public static void startQuiz(Scanner sc) {

        int score = 0;

        // Updated Questions
        String questions[] = {
                "Which datatype is used to store whole numbers in Java?",
                "Which operator is used for addition in Java?",
                "Which keyword is used to define a class?",
                "Which method is used to print output in Java?",
                "Which loop is best when number of iterations is known?",
                "Which keyword is used to stop a loop?",
                "Which symbol is used for single-line comments?",
                "Which function is used to take input from user?",
                "Java source file has which extension?",
                "Which access modifier makes members accessible everywhere?"
        };

        // Updated Options
        String options[][] = {
                {"A. int","B. float","C. char","D. boolean"},
                {"A. *","B. -","C. +","D. /"},
                {"A. define","B. class","C. new","D. object"},
                {"A. print()","B. System.out.println()","C. input()","D. display()"},
                {"A. while","B. do-while","C. if","D. for"},
                {"A. continue","B. stop","C. break","D. exit"},
                {"A. //","B. /*","C. #","D. <!--"},
                {"A. Scanner","B. Input","C. Reader","D. Console"},
                {"A. .class","B. .java","C. .txt","D. .exe"},
                {"A. private","B. protected","C. default","D. public"}
        };

        // Correct Answers
        char answers[] = {'A','C','B','B','D','C','A','A','B','D'};

        // Quiz loop
        for(int i = 0; i < questions.length; i++) {

            System.out.println("\n--------------------------------");
            System.out.println("Question " + (i+1) + " of " + questions.length);
            System.out.println(questions[i]);

            for(int j = 0; j < 4; j++) {
                System.out.println(options[i][j]);
            }

            System.out.print("Enter your answer: ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            if(userAnswer == answers[i]) {
                System.out.println("Correct Answer!");
                score++;
            }
            else {
                System.out.println("Wrong Answer!");
                System.out.println("Correct Answer: " + answers[i]);
            }
        }

        // Result Section
        int percentage = (score * 100) / questions.length;

        System.out.println("\n================================");
        System.out.println("          QUIZ RESULT");
        System.out.println("================================");

        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Score: " + score + "/" + questions.length);
        System.out.println("Percentage: " + percentage + "%");

        if(percentage >= 80)
            System.out.println("Result: Excellent!");
        else if(percentage >= 50)
            System.out.println("Result: Good Job!");
        else
            System.out.println("Result: Needs Improvement.");

        // High Score
        if(score > highScore) {
            highScore = score;
        }

        System.out.println("High Score: " + highScore);

        // Replay Option
        System.out.println("\nDo you want to play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int retry = sc.nextInt();

        if(retry == 1) {
            startQuiz(sc);
        }
    }
}
