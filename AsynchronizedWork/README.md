## 비동기 작업이 필요한 이유는?

* 비동기 작업이 필요한 이유는 더 나은 user experience를 위해서 이다.

* [스레드](https://www.notion.so/Thread-81b7dbbedc0c4892bc57db82930d1c16)를 쾌적하게 유지하기 위해서 무겁고 시간이 오래 걸리는 작업들이나 네트워킹 작업들을 background thread에서 처리하고 main thread로 들고 오는 일이 필수적이다.

## The Evaluation Matrix

비공기 작업을 처리하는 라이브러리가 고려해야 할 4가지 측면들

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ecb9c572-33a1-4f81-b6cd-8966de3340b3/Untitled.png)

**Explicit excution**

- 새로운 스레드에서 작업을 시작한 후 컨트롤 할 수 있어야함

**Easy thread management**

- 한 스레드 다른 스레드로 작업을 넘기거나 스레드를 교체(switch)하는 일이 쉬워야함
  - ex) background에서 그려진 UI로 main thread의 UI를 대체

**Easily Composable**

- 한 스레드의 작업이 다른 스레드의 작업으로부터 독립적이라면 좋겠지만 실제로는 그렇지 않는 경우가 많다. 대부분의 경우에 스레드들은 서로 interdependent하기 때문에 asynchonous library의 경우 easily composable하고 에러가 날 여지가 적어야 함
  - ex) UI 업데이트, DB transaction

**Minimun side effects**

- 한 스레드가 다른 스레드에 미치는 side effect가 최소화되어야 함