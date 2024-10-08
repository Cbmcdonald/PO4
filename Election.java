import java.util.NoSuchElementException;
public class Election {
 private Candidate[] candidates;
 private int numCandidates;
 public final String SEAT_NAME;
  public Election(String seatName,int maxCandidates) {
   if(maxCandidates <= 0) {
     throw new IllegalArgumentException("Max Candidates need to be greater then zero");
   }
   this.candidates = new Candidate[maxCandidates];
  
   if(seatName == null || seatName.trim().isEmpty()) {
     throw new IllegalArgumentException("give is a seat name");
   }
   this.SEAT_NAME = seatName;
   this.numCandidates = 0;
 }
  public int getNumCandidates() {
   return this.numCandidates;
 }
 public int capacity() {
   int capictyOfElection = candidates.length;
   return capictyOfElection;
 
 }
 public void addCandidate(Candidate candidate) {
   for(int i = 0; i < candidates.length; ++i) {
     if(candidates[i].equals(candidate)) {
       throw new IllegalArgumentException("Candidate is already added");
     }
   }
  
   candidates[this.numCandidates] = candidate;
   this.numCandidates += 1;
 }
 
 public void removeCandidate(Candidate candidate) {
  int x = 0;
  boolean foundCandidate = false;
 
  if(this.numCandidates == 0) {
    throw new IllegalStateException("Empty list");
  }
   for(int i = 0; i < this.numCandidates; ++i) {
    if(this.candidates[i].equals(candidate)){
      foundCandidate = true;
      x = i;
      break;
    }
  }
   if(foundCandidate == false) {
    throw new NoSuchElementException("Candidate doesnt exist");
  }
 
  for(int i = x; i < this.numCandidates - 1; ++i) {
    this.candidates[i] = this.candidates[i + 1];
  }
 
   this.candidates[numCandidates - 1] = null;
  this.numCandidates -= 1;
 
 }
  
 public Candidate findWinner() {
   int maxVotes = 0;
   int totalVotes = 0;
   int locationOfWinner = 0;
  
   if(this.numCandidates == 0) {
     throw new IllegalStateException("Empty list");
   }
  
  
   for(int i = 0; i < this.numCandidates; i++) {
     totalVotes += candidates[i].getNumVotes();
     if(candidates[i].getNumVotes() > maxVotes) {
       maxVotes = candidates[i].getNumVotes();
       locationOfWinner = i;
     }
   }
  
   double percentageOfCandidate = ((double) maxVotes / totalVotes) * 100.0;
  
   if(Math.abs(percentageOfCandidate - 50) < 0.01 || percentageOfCandidate < 50.0) {
     throw new NoSuchElementException("contingent");
   }else {
     return candidates[locationOfWinner];
   }
 }
 public void vote(Candidate candidate) {
   boolean found = false;
  
   for(int i = 0; i < this.numCandidates; i++) {
     if(this.candidates[i].equals(candidate)){
       this.candidates[i].addVote();
       found = true;
     }
   }
  
   if(found == false) {
     throw new NoSuchElementException("Candidate not present in list");
   }
  
 }
  public String toString() {
   String finalAnswer = this.SEAT_NAME + "\n";
    for(int i = 0; i < this.numCandidates; i++) {
      if(i == this.numCandidates - 1) {
        finalAnswer += candidates[i].toString();
      }else {
        finalAnswer += candidates[i].toString() + "\n";
      }
    }
    return finalAnswer;
 }
 public boolean equals(Object anObject) {
   if(anObject instanceof Election) {
     Election otherElection = (Election) anObject;
     return this.SEAT_NAME.equalsIgnoreCase(otherElection.SEAT_NAME);
   }
   return false;
 }
}
