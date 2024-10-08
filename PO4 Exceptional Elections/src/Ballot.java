//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Ballot object constructor and manager
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
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Ballot {
	private static boolean ballotsCreated = false;
	private static ArrayList<Election> elections = new ArrayList<>();
	private boolean[] hasVoted;

	/**
	 * Initializes a new ballot which corresponds to the current number of elections
	 * present in the elections ArrayList. When a Ballot is successfully created,
	 * this constructor sets the class ballotsCreated variable to true.
	 *
	 * @throws IllegalStateException - if you attempt to create a Ballot when there
	 *                               are no elections to vote in yet
	 */
	public Ballot() {
		if (elections.size() == 0) {
			throw new IllegalStateException("No elections to vote in");
		}

		ballotsCreated = true;
		hasVoted = new boolean[elections.size()];
	}

	/**
	 * Adds an election to the end of the elections ArrayList, as long as this
	 * election (or one equal to it) is not yet present.
	 *
	 * @param election - the election to add to the list of elections
	 * @throws IllegalStateException    - if any ballots have been created, at which
	 *                                  point no more elections may be added to the
	 *                                  list
	 * @throws IllegalArgumentException - if the election is already present in the
	 *                                  list
	 */
	public static void addElection(Election election) {
		if (elections.size() == 0) {
			elections.add(election);
			return;
		}
		for (int i = 0; i < elections.size(); i++) {
			if (elections.get(i) == null) {
				continue;
			} else if (elections.get(i).equals(election)) {
				throw new IllegalArgumentException("Election already present");
			}
		}
		if (ballotsCreated == true) {
			throw new IllegalStateException("Cannot alter ballots, one or more have already been made");
		}
		elections.add(election);
	}

	/**
	 * Adds 1 vote to the provided Candidate running in the election for the given
	 * seatName, if this Ballot has not yet voted in that election. Marks the
	 * election as having been voted in if the vote is successful.
	 *
	 * @param seatName  - the name of the seat for the election to vote in
	 * @param candidate - the Candidate to vote for
	 * @throws IllegalStateException  - if this ballot has already voted in the
	 *                                given election
	 * @throws NoSuchElementException - if the given seat name does not correspond
	 *                                to an election on this ballot, or if the given
	 *                                candidate is not running in that election
	 */
	public void vote(String seatName, Candidate candidate) {
		boolean found = false;
		for (int i = 0; i < elections.size(); i++) {
			if (elections.get(i) == null) {
				continue;
			}
			if (elections.get(i).SEAT_NAME.equalsIgnoreCase(seatName)) {
				if (hasVoted[i] == true) {
					throw new IllegalStateException("Ballot has already voted");
				}
				found = true;
				elections.get(i).vote(candidate); // May be a source of a NoSuchElementException
				hasVoted[i] = true;
			}
		}
		if (found != true) {
			throw new NoSuchElementException("No such Election");
		}
	}

	/**
	 * Checks whether this ballot has already voted in an election corresponding to
	 * the given seatName
	 *
	 * @param seatName - the name of the seat for the election to vote in
	 * @return - true if this ballot has already cast a vote for the specified
	 *         election, false otherwise
	 * @throws NoSuchElementException - if the given seat name does not correspond
	 *                                to an election on this ballot
	 */
	public boolean hasVoted(String seatName) {
		boolean found = false;
		for (int i = 0; i < elections.size(); i++) {
			if (elections.get(i).SEAT_NAME == null) {
				continue;
			} else if (elections.get(i).SEAT_NAME.equals(seatName)) {
				found = true;
				if (hasVoted[i] == true) {
					return true;
				} else {
					return false;
				}
			}
		}
		if (found != true) {
			throw new NoSuchElementException("No such election for " + seatName);
		}
		return found;
	}

	/**
	 * Creates and returns a String representation of this ballot's voter state as
	 * follows: in order, lists the seatName of the election from the elections
	 * ArrayList and whether this Ballot has yet cast a vote in that election.
	 *
	 * @return - a string representation of this ballot as described in this
	 *         comment, which does NOT end with a newline
	 */
	@Override
	public String toString() {
		String finalAnswer = "";
		for (int i = 0; i < elections.size(); i++) {
			if (i == elections.size() - 1) {
				finalAnswer += elections.get(i).SEAT_NAME + ": " + hasVoted[i];
			} else {
				finalAnswer += elections.get(i).SEAT_NAME + ": " + hasVoted[i] + "\n";
			}
		}
		return finalAnswer;
	}

	public static void clearElections() {

		elections.clear();

		ballotsCreated = false;
	}
}
