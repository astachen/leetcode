package string;

class No0151Solution {
    public static String reverseWords(String s) {
        // 1.Remove all the spaces that are not counted in the string.
        StringBuilder SbSrc = removeSpaces(s);
        // 2.Reverse the whole string.
        reverse(SbSrc, 0, SbSrc.length() - 1);
        // 3.Reverse every word.
        reverseEachWord(SbSrc);
        return SbSrc.toString();
    }

    public static StringBuilder removeSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // Delete the spaces before the valid string.
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // Delete the spaces after the valid string.
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // Delete the spaces that are unnecessary in the valid string.
        StringBuilder SbSrc = new StringBuilder();
        while (left <= right) {
            char single = s.charAt(left);

            if (single != ' ') {
                SbSrc.append(single);
            } else if (SbSrc.charAt(SbSrc.length() - 1) != ' ') {
                SbSrc.append(single);
            }

            ++left;
        }
        return SbSrc;
    }



    public static void reverse(StringBuilder SbSrc, int left, int right) {
        while (left < right) {
            char temp = SbSrc.charAt(left);
            SbSrc.setCharAt(left++, SbSrc.charAt(right));
            SbSrc.setCharAt(right--, temp);
        }
    }


    public static void reverseEachWord(StringBuilder SbSrc) {
        int n = SbSrc.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && SbSrc.charAt(end) != ' ') {
                ++end;
            }

            // Reverse and tighten
            reverse(SbSrc, start, end - 1);
            start = end + 1;
            ++end;
        }
    }


}

public class No0151 {
    public static void main(String[] args) {
        String src = "the sky is blue";
        String fnl = No0151Solution.reverseWords(src);
        System.out.println(fnl);
    }

}
