package problem_solving.baekjoon.string;

import java.io.*;

public class BOJ_6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null && !input.trim().isEmpty()) {
            String source = input.split(" ")[0];
            String target = input.split(" ")[1];

            if (isSubString(source, target)) {
                answer.append("Yes").append("\n");
            } else {
                answer.append("No").append("\n");
            }
        }

        System.out.println(answer);
    }

    private static boolean isSubString(String source, String target) {
        int i = 0;
        int j = 0;

        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == source.length();
    }
}
