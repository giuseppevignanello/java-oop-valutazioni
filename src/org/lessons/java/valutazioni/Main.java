package org.lessons.java.valutazioni;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		Studente[] students = new Studente[20]; //Initialize array
		
		int rejectedStudents = 0; //counter
		int promotedStudents = 0; 
		
		for (int i = 0; i < students.length; i++) {
			int id = i +1; 
			int percentageOfAbsences = rnd.nextInt(100);
			double avgVote = rnd.nextDouble(5);
			
			students[i] = new Studente(id, percentageOfAbsences, avgVote);
			System.out.println("id: " + students[i].id + 
								" avgVote: " + String.format("%.2f", students[i].avgVote) +
								" percentageOfAbsences: " + students[i].percentageOfAbsences +
								(students[i].isRejected() ? " Is Rejected" : " Is Promoted"));
			
			//increase the counter 
			if(students[i].isRejected()) {
				rejectedStudents ++;
			} else {
				promotedStudents ++;
			}		
		}
		
		//promoted and rejected students
		Studente[] rejectedStudentsArray = new Studente [rejectedStudents];
		Studente[] promotedStudentsArray = new Studente [promotedStudents];
		
		Studente bestStudent = new Studente(0, 0, 0);
		Studente worstStudent = new Studente(0, 0, 5);
		
		//index
		int rejectedIndex = 0;
		int promotedIndex = 0;
				
		for (int i = 0; i < students.length; i++) {
			if(students[i].isRejected()) {
				
				//check if they are the worst 
				if (students[i].avgVote < worstStudent.avgVote) {
					worstStudent = students[i];
				}
				
				//add to rejected array
				rejectedStudentsArray[rejectedIndex] = students[i];
				rejectedIndex ++;
				
			} else {
				//check if they are the best
				if(students[i].avgVote > bestStudent.avgVote) {
					bestStudent = students[i];
				}
				
				//add to promoted array
				promotedStudentsArray[promotedIndex] = students[i];
				promotedIndex ++;
				
			}
		}
		
		
		
		//output
		System.out.println("--------------------------");
		System.out.println("There are: " + rejectedStudents + " rejected students");
		System.out.println("--------------------------");
		System.out.println("Promoted students: ");
		for (int i = 0; i < promotedStudentsArray.length; i++) {
			System.out.println(promotedStudentsArray[i].id);
		}
		System.out.println("--------------------------");
		System.out.println("Rejected students: ");
		for (int i = 0; i < promotedStudentsArray.length; i++) {
			System.out.println(rejectedStudentsArray[i].id);
		}
		System.out.println("--------------------------");
		System.out.println("The best promoted student is: " + bestStudent.id);
		System.out.println("The worst rejected student is: " + worstStudent.id);
	}
}
