package model;


 class Question {
 private String prompt;
 private int marks;

 public Question(String prompt, int marks) {
     this.prompt = prompt;
     this.marks = marks;
 }

 public String getPrompt() {
     return prompt;
 }

 public int getMarks() {
     return marks;
 }

 
 public void display() {
     System.out.println(prompt);
 }
}

//enumeration

enum MultipleChoiceOptions {
    Id("Option A"),
    Name("Option B"),
    Age("Option C"),
    Email("Option D");

    private final String label;

    MultipleChoiceOptions(String label) {
        this.label = label;
    }
}

//abstraction
//inheritance

 abstract class MultipleChoiceQuestion extends Question {
 private String[] choices;
 private int correctChoice;

 public MultipleChoiceQuestion(String prompt, int marks, String[] choices, int correctChoice) {
     super(prompt, marks);
     this.choices = choices;
     this.correctChoice = correctChoice;
 }

 
 public void display() {
     super.display();
     for (int i = 0; i < choices.length; i++) {
         System.out.println((i + 1) + ". " + choices[i]);
     }
 }
}


class TrueFalseQuestion extends Question {
 private boolean correctAnswer;

 public TrueFalseQuestion(String prompt, int marks, boolean correctAnswer) {
     super(prompt, marks);
     this.correctAnswer = correctAnswer;
 }

 
 public void display() {
     super.display();
     System.out.println("True or False?");
 }
}


public class User {
 public static void main(String[] args) {
////     Question mcqQuestion = new MultipleChoiceQuestion ("What is the capital of France?", 2,
//             new String[]{"London", "Paris", "Berlin", "Madrid"}, 2);

     Question trueFalseQuestion = new TrueFalseQuestion("Is the Earth flat?", 1, false);

     
//     mcqQuestion.display();
     trueFalseQuestion.display();
 }
}




