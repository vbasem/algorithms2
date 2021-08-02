package leetcode;

public class MajorityElement {

  public static void main(String[] args) {
    MajorityElement majorityElement = new MajorityElement();
    System.out.println(
        "majorityElement.findBoyreMooreMajority(new int[]{1,1,3,3,3,2}) = "
            + majorityElement.findBoyreMooreMajority(new int[] {1, 1, 3, 3, 3, 2,1, 1}));
  }

  public int findBoyreMooreMajority(int[] data) {

    int candidate = data[0];
    int candidateCount = 1;

    for (int i = 1; i < data.length; i++) {
      if (candidateCount == 0) {
        candidate = data[i];
        candidateCount++;
      } else {
        if (data[i] == candidate) {
          candidateCount++;
        } else {
          candidateCount--;
        }
      }
    }

    return candidate;
  }
}
