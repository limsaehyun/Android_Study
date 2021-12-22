### Hilt 예제

- [HiltExample](https://github.com/limsaehyun/Android_Study/tree/master/DI/Hilt/HiltExample)

### Hilt란?

- Hilt는 애플리케이션에 DI를 삽입하는 표준 방식으로, 프로젝트의 모든 ANdroid 구성요소에 컨테이너를 제공하고 컨테이너의 수명 주기를 자동으로 관리한다. → 이 방식은 DI 라이브러리인 Dagger를 활용한 것

### HIlt 설정

```xml
implementation "com.google.dagger:hilt-android:$hilt_version"
kapt "com.google.dagger:hilt-android-compiler:$hilt_version"

apply plugin: 'kotlin-kapt'
apply plugin: 'dagger.hilt.android.plugin'

classpath 'com.google.dagger:hilt-android-gradle-plugin:2.28-alpha'
```

- Hilt를 사용하기 위해서는 위의 코드를 build.grade에 추가해주어야 합니다.

Hilt를 사용하고자 하는 앱은 @HiltAndroidApp으로 주석이 지정된 Application 클래스를 추가해야 합니다.

Moduled은 @Provides나  @Binds로 생성합니다. @InstallIn을 사용하여 표준 COmponent를 설정해야 합니다.

![Untitled](C:\Users\user\Downloads\Untitled.png)