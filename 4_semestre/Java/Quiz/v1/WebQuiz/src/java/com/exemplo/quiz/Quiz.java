package com.exemplo.quiz;

import java.util.*;

public class Quiz {

    private static double lastGrade = 0.0;
    private static double gradeSum = 0.0;
    private static int testCount = 0;

    private static ArrayList<Question> test;
    List<Question> teste = new ArrayList();

    public List<Question> getTeste() {
        return teste;
    }

    public void setTeste(List<Question> teste) {
        this.teste = teste;
    }

    public static double getGradeAverage() {
        return gradeSum / (double) testCount;
    }

    public static double validateTest(String[] answers) {
        int corrects = 0;
        for (int i = 0; i <= test.size() - 5; i++) {
            Question q = test.get(i);
            if (q.getAnswer().equals(answers[i])) {
                corrects++;
            }
        }
        double grade = 100.0 * (double) corrects / (double) (test.size() - 5);
        testCount++;
        gradeSum += grade;
        lastGrade = grade;

        return grade;
    }

    public static ArrayList<Question> getTest() {
        if (test == null) {
            test = new ArrayList<>();
            int n1, n2;
            String[] alternativa;
            for (int i = 1; i <= 10; i++) {
                n1 = (int) (Math.random() * 100);
                n2 = (int) (Math.random() * 100);

                alternativa = new String[4];
                alternativa[0] = String.valueOf(n1 + n2);
                alternativa[1] = String.valueOf(n1 + ((int) (Math.random() * 100)));
                alternativa[2] = String.valueOf((int) (Math.random() * 100) + ((int) (Math.random() * 100)));
                alternativa[3] = String.valueOf(((int) (Math.random() * 100)) + n2);
                Collections.shuffle(Arrays.asList(alternativa));

                Question q = new Question(String.valueOf(n1) + "+" + String.valueOf(n2) + "?",
                        String.valueOf((n1 + n2)),
                        alternativa
                );
                test.add(q);
            }

        }

        return test;
    }

    public static double getLastGrade() {
        return lastGrade;
    }

    public static void setLastGrade(double lastGrade) {
        Quiz.lastGrade = lastGrade;
    }

    public static double getGradeSum() {
        return gradeSum;
    }

    public static void setGradeSum(double gradeSum) {
        Quiz.gradeSum = gradeSum;
    }

    public static int getTestCount() {
        return testCount;
    }

    public static void setTestCount(int testCount) {
        Quiz.testCount = testCount;
    }
}
