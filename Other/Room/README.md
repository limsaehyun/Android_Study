# Room

Room이 포함된 안드로이드 아키텍처(Android Architecture Components)는 앱을 견고하고, 실험 가능하고, 유지보수성이 뛰어나고록 만들어주는 라이브러리이다. Room은 이 중에 하나이다.

### What is Room?

Room은 SQLite의 추상 레이어를 제공ㅎ여  SQLite의 객체를 매핑하는 역할을 한다. 쉽게 말하면 SQLite의 기능을 모두 사용할 수 있고, DB로의 접근을 편하게 도와주는 라이브러리 이다.

### Why Room?

- Room을 사용하면 컴파일 시간을 체크할 수 있으며, 무의미한 boilerplate 코드의 반복을 줄여줄 수 있다.
- Room이 AAC에 포함되는 만큼, AAC의 다른 구성 요소인 LiveData나 ViewModel 등과 함께 사용하면 아주 간편하게 데이터베이스를 관리하고 UI를 개신할 수 개선할 수 있다.

### Room의 구성요소

1. Entitiy

- Database안에 있는 테이블을 Java나 Kotlin 클래스로 나타낸 것이다. 데이터 모델 클라스라고 볼 수 있다.

1. DAO (DataBase Access Object) - 데이터베이스에 접근해서 실질적으로 동작을 수행하는 메소드를 포함한다.
2. Database - database holder를 포함하며, 앱에 영구 저장되는 데이터와 기본 연결을 위한 주 엑세스 지점. RoomDatabase를  extend하는 추상 클래스이여야 하며 테이블과 버전을 정의한다.

![Untitled](/Users/limsaehyun/Downloads/Untitled.png)