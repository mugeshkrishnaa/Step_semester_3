abstract class Question {
    double points;

    Question(double points) {
        this.points = points;
    }

    abstract double grade();
    abstract String getType();
}

class MCQ extends Question {
    String correct, answer;

    MCQ(String c, String a, double p) {
        super(p);
        correct = c;
        answer = a;
    }

    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TF extends MCQ {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    String keywords, answer;

    Essay(String k, String a, double p) {
        super(p);
        keywords = k;
        answer = a.toLowerCase();
    }

    double grade() {
        String[] words = keywords.toLowerCase().split(",");
        int count = 0;

        for (String word : words) {
            if (answer.contains(word.trim())) {
                count++;
            }
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Question[] questions = {
            new MCQ("Paris", "Paris", 10),
            new TF("False", "True", 5),
            new Essay("Inheritance, Polymorphism, Encapsulation",
                      "Polymorphism is one.", 20),
            new Essay("Abstraction, Composition",
                      "I talked about abstraction.", 15)
        };

        double total = 0;

        for (Question q : questions) {
            double score = q.grade();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
