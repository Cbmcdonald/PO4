//cade
import java.util.NoSuchElementException;
public class Election {
	private Candidate[] candidates;
	private int numCandidates;
	final String SEAT_NAME;
	
	/**
	 * Initializes the oversize array for this election's candidates 
	 * and sets the name of the position for which this election is being held.
	 * 
	 * @param seatName - The name of the position for which this election is being held
	 * @param maxCandidates - Maximum of candidates permitted to run in this election
	 * @throws IllegalArgumentException - if the maximum number of candidates is not strictly greater than 0
	 */
	public Election(String seatName, int maxCandidates) {
		
	}
	
	/**
	 * Accessor method for the current number of candidates in this Election
	 * 
	 * @return - the number of candidates currently running in this election
	 */
	public int getNumCandidates() {
		
	}
	
	/**
	 * Accessor method for the maximum number of candidates in this Election. 
	 * This can be calculated without adding additional instance fields!
	 * 
	 * @return - the maximum number of candidates permitted to run in this election
	 */
	public int capactity() {
		
	}
	
	/**
	 * Adds a candidate to the END of this election's list. Do NOT maintain the candidate 
	 * list in alphabetical order this time.
	 * 
	 * @param candidate - the Candidate to add to this election
	 * @throws - IllegalArgumentException - if this candidate is already present in the candidates list for this election
	 */
	public void addCandidate(Candidate candidate) {
		
	}
	
	/**
	 * Removes the candidate matching the provided candidate exactly from the election's list of candidates
	 * 
	 * @param candidate - the candidate to remove
	 * @throws - IllegalStateException - if you try to remove from an empty candidates list
	 * @throws - NoSuchElementException - if the given Candidate is not present in this election's list of candidates
	 */
	public void removeCandidate(Candidate candidate) {
		
	}
	
	/**
	 * Returns a reference to the Candidate receiving more than 50% of the votes in this election
	 * 
	 * @return - the Candidate with >50% of the votes across this election's candidates
	 * @throws - IllegalStateException - if the candidates list is empty
	 * @throws - NoSuchElementException - if no one candidate has more than 50% of the votes (P01's "contingent" election)
	 */
	public Candidate findWinner() {
		
	}
	
	/**
	 * Increases the vote count of the given candidate by one
	 * 
	 * @param candidate - the candidate to vote for
	 * @throws - NoSuchElementException - if the given candidate is not present in this election
	 */
	public void vote(Candidate candidate) {
		
	}
	
	/**
	 * Creates and returns a String representation of this Election object, with each Candidate's string representation on a separate line. 
	 * The first line of the output String contains the name of the seat this election is for.
	 * 
	 * @Overrides - toString in class Object
	 * @return - the String representation of the current state of this Election, which does NOT end with a newline
	 */
	public String toString() {
		
	}
	
	/**
	 * Determines whether a provided object is equivalent to this Election. If anObject is not an Election at all, they are not equal. If it IS an Election, 
	 * they are equivalent if and only if their seat names match, ignoring capitalization.
	 * 
	 * @Overrides - equals in class Object
	 * @param anObject - the object to compare this Election against
	 * @return - true if the given object represents a Election equivalent to this election, false otherwise.
	 */
	public boolean equals(Object anObject) {
		
	}

}
