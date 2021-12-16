package Subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectObservableExample {
    public static void main(String[] args) {
        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        // data를 수신할 수 있도록 subscribe() 호출

        source.subscribe(subject);
    }
}
