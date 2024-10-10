//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Candidate object constructor and manager
// Course:   CS 300 Fall 2024
// Author:   Cade McDonald
// Email:    Cbmcdonald2@wisc.edu
// Lecturer: Blerina Gkotse
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:    Nicholas Melnyk
// Partner Email:   nmelnyk@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         TA during drop in hours on 10-9-2024, helped debug code
// Online Sources:  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
//					General coding suggestions especially for comparing objects and such.
//
///////////////////////////////////////////////////////////////////////////////
/**
 * An instantiable class representing a candidate in an election. For use in the
 * Exceptional Election project in CS300
 */
public class Candidate {
	private String name;
	private String party;
	private int numVotes;

	/**
	 * Creates a new Candidate object with the given name and party. This candidate
	 * has received 0 votes.
	 * 
	 * @param name  - the candidate's name, cannot be null or blank
	 * @param party - the candidate's party, cannot be null or blank
	 */
	public Candidate(String name, String party) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Candidate name is missing/blank");
		}
		this.name = name;

		if (party == null || party.trim().isEmpty()) {
			throw new IllegalArgumentException("Candidate party is missing/blank");
		}
		this.party = party;
		this.numVotes = 0;
	}

	/**
	 * Accessor for the candidate's current number of votes
	 * 
	 * @return - the number of votes this candidate has received
	 */
	public int getNumVotes() {
		return this.numVotes;
	}

	/**
	 * Adds one (1) vote to this candidate's total
	 */
	public void addVote() {
		this.numVotes += 1;
	}

	/**
	 * Creates and returns a String representation of this candidate in the form
	 * "name (party): numVotes". For example, Wooper from the Water party who
	 * received 5 votes would produce "Wooper (Water): 5"
	 * 
	 * @return - a String representation of the candidate as described in this
	 *         comment, which does NOT end with a newline
	 */
	@Override
	public String toString() {
		String name = this.name;
		String party = this.party;
		int numVotes = this.numVotes;
		String toString = name + " (" + party + "): " + numVotes;
		return toString;
	}

	/**
	 * Determines whether this candidate and anObject are copies (deep or shallow)
	 * of each other. If anObject is not a Candidate object at all, they are not
	 * equal. If it IS a Candidate, then they are equal if and only if this
	 * candidate and anObject have exactly the same name, party, and number of
	 * votes.
	 * 
	 * @param anObject - the object to compare this Candidate against
	 * @return - true if the given object represents a Candidate equivalent to this
	 *         candidate, false otherwise.
	 */
	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Candidate) {
			Candidate otherCandidate = (Candidate) anObject;
			return this.name.equals(otherCandidate.name) && this.party.equals(otherCandidate.party)
					&& this.numVotes == otherCandidate.numVotes;
		}
		return false;
	}
}
