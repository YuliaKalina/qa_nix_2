package ua.com.alevel;

public class Reverse {
    public static String reverse(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
            reverse.append(str.charAt(i));
        return reverse.toString();

    }

    public static String reverse(String str, boolean reverseAll) {
        StringBuilder result = new StringBuilder();
        if (reverseAll) {
            return reverse(str);
        }

        for (String word : str.split(" ")) {
            result.append(reverse(word)).append(" ");
        }

        return result.toString();
    }

    public static String reverse(String str, String dest) {
        int start = str.indexOf(dest);
        int end = start + dest.length();
        return reverse(str, start, end);
    }

    public static String reverse(String str, int firstIndex, int lastIndex) {
        String firstPart = str.substring(0, firstIndex);
        String secondPart = str.substring(firstIndex, lastIndex);
        String thirdPart = str.substring(lastIndex);

        return firstPart + Reverse.reverse(secondPart) + thirdPart;
    }
}
