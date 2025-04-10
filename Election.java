// Name: Aadarsha Shrestha 
// Class to manage election process

import java.io.*;
import java.util.*;

public class Election {
    private LinkedList<Vote> voteList;

    // Make empty vote list
    public Election() {
        voteList = new LinkedList<>();
    }

    // Load votes from file
    public Election(String filename) {
        this();
        readVotes(filename);
    }

    // Read file and add votes
    private void readVotes(String filename) {
        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNextInt()) {
                int id = file.nextInt();
                int value = file.nextInt();
                Vote v = new Vote(id, value == 1);
                voteList.add(v);
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + filename);
        }
    }

    // Add more votes
    public void addVotes(String filename) {
        readVotes(filename);
    }

    // Remove votes with IDs in file
    public void removeVotes(String filename) {
        try {
            Scanner file = new Scanner(new File(filename));
            ArrayList<Integer> badIDs = new ArrayList<>();
            while (file.hasNextInt()) {
                badIDs.add(file.nextInt());
            }
            file.close();

            // Remove votes matching the IDs
            voteList.removeMatching(v -> {
                Vote vote = (Vote) v;
                return badIDs.contains(vote.getVoterID());
            });

        } catch (Exception e) {
            System.out.println("Error removing votes from file: " + filename);
        }
    }

    // Remove duplicate votes (same voter ID)
    public void removeDuplicates() {
        ArrayList<Integer> seen = new ArrayList<>();
        voteList.removeMatching(v -> {
            Vote vote = (Vote) v;
            if (seen.contains(vote.getVoterID())) {
                return true;
            } else {
                seen.add(vote.getVoterID());
                return false;
            }
        });
    }

    // Count yes and no and say result
    public String didVotePass() {
        int yes = 0;
        int no = 0;
        voteList.forEach(v -> {
            Vote vote = (Vote) v;
            if (vote.getTheVote()) yes++;
            else no++;
        });

        String result = (yes > no) ? "Vote PASSED" : "Vote FAILED";
        return "Yes votes: " + yes + "\nNo votes: " + no + "\nResult: " + result;
    }

    // Print all votes
    public String toString() {
        StringBuilder sb = new StringBuilder();
        voteList.toList().forEach(v -> sb.append(v.toString()).append("\n"));
        return sb.toString();
    }
}
