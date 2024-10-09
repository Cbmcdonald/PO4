import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Ballot {
	private static boolean ballotsCreated;
	private static ArrayList<Election> elections;
	private boolean[] hasVoted;
	
	/**
	 * Initializes a new ballot which corresponds to the current number of elections present in the elections ArrayList.
	 * When a Ballot is successfully created, this constructor sets the class ballotsCreated variable to true.
	 * 
	 * @throws IllegalStateException - if you attempt to create a Ballot when there are no elections to vote in yet
	 */
	public Ballot() {
		
	}
	
	/**
	 * Adds an election to the end of the elections ArrayList, as long as this election (or one equal to it) is not yet present.
	 * 
	 * @param election - the election to add to the list of elections
	 * @throws IllegalStateException - if any ballots have been created, at which point no more elections may be added to the list
	 * @throws IllegalArgumentException - if the election is already present in the list
	 */
	static void addElection(Election election) {
		
	}
	
	/**
	 * Adds 1 vote to the provided Candidate running in the election for the given seatName, if this Ballot has not yet voted in that election. 
	 * Marks the election as having been voted in if the vote is successful.
	 * 
	 * @param seatName - the name of the seat for the election to vote in
	 * @param candidate - the Candidate to vote for
	 * @throws IllegalStateException - if this ballot has already voted in the given election
	 * @throws NoSuchElementException - if the given seat name does not correspond to an election on this ballot, 
	 * or if the given candidate is not running in that election
	 */
	public void vote(String seatName, Candidate candidate) {
		
	}
	
	/**
	 * Checks whether this ballot has already voted in an election corresponding to the given seatName
	 * 
	 * @param seatName - the name of the seat for the election to vote in
	 * @return - true if this ballot has already cast a vote for the specified election, false otherwise
	 * @throws NoSuchElementException - if the given seat name does not correspond to an election on this ballot
	 */
	public boolean hasVoted(String seatName) {
		
	}
	/**
	 * Creates and returns a String representation of this ballot's voter state as follows: in order, lists the seatName of the election
	 *  from the elections ArrayList and whether this Ballot has yet cast a vote in that election.
	 *  
	 *  @overrides toString in class Object
	 *  @return - a string representation of this ballot as described in this comment, which does NOT end with a newline
	 */
	public String toString() {
		
	}

}
