public class Candidate {
 private String name;
 private String party;
 private int numVotes;
  public Candidate(String name, String party) {
   if(name == null || name.trim().isEmpty()) {
     throw new IllegalArgumentException("Candidate name is missing/blank");
   }
   this.name = name;
  
   if(party == null || party.trim().isEmpty()) {
     throw new IllegalArgumentException("Candidate party is missing/blank");
   }
   this.party = party;
   this.numVotes = 0;
  
 }
  public int getNumVotes() {
   return this.numVotes;
  
 }
  public void addVote() {
   this.numVotes += 1;
  
 }
 public String toString() {
   String name = this.name;
   String party = this.party;
   int numVotes = this.numVotes;
   String toString = name + " (" + party + "): " + numVotes;
   return toString;
  
 }
  public boolean equals(Object anObject) {
   if(anObject instanceof Candidate) {
     Candidate otherCandidate = (Candidate) anObject;
     return this.name.equals(otherCandidate.name) && this.party.equals(otherCandidate.party) &&
         this.numVotes == otherCandidate.numVotes;
   }
   return false;
 }
}
