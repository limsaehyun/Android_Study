package gugudan;

import io.reactivex.rxjava3.core.Observable;

import java.util.Scanner;

public class RxGuGudan3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input : ");
        int dan = Integer.parseInt(in.nextLine());

        Observable<String> source = Observable.just(dan)
                .flatMap(num -> Observable.range(1, 9)
                .map(row -> num + " + " + row + " = " + num*row));
        source.subscribe(System.out::println);
    }
}
