package org.lessons.java.valutazioni;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		Studente[] students = new Studente[20]; //Initialize array
		
		int rejectedStudents = 0; //counter
		
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
			}
			
		}
		
		System.out.println("There are: " + rejectedStudents + " rejected students");
	}
}
