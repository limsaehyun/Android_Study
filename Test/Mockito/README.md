## Mockito란?

- Mockito는 객체를 Mocking하는데 사용되는 Java 기반의 라이브러리이다. JUnit과 함께 Unit Test를 작성하는데 사용된다. 안드로이드 공싱적으로 Mockito 사용을 권장하고 있다.

### Build하기

Mockito를 사용하기 위해선 아래의 줄을 build.gradle에 추가하여야 한다.

```kotlin
testImplementation 'org.mockito:mockito-inline:2.13.0'
```