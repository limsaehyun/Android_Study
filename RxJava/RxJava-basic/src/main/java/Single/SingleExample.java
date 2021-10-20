package Single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class SingleExample {
    public static void main(String[] args) {

        // 1. 기존 Observable에서 Single 객체로 변환하기기
       Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(System.out::println);

        // 2. single() 함수를 호출해 Single 객체 생성하기
//        Observable.just("Hello Single")
//                .single("default item")
//                .subscribe(System.out::println);

    }
}
