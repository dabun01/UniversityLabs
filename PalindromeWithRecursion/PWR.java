public class Palindrome {
    public static void main(String[] args) {
        System.out.println(checker("noon", 0, "noon".length() - 1));
    }

    public static boolean checker (String word, int start, int end){
        char startCharacter = word.charAt(start);
        char endCharacter = word.charAt(end);

        if(startCharacter != endCharacter){
            return false;
        } else if (start >= end) {
            return true;
        }
        else {
            return checker(word, start + 1, end - 1);
        }

    }
}
