package Subject;

import io.reactivex.rxjava3.subjects.AsyncSubject;

public class AsyncSubjectOnCompleteExample {
    public static void main(String[] args) {
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.subscribe(data -> System.out.println("Subscriber #3 => " + data));
    }
}
