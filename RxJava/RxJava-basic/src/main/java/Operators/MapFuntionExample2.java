package Operators;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;


public class MapFuntionExample2 {
    public static void main(String[] args) {
        Function<String, Integer> ballToIndex = ball -> {
            switch(ball) {
                case "RED": return 1;
                case "YELLOW": return 2;
                case "GREEN": return 3;
                case "BLUE": return 5;
                default: return -1;
            }
        };

        String[] balls = {"RED", "YELLOW", "GREEN", "GREEN", "BLUE"};
        Observable<Integer> source = Observable.fromArray(balls)
                .map(ballToIndex);
        source.subscribe(data -> System.out.println("main | value = " + data));
    }
}
