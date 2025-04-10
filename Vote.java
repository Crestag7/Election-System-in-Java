// Aadarsha Shrestha
// Vote class to store one vote info

public class Vote {
    private int voterID;       // ID of the voter
    private boolean theVote;   // true for yes, false for no

    // Default constructor
    public Vote() {
        voterID = 0;
        theVote = false;
    }

    // Constructor with voter info
    public Vote(int id, boolean vote) {
        voterID = id;
        theVote = vote;
    }

    // Set the voter ID
    public void setVoterID(int id) {
        voterID = id;
    }

    // Get the voter ID
    public int getVoterID() {
        return voterID;
    }

    // Set the vote (true/false)
    public void setTheVote(boolean vote) {
        theVote = vote;
    }

    // Get the vote
    public boolean getTheVote() {
        return theVote;
    }

    // Compare with another vote using voter ID
    public boolean equals(Vote other) {
        return this.voterID == other.voterID;
    }

    // Convert vote to a readable string
    public String toString() {
        return voterID + " " + (theVote ? "Yes" : "No");
    }
}
