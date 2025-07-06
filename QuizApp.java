import java.util.*;

class Question {
    String question, optionA, optionB, optionC, optionD, correctAnswer;

    public Question(String question, String a, String b, String c, String d, String correct) {
        this.question = question;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctAnswer = correct.toUpperCase(); // Accept A, B, C, D
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer.toUpperCase());
    }

    public void display() {
        System.out.println(question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add questions
        questions.add(new Question("What is the capital of India?", "Delhi", "Mumbai", "Chennai", "Kolkata", "A"));
        questions.add(new Question("Which language is used for Android development?", "Swift", "Kotlin", "Python", "Ruby", "B"));
        questions.add(new Question("Which data structure uses LIFO?", "Queue", "Linked List", "Stack", "Tree", "C"));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?", "Tagore", "Dickens", "Wordsworth", "Shakespeare", "D"));

        int score = 0;
        System.out.println("🔹 Welcome to the Java Quiz 🔹\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ":");
            q.display();
            System.out.print("Your answer (A/B/C/D): ");
            String answer = sc.nextLine();

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer is: " + q.correctAnswer + "\n");
            }
        }

        System.out.println("🎉 Quiz Finished! Your score: " + score + " out of " + questions.size());
        sc.close();
    }
}
