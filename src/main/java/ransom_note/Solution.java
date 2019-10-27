package main.java.ransom_note;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazine_dict = new Hashtable();
        for (String foo : magazine) {
            int n = 0;
            if (magazine_dict.get(foo) != null) {
                n = (int) magazine_dict.get(foo);
            }
            magazine_dict.put(foo, n+1);
        }

        Map<String, Integer> note_dict = new Hashtable();
        for (String foo : note) {
            int n = 0;
            if (note_dict.get(foo) != null) {
                n = (int) note_dict.get(foo);
            }
            note_dict.put(foo, n+1);
        }

        for (String key : note_dict.keySet()) {
            int a = (int) note_dict.get(key);
            int b = 0;
            if (magazine_dict.containsKey(key)) {
                b = (int) magazine_dict.get(key);
            }
            if (a > b) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
