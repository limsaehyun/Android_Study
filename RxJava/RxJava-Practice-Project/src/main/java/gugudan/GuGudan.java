package gugudan;

import java.util.Scanner;

public class GuGudan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input : ");
        int dan = Integer.parseInt(in.nextLine());
        for(int i = 1; i <= 9; i++) {
            System.out.println(dan + " x " + i + " = " + dan*i);
        }
    }
}
