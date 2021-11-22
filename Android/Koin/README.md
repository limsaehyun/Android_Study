# Koin



- Kotlin DSL로 만들어졌다.
- Koin은 Dagger에 비해 구성요소가 복잡하지 않아서 러닝 커브다 낮다.
- Koin은 리플렉션을 이용해 런타임에 의존성을 주입을 하다보니 앱 성능이 저하된다 → 큰 규모의 프로젝트에서는 Dagger-Hilt가 적합하다.
  - 리플렉션 : 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드, 타입, 변수들을 접근할 수 있도록 해주는 자바 API



## 개발 환경 설정



Koin 라이브러리를 사용하기 위해서는 아레 build.gradle에 아레 implementation을 추가해주어야 한다.

```xml
implementation "io.insert-koin:koin-android:$koin_version"
```



