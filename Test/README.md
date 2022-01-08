## 테스트 코드를 작성해야 하는 이유

- **기존의 테스트 방식**

  에뮬레이터 혹은 디바이스에서 직접 결과를 확인 → 에러 발생하면 로그 찍어 파악 → 수정 후 테스트 반복

- 기존의 테스트 방식은 규모가 작을 경우에는문제가 없을 수 있지만, 앱의 규모가 커지면 빌드하는 시간 + 테스트 하는 시간은 점점 길어지고 **비효율적인 작업**이 되버린다.

- 테스트 코드는 소스 코드의 특정 묘듈이 **의도된 대로 정확히 작동하는지 검증**과 **신뢰성 높은 코드의 생산성을 높이기** 위해 작성한다.

### 테스트 코드의 장점

- 잘못된 부분을 빠르게 확인할 수 있다. → 안정성, 신뢰성 ↑
- 디버깅 시간을 단축 → 개발 시간 ↓
- 모듈이 의도대로 동작하고 있음을 확인 → 리팩터링 시 부담 ↓
- 좋은 구조로 개발하게끔 도와줌 → 테스트 코드를 작성하다 보면, 테스트 가능한 구조과 되도록 코드의 관심사를 분리하게 된다.

## Android Test

- Android는 기본적으로 Jnit을 기반으로, JVM에서 계측 테스트IInstrumentation Test), 로컬 단위 테스트(Unit Test)를 할 수 있다.
  - JUnit - 자바 프로그래밍 언어용 유닛 테스트 프레임워크

### Unit Test(로컬 단위 테스트)

- module-name/src/test/java/ 하위에 테스트 코드를 작성한다.
- 빠르다.
- JVM에서 실행되는 테스트이다.
- 안드로이드 프레임워크와 종속성이 없거나 모의 객체를 생성할 수 있는 경우 사용한다.
- 관련된 테스트
  - JUnit
  - Mockito
  - PowerMock
  - Truth
  - Robolectric

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d5effb8c-640e-4d49-8b78-6a72a2181e34/Untitled.png)

### Instrumentation Test(계측 테스트)

- module-name/src/androidTest/java/ 하위에 테스트 코드를 작성한다.
- 안드로이드 프레임워크에 종속성이 있는 테스트이다.
- 실제 안드로이드 기기나 에뮬레이터에서 실행되는 테스트이다.
- 관련 테스트
  - Espresso
  - UIAnimator
  - Robotium
  - Appium
  - Calabash

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8b23a0d1-0970-40e4-8180-e3908e03ff1f/Untitled.png)

## 무엇을 테스트해야 하는가

### 테스트 코드 작성 범위

- 수정, 변경되는 모든 기능

  - 코드의 변경으로 인해 영향받는 코드에 대한 테스트 코드 필수. 새로운 기능, 새로운 파일 추가, 기존 파일에 일부 동작이 추가된 경우 등.

- 로직에 대한 검증은 필수

  - 사용자의 요청에 따라 올바른 로직의 수행 결과가 View에 올바르게 반영되는가 검증. 프로세스 간, 모듈 간, 클래스 간의 통용되는 주요 인터페이스에 대한 테스트, MVP 패턴을 적용한다면 Presenter의 로직, MVVM을 적용한다면 ViewModel의 로직 테스트 등.

- View에 대한 테스트, 즉 UI Test는 필수적이지는 않다

  .

  - 안드로이드 프레임워크나 UI 관련 테스트 코드는 작성 및 실행에 있어 어려움이 존재.

- 뷰와 로직이 섞여 있는 경우

  - 테스트 코드를 작성하려면 최대한 관심사를 분리해야 합니다. 모듈 간 결합도가 낮아지도록 하는 DI, 디자인 패턴, 클린 아키텍처 등을 적용해서 테스트가 쉽게 이루어질 수 있도록 코드를 작성할 필요가 있습니다.

- 그럼에도 어쩔 수 없이 섞여 있는 경우

  - View에 어쩔 수 없이 로직이 포함돼 있는 경우 Instrumented Test를 작성하거나 View로부터 로직을 분리하는 리팩터링 후 분리된 로직에 대한 테스트 코드 작성 방법이 추천.

### 테스트 코드 작성 법칙

- Givin - 특정 상황이 주어지고
- When - (테스트하려는) 특정 액션이 발생햇을 때
- Then - 변화 된 상태나 수행되는 행동을 검증

```kotlin
@Test
fun 이메일로그인_실패케이스_잘못된이메일형식입력() {
	// Givin
	잘못 된 이메일을 입력.

	// When
	이메일 로그인 버튼 클릭.

	// Then
	유효성 검증 실패 & 이메일 검증 오류 메시지
}

@Test
fun test_onClickEmailLogin_FailLogin_EnterIncorrectEmail() {
	// Givin
	'when' (view.getInputEmail()).thenReturn("abc.def@day")

	// When
	viewModel.onClickEmailLogin()

	// Then
	verify(view).showMessageForIncorrectEmail()
}
```

### Unit Test가 어려운 안드로이드

- 안드로이드는 Device 의존이 강한 프레임워크라 모든 앱은 안드로이드 OS가 설치된 디바이스 위에서 동작합니다. 그래서 JVM이 실행하는 안드로이드 Unit Test에서 안드로이드 컴포넌트들을 그대로 사용 또는 객체를 만들거나 할 때 문제가 발생합니다.

- 예시 코드

  ```kotlin
  @Test
  fun onCreate() {
  	val testActivity= TestActivity()
  	testActivity.onCreate(null, null)
  }
  ```

  - Unit Test를 수행할 때, 안드로이드 컴포넌트들은 Android SDK 경로에 있는 android.jar이 아닌 android-stubs-src.jar 파일을 참고하기 때문입니다. 해당 파일에 있는 클래스 메서드들은 실제 구현이 없는 빈 껍데기(Stub)이기 때문에 JUnit상에서 정상적인 동작을 하지 못합니다.
  - 그래서 안드로이드 코드와 안드로이드 의존성이 없는 코드를 최대한 분리하는 방법을 적용해야 합니다.
    - Mocking, DI, MVVM, Clean Architecture 등