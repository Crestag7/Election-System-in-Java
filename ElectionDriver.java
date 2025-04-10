// Aadarsha Shrestha
// Driver to run the election process and display result

public class ElectionDriver {
    public static void main(String[] args) {
        // Primary program tasks
        Election policy101 = new Election("mainvotes.txt");   // Initial set of votes
        policy101.addVotes("absentee.txt");                   // Add absentee votes
        policy101.removeVotes("badvotes.txt");                // Remove invalid votes
        policy101.removeDuplicates();                         // Remove duplicate votes

        // Print all valid votes
        System.out.println("---- All Valid Votes ----");
        System.out.println(policy101.toString());

        // Print result outcome
        System.out.println("---- Election Result ----");
        System.out.println(policy101.didVotePass());
    }
}
