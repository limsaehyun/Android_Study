### MVVM (Model View ViewModel) 패턴

- 모델(Model)-뷰(View)-뷰모델(ViewModel) 방식
- 안드로이드의 데이터 바인딩을 사용해서, 테스트와 모듈화가 쉽고, 뷰와 모델을 연결하기 위한 연결 코드를 줄일 수 있다.

![image-20210923082809314](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20210923082809314.png)

**<MVVM Components>**

**모델**

- MVC와 동일
- DB, Network, SharedPreference 등 다양한 데이터 소스로부터 필요한 데이터를 준비

**뷰**

- Activity나 Fragment 같은 화면에 표현되는 레이아웃을 정의
- 기본적으로 데이터를 보여주기만 해야 해서 비즈니스 로직을 포함하지 않지만 UI 변경과 관련된 일부 로직은 포함될 수 있다.
- ViewModel을 관찰하다가 상태 변화가 전달되면 화면을 갱신해야 함

**뷰모델**

- View와 Model사이의 매개체 역할을 함
- 모든 View와 관련된 비즈니스 로직은 이 곳에 들어가게 되며 데이터를 잘 가공해서 View에서 뿌리기 쉬운 Model로 바꾸는 역할
- View와 ViewModel은 MVP와는 다르게 1:n의 관계를 가질 수 있으며 여러 개의 Fragment가 하나의 ViewModel을 가질 수 있음
- View가 데이터 바인딩을 할 수 있는 속성과 명령으로 구성되어 있음

**<장점 및 단점>**

**장점**

- Model과 View 사이, ViewModel과 View 사이의 의존성이 없음으로 유닛 테스트가 더 쉬워지며 MVP 패턴에서처럼 테스트를 위한 가상 뷰를 만들 필요가 없어 테스트할 때 모델이 변경되는 시점에 옵저버블 변수가 제대로 설정됐는지 확인하면 됨
- Databinding 라이브러리를 이용함으로써 서로 간의 의존성을 낮추고, 유닛 테스트를 더욱 쉽게 작성할 수 있고 UI 코드는 네이티브 코드에 관여하지 않아도 된다
- 중복되는 코드를 모듈화 할 수 있다.

**단점**

- View가 변수와 표현식 모두에 binding될 수 있으므로 시간이 지남에 따라 관게없는 Presentation Logic이 늘어나고 이를 보환하기 위해 XML에 코드를 추가한다. 이때 난해하게 코드가 증가된다면 유지보수가 어려워질 수 있다.