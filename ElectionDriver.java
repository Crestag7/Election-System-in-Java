public class ElectionDriver {
    public static void main(String[] args) {
        Election policy101 = new Election();
        policy101.addVotes("mainvotes.txt");
        System.out.println(policy101.didVotePass());
    }
}