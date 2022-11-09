package string;

// A pretty simple question: replace the blank spaces with %20.
public class Offer05 {
    public static String replaceSpace(String src) {
        StringBuilder res = new StringBuilder();
        for(Character c : src.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String src = "We are happy.";
        String fnl = Offer05.replaceSpace(src);
        System.out.println(fnl);
    }
}
