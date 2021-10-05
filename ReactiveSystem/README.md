## Reactive Manifesto (리엑티브 시스템)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ffc34b25-f3b6-44bd-a5f0-9ea3c8da6a12/Untitled.png)

**Response(응답성)**

- 가능한 한 즉각적으로 응답하는 것을 뜻한다.
- 사용자의 입장에서 가장 중요한 항목으로, 소프트웨어는 당연히 사용자가 필요로 할 때 빠르게 응답해야 한다.
- 응답성은 Reactive Manifesto의 4가지 속성 중 가장 중요하고 나머지 아래 3가지 요소는 응답성 위해 존자하는 하위 요소이다.

**Resilient(탄력성)**

- 시스템에 장애에 직면하더라도 응답성을 유지하는 것을 뜻한다.

- Fault Tolerence(장애 허용)과 밀접한 개념이다.

  Fault Tolerence

  - 부분적인 장애나 고장이 시스템 전체를 망가뜨리지 않는다.
  - 시스템 고장을 예외가 아닌 시스템 기능의 일부로 받아들인다.

**Elastic (유연성)**

- 시스템의 작업량이 변하더라도 응답성을 유지하는 것을 뜻한다.
- 리액티브 시스템은 트래픽에 따라 Scale UP과 Scale Down이 쉬워야 합니다.
  - 리액티브 선언의 초기 버전에는 Scalable이라는 말을 썻지만 이것은 Scale Up에 해당하는 용어이기 때문에 Scale Up과 Scale Down을 동시에 표현하는 Elastic이라는 용어로 교체되었습니다.

**Message Driven (메시지 구동)**

- 소프트웨어 내부에서 의사소통을 하는 방식이 메시지를 전달하는 방식으로 구성되어 있다. 소프트웨어를 구성하는 각 부분들은 비동기적으로 메시지를 주고 받는다. 메시지를 주고 받을 때는 보내고 잊는 fire-and-forget 방식을 이용한다.