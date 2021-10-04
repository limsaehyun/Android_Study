## 비동기 작업이 필요한 이유는?

* 비동기 작업이 필요한 이유는 더 나은 user experience를 위해서 이다.

* [스레드](https://www.notion.so/Thread-81b7dbbedc0c4892bc57db82930d1c16)를 쾌적하게 유지하기 위해서 무겁고 시간이 오래 걸리는 작업들이나 네트워킹 작업들을 background thread에서 처리하고 main thread로 들고 오는 일이 필수적이다.