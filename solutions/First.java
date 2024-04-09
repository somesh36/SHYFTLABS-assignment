package solutions;

public class First {
    public static int findInd(int[] arr) {
        int i = 0;
        while (arr[i] != -1) {
            i++;
        }
        return i;
    }
}