## DataBinding

- xml파일에 Data를 연결(binding(해서 사용할 수 있게 도와주며 Android JetPack 라이브러리의 하나의 기능입니다.
- DataBinding은 에플리케이션 로직과 레이아웃을 binding하는 데 필요한 글루 코드를 최소화합니다.

- 글루 코드

  프로그램의 요구사항 구현에는 기여하지 않지만, 본래 호환성이 없는 부분끼리 결합하기 위해 작동하는 코드
<br>

## DataBinding의 사용법

### [STEP 1] DataBinding 세팅하기

```xml
android {
    ...
   dataBinding {    
 	   enabled true
   }
}
```

위 구문을 gradle 파일에 추가합니다.
