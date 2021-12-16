package Observable;

import io.reactivex.rxjava3.core.Observable;

public class ObservableFromArray {
    public static void main(String[] args) {
        Integer[] arr = {100, 200 ,300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(data -> System.out.println("Result : " + data));
    }
}
