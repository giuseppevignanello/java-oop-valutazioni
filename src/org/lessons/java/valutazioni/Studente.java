package org.lessons.java.valutazioni;

public class Studente {
	
	public int id; 
	public int percentageOfAbsences;
	public double avgVote;
	
	int maxAbsencesRejectedRange = 50;
	int minAbsencesRejectedRange = 25; 
	int minAvgVote = 2;
	
	
	public Studente(int id, int percentageOfAbsences, double avgVote) {
		this.id = id; 
		this.percentageOfAbsences = percentageOfAbsences;
		this.avgVote = avgVote;
	}
	
	public boolean isRejected() {
		if( (avgVote < minAvgVote) || 
			(percentageOfAbsences > maxAbsencesRejectedRange) || 
			((percentageOfAbsences > minAbsencesRejectedRange) && (avgVote <= minAvgVote))) {
			return true;
		} else {
			return false;
		}
		
	}
}
