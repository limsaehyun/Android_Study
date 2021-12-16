package Observable.ObsdervableFromIterable;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ObservableFromIterableList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("임세현");
        names.add("유현명");
        names.add("이준서");

        Observable<String> source = Observable.fromIterable(names);

        source.subscribe(data -> System.out.println("Result : " + data));

    }
}
