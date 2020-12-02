package net.thumbtack.school.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings){//1
        int length = 0;
        for(String str : strings)
            length += str.length();
        return length;
    }

    public static String getFirstAndLastLetterString(String string){//2
        String first = String.valueOf(string.charAt(0));
        String last = String.valueOf(string.charAt(string.length() - 1));
        return first + last;
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index){//3
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character){//4
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character){//5
        return isSameFirstCharPosition(reverse(string1), reverse(string2), character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str){//6
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str){//7
        return isSameFirstStringPosition(reverse(string1), reverse(string2), str);
    }

    public static boolean isEqual(String string1, String string2){//8
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2){//9
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2){//10
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2){//11
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2){//12
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix){//13
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix){//14
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2){//15
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < Math.min(string1.length(), string2.length()); i++){
            if(string1.charAt(i) == string2.charAt(i))
                builder.append(string1.charAt(i));
            else break;
        }
        return builder.toString();
    }

    public static String reverse(String string){//16
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        String str = builder.reverse().toString();
        return str;
    }

    public static boolean isPalindrome(String string){//17
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string){//18
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings){//19
        String str = "";
        for(String interim : strings){
            if(isPalindromeIgnoreCase(interim)){
                if(str.length() < interim.length())
                    str = interim;
            }
        }
        return str;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length){//20
        length += index;
        if((string1.length() < length) || string2.length() < length)
            return false;
        else if(string1.substring(index, length).equals(string2.substring(index, length)))
            return true;
        return false;
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2){//21
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2){//22
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string){//23
        String str = string.replaceAll("\\s+", "");
        return str.equalsIgnoreCase(reverse(str));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2){//24
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array){//25
        if(array.length == 0) return "";
        else {
            StringBuilder builder = new StringBuilder(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++)
                builder.append("," + array[i]);
            return builder.toString();
        }
    }

    public static String makeCsvStringFromDoubles(double[] array){//26
        if(array.length == 0) return "";
        else {
            StringBuilder builder = new StringBuilder(String.format("%.2f", array[0]));
            for (int i = 1; i < array.length; i++)
                builder.append("," + String.format("%.2f", array[i]));
            return builder.toString();
        }
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array){//27
        StringBuilder builder = new StringBuilder();
        if(array.length == 0) {
        }
        else {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++)
                builder.append("," + array[i]);
        }
        return builder;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array){//28
        StringBuilder builder = new StringBuilder();
        if(array.length == 0) {
        }
        else {
            builder.append(String.format("%.2f", array[0]));
            for (int i = 1; i < array.length; i++)
                builder.append("," + String.format("%.2f", array[i]));
        }
        return builder;
    }

    public static StringBuilder removeCharacters(String string, int[] positions){//29
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        for(int i = 0; i < positions.length; i++)
            builder.delete(positions[i] - i, positions[i] - i + 1);
        return builder;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters){//30
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        for(int i = 0; i < characters.length; i++)
            builder.insert(positions[i] + i, characters[i]);
        return builder;
    }
}