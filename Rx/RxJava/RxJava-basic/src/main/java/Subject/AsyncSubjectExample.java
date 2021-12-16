package Subject;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectExample {
    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("5");
        subject.onComplete();
    }
}
