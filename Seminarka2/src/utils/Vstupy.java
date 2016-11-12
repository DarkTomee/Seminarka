package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Pomocna trida urcena pro jednoduche nacitani dat z konzole
 * Lze pouzit i napriklad Scanner sc = new Scanner(System.in);
 */
public class Vstupy {

    public static String ctiString(String vyzva) {
        String s;
        System.out.print(vyzva);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s = br.readLine();
        } catch (Exception e) {
            s = "";
            System.err.println("Chyba vstupu");
        }
        return s;
    }

    public static double ctiDouble(String vyzva) {
        double cislo;
        System.out.print(vyzva);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            cislo = Double.parseDouble(s);
        } catch (Exception e) {
            cislo = 0;
            System.err.println("Chyba vstupu");
        }
        return cislo;
    }

    public static char ctiChar(String vyzva) {
        char znak;
        System.out.print(vyzva);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            znak = s.charAt(0);
        } catch (Exception e) {
            znak = ' ';
            System.err.println("Chyba vstupu");
        }
        return znak;
    }

    public static Integer ctiInt(String vyzva) {
        int cislo;
        System.out.print(vyzva);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            cislo = Integer.parseInt(s);
        } catch (Exception e) {
            cislo = 0;
            System.err.println("Chyba vstupu");
        }
        return cislo;
    }
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
