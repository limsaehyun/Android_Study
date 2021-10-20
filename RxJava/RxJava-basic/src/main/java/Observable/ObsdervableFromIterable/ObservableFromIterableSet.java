package Observable.ObsdervableFromIterable;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.Set;

public class ObservableFromIterableSet {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("임세현");
        names.add("유현명");
        names.add("이준서");

        Observable<String> source = Observable.fromIterable(names);

        source.subscribe(data -> System.out.println("Result : " + data));

    }
}
