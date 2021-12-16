package gugudan;

import io.reactivex.rxjava3.core.Observable;

import java.util.Scanner;

public class RxGuGudan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input : ");
        int dan = Integer.parseInt(in.nextLine());

        Observable<Integer> source = Observable.range(1, 9);
        source.subscribe(row -> System.out.println(dan + " x " + row +  " = " + dan*row));
    }
}
