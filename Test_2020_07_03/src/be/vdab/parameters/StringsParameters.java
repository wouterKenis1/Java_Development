package be.vdab.parameters;

public class StringsParameters {
    public static void main(String[] args) {
        String s1 = "Lepel";
        String s2 = "http://www.smartdeveloper.be";
        String s3 = "De mooie zeeman nam anna mee zei oom Ed";

        doTest(s1);
        doTest(s2);
        doTest(s3);

    }

    public static boolean isPalindrome(String string) {
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - (i+1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPhrasePalindrome(String string){
        string = string.replaceAll(" ","");
        return isPalindrome(string);
    }

    public static boolean isUrl(String string){
        return string.startsWith("http://");
    }

    public static int isVowel(String string){
        string = string.toLowerCase();
        int vowelCount = 0;
        for(int i = 0;i < string.length(); i++ ) {
            switch(string.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    vowelCount++;
                default:
                    continue;   //not necessary, but best to include all cases
            }
        }
        return vowelCount;
    }

    public static void doTest(String string){
        System.out.println("Testing: " + string);
        System.out.println(isPalindrome(string));
        System.out.println(isPhrasePalindrome(string));
        System.out.println(isUrl(string));
        System.out.println(isVowel(string));
        System.out.println("Test ended");
    }
}
