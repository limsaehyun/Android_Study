import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.functions.Consumer;

public class ObservableCreateExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                }
        );


        // source.subscribe(System.out::println);

        // 라맏 표현
//        source.subscribe(data2 -> System.out.println("Result : " + data2));

        // 익명 객체 표현
        source.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {
                System.out.println("Result : " + integer);
            }
        });
    }
}