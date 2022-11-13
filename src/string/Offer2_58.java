package string;

class Offer2_58Solution {
    public static String reverseLeftWords(String src, int range) {
        // Initialize
        StringBuilder reverse = new StringBuilder();
        // Append The rest of the string
        for(int i = range; i < src.length(); i++)
            reverse.append(src.charAt(i));
        // Append the string that need to be reversed
        for(int i = 0; i < range; i++)
            reverse.append(src.charAt(i));
        return reverse.toString();
    }
}

public class Offer2_58 {
    public static void main(String[] args) {
        String src = "abcdefg";
        int range = 2;
        String fnl = Offer2_58Solution.reverseLeftWords(src,range);
        System.out.println(fnl);
    }

}
