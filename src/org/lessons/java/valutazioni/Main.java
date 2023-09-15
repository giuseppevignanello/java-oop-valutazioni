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
		
		Studente[] rejectedStudentsArray = new Studente [rejectedStudents];
		Studente[] promotedStudentsArray = new Studente [promotedStudents];
		
		int rejectedIndex = 0;
		int promotedIndex = 0;
		
		for (int i = 0; i < students.length; i++) {
			if(students[i].isRejected()) {
				rejectedStudentsArray[rejectedIndex] = students[i];
				rejectedIndex ++;
				
			} else {
				promotedStudentsArray[promotedIndex] = students[i];
				promotedIndex ++;
				
			}
		}
		
		System.out.println("There are: " + rejectedStudents + " rejected students");
		System.out.println("Promoted students: ");
		for (int i = 0; i < promotedStudentsArray.length; i++) {
			System.out.println(promotedStudentsArray[i].id);
		}
		System.out.println("Rejected students: ");
		for (int i = 0; i < promotedStudentsArray.length; i++) {
			System.out.println(rejectedStudentsArray[i].id);
		}
	}
}
