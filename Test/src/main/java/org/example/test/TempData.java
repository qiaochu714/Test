package org.example.test;

import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
public class TempData {
    public static void main(String[] args) {
        getValue("aabcccbbad");
    }
    public static String[] getValue(String ignoredArg){
        String outPut[] = new String[2];
        System.out.println("------" + ignoredArg +" : first");
        removeConsecutiveCharsLevelOne(ignoredArg);
        System.out.println("------" + ignoredArg +" : second");
        removeConsecutiveCharsLevelTwo(ignoredArg);
        return outPut;
    }
    public static void removeConsecutiveCharsLevelOne(String s) {
        boolean flg = true;
        while (flg) {
            if(s.length() <= 1){
                break;
            }
            flg = false;
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }
                if (j - i < 3) {
                    result.append(s, i, j);
                } else {
                    flg = true;
                }
                i = j;
            }
            s = result.toString();
            System.out.println(s);
        }
    }

    public static void removeConsecutiveCharsLevelTwo(String s) {
        boolean flg = true;
        while (flg) {
            if(s.length() <= 1){
                break;
            }
            flg = false;
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int count = 1;
                while (i + count < s.length() && s.charAt(i + count) == s.charAt(i)) {
                    count++;
                }
                if (count < 3) {
                    for (int j = 0; j < count; j++) {
                        result.append(s.charAt(i));
                    }
                } else {
                    flg = true;
                    char temp = (char) (s.charAt(i) - 1);
                    if(s.charAt(i)=='a'){
                        temp = '\0';
                    }
                    result.append(temp);
                }
                i += count;
            }
            s = result.toString().trim();
            System.out.println(s);
        }
    }
}
