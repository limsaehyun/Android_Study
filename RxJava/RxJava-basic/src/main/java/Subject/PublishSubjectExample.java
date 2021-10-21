package Subject;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class PublishSubjectExample {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(System.out::println);
        subject.onNext("5");
    }
}
