//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tester methods for the election manager project
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
import java.util.NoSuchElementException;

/**
 * A tester class for the Election Manager project. It contains various tests to
 * check the correctness of the Candidate, Election, and Ballot classes.
 *
 */
public class ElectionManagerTester {
	/**
	 * Tests the Candidate constructor, toString(), and getter method for
	 * correctness. This test accounts for the fact that a bad implementation may
	 * throw an Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testCandidateConstructorAndGetters() {
		// in case we get an unexpected exception from a broken implementation
		// we handle it with a try-catch to avoid our tester from crashing
		try {
			// test the 2-argument constructor
			Candidate c = new Candidate("lebron james", "basketball");
			// check that the instance data fields have been initialized correctly
			// using the toString to do this we are also checking its correctness!
			// in a bad implementation either:
			// 1) the constructor didn't intialize a data field correctly OR
			// 2) toString() doesn't return the correct value
			if (!c.toString().equals("lebron james (basketball): 0"))
				return false;

			// let's also verify the one getter method agrees with the toString() output:
			if (c.getNumVotes() != 0)
				return false;
		} catch (Exception e) {
			// we encountered an exception when we should not have, it is a bad
			// implementation!
			e.printStackTrace();
			return false;
		}
		// all tests pass:
		return true;
	}

	/**
	 * Verifies that the Candidate constructor throws the correct type of
	 * exception(s) where an exception is expected. See the Candidate documentation
	 * for details.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testCandidateConstructorExceptions() {

		try {
			Candidate cand1 = new Candidate(null, "Packers");
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			Candidate cand3 = new Candidate(" ", "Packers");
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			Candidate cand2 = new Candidate("Nick", null);
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			Candidate cand3 = new Candidate("Nick", " ");
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Tests the Election constructor and associated getter methods for correctness.
	 * (Note that SEAT_NAME is a publicly-accessible constant and can be verified
	 * directly.) This test accounts for the fact a bad implementation may throw an
	 * Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testElectionConstructorAndGetters() {
		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		Candidate oscar = new Candidate("Oscar", "Trash");

		general.addCandidate(oscar);
		general.addCandidate(elmo);
		general.addCandidate(monster);
		general.vote(elmo);
		general.vote(elmo);
		general.vote(monster);

		if (general.getNumCandidates() != 3) {
			return false;
		}
		if (general.capacity() != 3) {
			return false;
		}

		general.removeCandidate(oscar); // Test the removal function by removing oscar from the presidential race.
		if (general.getNumCandidates() != 2) {
			return false;
		}
		if (general.findWinner() != elmo) {
			return false;
		}
		if (!general.SEAT_NAME.equals("president")) {
			return false;
		}
		return true;
	}

	/**
	 * Verifies that the Election constructor throws the correct type of
	 * exception(s) in situations where an exception is expected. See the Election
	 * documentation for details.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testElectionConstructorExceptions() {
		try {
			Election electionTest = new Election("KingVon", 0);
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		try {
			Election electionTest = new Election("KingVon", -6);
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true; // TODO
	}

	/**
	 * Tests the Election's addCandidate() method for correctness in non-Exception
	 * situations. This test accounts for the fact a bad implementation may throw an
	 * Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testAddCandidate() {

		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		general.addCandidate(monster);
		general.addCandidate(elmo);
		if (general.getNumCandidates() != 2) {
			return false;
		}
		if (general.capacity() != 3) {
			return false;
		}
		try {
			general.addCandidate(elmo);
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Verifies that the Election's addCandidate() method throws the correct type of
	 * exception(s) in situations where an exception is expected. See the Election
	 * documentation for details.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testAddCandidateExceptions() {
		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		try {
			general.addCandidate(elmo);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			return false;
		}
		try {
			general.addCandidate(monster);
			general.addCandidate(monster);
			general.addCandidate(monster);
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Tests the Election's vote() method for correctness in non-Exception
	 * situations. This test accounts for the fact a bad implementation may throw an
	 * Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testVote() {
		boolean testPass = true;
		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		general.addCandidate(monster);
		try {
			general.vote(monster);
		} catch (NoSuchElementException e) {
			testPass = false;
		} catch (Exception e) {
			e.printStackTrace();
			testPass = false;
		}
		try {
			general.vote(monster);
			if (monster.getNumVotes() != 2) {
				testPass = false;
			}
		} catch (NoSuchElementException e) {
			testPass = false;
		} catch (Exception e) {
			e.printStackTrace();
			testPass = false;
		}
		return testPass;
	}

	/**
	 * Verifies that the Election's vote() method throws the correct type of
	 * exception(s) in situations where an exception is expected. See the Election
	 * documentation for details.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testVoteExceptions() {
		////////////////////////////////////////////////////////////////////////////////////////
		// we're doing the setup separately, so we can isolate the actual test later.
		// if anything fails HERE, that's a different problem than the one we're trying
		//////////////////////////////////////////////////////////////////////////////////////// to
		//////////////////////////////////////////////////////////////////////////////////////// test,
		// and the test should fail.
		Election election = null; // declare outside of the try block for scope reasons
		try {
			election = new Election("Sportsball", 10);
			Candidate c1 = new Candidate("lebron james", "basketball");
			Candidate c2 = new Candidate("messi", "soccer");
			election.addCandidate(c1);
			election.addCandidate(c2);
		} catch (Exception e) {
			System.out.println("Unable to continue with this test for unrelated reasons!!");
			e.printStackTrace();
			return false;
		}
		////////////////////////////////////////////////////////////////////////////////////////
		// THIS part is what we are actually testing:
		try {
			election.vote(new Candidate("usain bolt", "athletics"));
			return false; // this line only runs if NO exception is thrown from the previous line
		} catch (NoSuchElementException e) {
			// this is correct
		} catch (Exception e) {
			// this only runs if an exception other than NoSuchElementException was thrown,
			// which is wrong!
			e.printStackTrace();
			return false;
		}
		// all tests pass:
		return true;
	}

	/**
	 * Tests the Election's removeCandidate() method for correctness. This test
	 * accounts for the fact a bad implementation may throw an Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testRemoveCandidate() {
		Election general = new Election("president", 3);

		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		general.addCandidate(monster);
		general.addCandidate(elmo);	
		
		if (general.getNumCandidates() != 2) {
			return false;
		}
		if (general.capacity() != 3) {
			return false;
		}
		try {
			general.removeCandidate(elmo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		if (general.getNumCandidates() != 1) {
			return false;
		}

		if (general.capacity() != 3) {
			return false;
		}

		return true;
	}

	/**
	 * Verifies that the Election's removeCandidate() method throws the correct type
	 * of exception(s) in situations where an exception is expected.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testRemoveCandidateExceptions() {
		Election general = new Election("president", 3);

		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		general.addCandidate(elmo);
		
		Election empty = new Election("Empty", 3);
		
		try {
			empty.removeCandidate(elmo);
			return false;
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			empty.removeCandidate(elmo);
			return false;
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			general.removeCandidate(monster);
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Tests the Ballot two-phase setup process in non-Exception situations. This
	 * test accounts for the fact that a bad implementation may throw an Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testBallotSetup() {
		// Phase 1: add elections to the Ballot class
		// Phase 2: create a Ballot and verify that it has the correct number of
		// elections
		// (hint: use toString())
		Ballot.clearElections();

		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		Candidate oscar = new Candidate("Oscar", "Trash");

		general.addCandidate(monster);
		general.addCandidate(elmo);
		general.addCandidate(oscar);

		Election manager = new Election("TrailerParkManager", 3);
		Candidate ricky = new Candidate("Ricky", "Dope");
		Candidate bubbles = new Candidate("Bubbles", "Kitty");
		Candidate jRock = new Candidate("jRock", "DJ");

		manager.addCandidate(ricky);
		manager.addCandidate(bubbles);
		manager.addCandidate(jRock);

		Ballot.addElection(manager);
		Ballot.addElection(general);

		Ballot bal1 = new Ballot();
		bal1.vote("TrailerParkManager", jRock);

		// System.out.println(bal1.toString());

		if (bal1.hasVoted("TrailerParkManager") != true || bal1.hasVoted("president") != false) {
			return false;
		}

		return true;

	}

	/**
	 * Verifies that the Ballot two-phase setup process throws the correct type of
	 * exception(s) in situations where an exception is expected. See the Ballot
	 * documentation for details.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testBallotSetupExceptions() {
		// try the phases out of order!
		Ballot.clearElections();
		Election general = new Election("president", 3);

		try {
			Ballot ballot = new Ballot();
			return false;
		} catch (IllegalStateException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		Ballot.addElection(general);
		try {
			Ballot.addElection(general);
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Tests the Ballot vote() and hasVoted() methods in non-Exception situations.
	 * This test accounts for the fact that a bad implementation may throw an
	 * Exception.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testBallotVote() {
		Ballot.clearElections();

		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		Candidate oscar = new Candidate("Oscar", "Trash");

		general.addCandidate(monster);
		general.addCandidate(elmo);
		general.addCandidate(oscar);

		Election manager = new Election("TrailerParkManager", 3);
		Candidate ricky = new Candidate("Ricky", "Dope");
		Candidate bubbles = new Candidate("Bubbles", "Kitty");
		Candidate jRock = new Candidate("jRock", "DJ");

		manager.addCandidate(ricky);
		manager.addCandidate(bubbles);
		manager.addCandidate(jRock);

		Ballot.addElection(manager);
		Ballot.addElection(general);

		Ballot bal1 = new Ballot();
		Ballot bal2 = new Ballot();
		bal1.vote("TrailerParkManager", jRock);
		bal1.vote("president", elmo);

		bal2.vote("president", elmo);

		if (bal2.hasVoted("president") != true || bal2.hasVoted("TrailerParkManager") == true) {
			return false;
		}

		if (elmo.getNumVotes() != 2 || jRock.getNumVotes() != 1) {
			return false;
		}

		// System.out.println(bal1.toString());

		if (bal1.hasVoted("TrailerParkManager") != true || bal1.hasVoted("president") != true
				|| bal2.hasVoted("president") != true || bal2.hasVoted("TrailerParkManager") != false) {
			return false;
		}

		return true;

	}

	/**
	 * Verifies that the Ballot vote() and hasVoted() methods throw the correct type
	 * of exception(s) in situations where an exception is expected. See the Ballot
	 * documentation for details.
	 *
	 * @return true if all tests pass, false otherwise
	 */
	public static boolean testBallotVoteExceptions() {
		Ballot.clearElections();

		Election general = new Election("president", 3);
		Candidate monster = new Candidate("Cookie Monster", "Cookie");
		Candidate elmo = new Candidate("Elmo", "Friend");
		Candidate oscar = new Candidate("Oscar", "Trash");
		Candidate bird = new Candidate("Big Bird", "Squawk");

		general.addCandidate(monster);
		general.addCandidate(elmo);
		general.addCandidate(oscar);

		Election manager = new Election("TrailerParkManager", 3);
		Candidate ricky = new Candidate("Ricky", "Dope");
		Candidate bubbles = new Candidate("Bubbles", "Kitty");
		Candidate jRock = new Candidate("jRock", "DJ");

		manager.addCandidate(ricky);
		manager.addCandidate(bubbles);
		manager.addCandidate(jRock);

		Ballot.addElection(manager);
		Ballot.addElection(general);

		Ballot bal1 = new Ballot();
		Ballot bal2 = new Ballot();
		bal1.vote("TrailerParkManager", jRock);
		bal1.vote("president", elmo);

		try {
			bal1.vote("president", oscar);
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			bal2.vote("president", bird);
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			bal2.hasVoted("Prime Minister");
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Runs all testing methods and prints out their results.
	 * 
	 * @return true if and only if all the tests return true, false otherwise
	 */
	public static boolean runAllRequiredTests() {
		boolean test1 = testCandidateConstructorAndGetters();
		System.out.println("testCandidateConstructorAndGetters(): " + (test1 ? "PASS" : "FAIL"));
		boolean test2 = testCandidateConstructorExceptions();
		System.out.println("testCandidateConstructorExceptions(): " + (test2 ? "PASS" : "FAIL"));
		boolean test3 = testElectionConstructorAndGetters();
		System.out.println("testElectionConstructorAndGetters(): " + (test3 ? "PASS" : "FAIL"));
		boolean test4 = testElectionConstructorExceptions();
		System.out.println("testElectionConstructorExceptions(): " + (test4 ? "PASS" : "FAIL"));
		boolean test5 = testAddCandidate();
		System.out.println("testAddCandidate(): " + (test5 ? "PASS" : "FAIL"));
		boolean test6 = testAddCandidateExceptions();
		System.out.println("testAddCandidateExceptions(): " + (test6 ? "PASS" : "FAIL"));
		boolean test7 = testVote();
		System.out.println("testVote(): " + (test7 ? "PASS" : "FAIL"));
		boolean test8 = testVoteExceptions();
		System.out.println("testVoteExceptions(): " + (test8 ? "PASS" : "FAIL"));
		boolean test9 = testRemoveCandidate();
		System.out.println("testRemoveCandidate(): " + (test9 ? "PASS" : "FAIL"));
		boolean test10 = testRemoveCandidateExceptions();
		System.out.println("testRemoveCandidateExceptions(): " + (test10 ? "PASS" : "FAIL"));
		boolean test11 = testBallotSetup();
		System.out.println("testBallotSetup(): " + (test11 ? "PASS" : "FAIL"));
		boolean test12 = testBallotSetupExceptions();
		System.out.println("testBallotSetupExceptions(): " + (test12 ? "PASS" : "FAIL"));
		boolean test13 = testBallotVote();
		System.out.println("testBallotVote(): " + (test13 ? "PASS" : "FAIL"));
		boolean test14 = testBallotVoteExceptions();
		System.out.println("testBallotVoteExceptions(): " + (test14 ? "PASS" : "FAIL"));
		return test1 && test2 && test3 && test4 && test5 && test6 && test7 && test8 && test9 && test10 && test11
				&& test12 && test13 && test14;
	}

	/**
	 * Calls runAllRequiredTests and displays the output. If you add additional
	 * private testers, call them directly in the main method rather than adding
	 * them to the previous method.
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		System.out.println("runAllRequiredTests(): " + runAllRequiredTests());
	}
}
