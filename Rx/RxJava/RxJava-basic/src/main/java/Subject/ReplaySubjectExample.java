package Subject;

import io.reactivex.rxjava3.subjects.ReplaySubject;

public class ReplaySubjectExample {
    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(System.out::println);;
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(System.out::println);
        subject.onNext("5");
        subject.onComplete();
    }
}
