## JUnit이란?

- 보이지 않고 숨겨진 단위 테스트를 끌어내어 **정형화**시켜 단위 테스트를 쉽게 해주는 테스트용 Framework

### 특징

- 로컬 단위 테스트(**Unit Test**) 중 하나
- 문자 혹은 GUI 기반으로 실행됨
- 단정문으로 테스트 케이스의 수행 결과를 판별함
- 어노테이션으로 간결하게 지원함
- 결과는 성공(녹색), 실패(붉은색) 중 하나로 표시

## 단정문

- assertArrayEuals(a, b) - 배열 a와 b가 일치함을 확인
- assertEquals(a, b) - 객체 a와 b의 값이 같은지 확인
- assertSame(a, b) - 객체 a와 b가 같은 객체임을 확인
- assertTrue(a) - a가 참인지 확인
- assertNotNull(a) - a객체가 nnull이 아님을 확인

- 이 외의 단정문은 [이 곳](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)에서 확인해주세요.

## 어노테이션

**테스트 메소드 지정하기**

@Test가 메소드 위에 선언되면 이 메소드는 테스트 대상 메소드임을 의미한다.

```kotlin
@Test
public void testSum() {
}
```

**테스트 메소드 수행시간 제한하기**

시간단위는 밀리 초이며, 이를 넘긴다면 테스트는 실패합니다.

```kotlin
@Test(timeout = 5000)
public void testSum() {
}
```

**테스트 메소드 Exception 지정하기**

지정한 Exception이 발생하면 테스트 성공

```kotlin
@Test (expected=RuntimeException.class)
public void testSum() {
}
```

**초기화 및 해제**

@BeforeClass, @AfterClass - 해당 테스트 클래스에서 한 번씩만 수행되도록 지정하는 어노테이션

```kotlin
@BeforeClass
public static void setUpBefore() throws Exceptuon {
}

@AfterClass
public static void tearDownAfterClass() throws Exception {
}
```

@Before @After -  테스트 되기 전과 후에 각각 실행되게 지정하는 어노테이션

```kotlin
@Before 
  public void setUp() throws Exception { 
} 

@After 
public void tearDown() throws Exception { 
} 
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/22ba9d7d-6cf1-42ea-a683-b446a462279c/Untitled.png)
