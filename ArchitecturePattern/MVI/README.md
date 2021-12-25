# MVI



### MVI란?

* MVI는 Model-View-Intent의 형태를 띄우고 있다.



MVI가 의미하는 바는 아레와 같다.

* Model: Model은 상태를 나타낼 수 있다. MVI에서 Model은 데이터의 플로우가 단방향으로 이루어지기 위해 무조건 불변성을 보장해야 한다
* View: View는 Activity나 Fragment를 나타내며 앱의 상태를 전달 받아 화면에 렌더링하는 역할이다.

* Intent: Intent는 앱이나, 사용자가 취하는 행위를 나타내기 위한 의도이다. View는 Intent를 받고, ViewModel은 Intent를 옵저빙하며 Model은 그에 따라 새로운 상태로 변환한다.

![img](https://media.vlpt.us/images/jshme/post/4c180926-e2d1-4bfc-859e-ba97647e6465/image.png)



### Why MVI?

* MVVM에서 Spotify, Airbnb, 그 외에 **상태 문제**와 **부수 효과**와 관련된 문제가 있다.



**상태문제**

* 프로그래밍은 상태 제어와 깊은 연광성이 있다. 화면에 나타나는 모든 View들은 무수한 상태들로 구성되어 있습니다. 이때 상태를 관리하기 힘들어지고 의도하지 않은 방향으로 제어가 되는 것을 **상태 문제**라고 한다.



**부수 효과**

* 안드로이드는 무수한 **부수 효과**들로 이루어져 있다. 서버 호출, 데이터 베이스 접근 등, 우리는 어떤 결과를 얻을지 예상할 수 없으며, 그에 따라 상태 변경에 어려움을 겪는다.

/Users/limsaehyun/Desktop/스크린샷 2021-12-25 오후 9.12.08.png

MVI는 Intent가 User를 관찰하고, Model이 Intent를 관찰하고, View가 Model을 관찰하고, User가 View를 관찰하는 Reactive 요소로 이루어져 있다.

### MVI의 작동 작식  

1. Intent로 User로부터 입력을 가져온다.
2. Intent는 Model에서 처리해야 하는 동작(Intended action)을 제공합니다.
3. Model은 Intent로부터 동작을 가져옵니다
(MVI의 모델은 데이터 뿐만아니라 Application State와 Business Logic을 관리합니다.)
4. Model은 View에 표시할 새로운 모델을 생성합니다.




■ 참고 문헌

https://velog.io/@jshme/MVI-Architecture-for-Android

https://medium.com/@kimdohun0104

