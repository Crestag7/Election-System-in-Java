public class Vote {
    private int voterID;
    private boolean theVote;

    public Vote() {
        voterID = 0;
        theVote = false;
    }

    public Vote(int id, boolean vote) {
        voterID = id;
        theVote = vote;
    }

    public int getVoterID() {
        return voterID;
    }

    public boolean getTheVote() {
        return theVote;
    }
}