## 동기식 처리 (Synchronous)

* 동기식 처리 모델(Synchronous processing model)은 직렬적으로 태스크(task)를 수행한다.

  즉, 태스크는 순차적으로 실행되며 어떤 작업이 수행 중이면 다음 작업은 대기하게 된다.

  ![Untitled](https://user-images.githubusercontent.com/80076029/135789458-0bc57572-b8fa-436b-b120-50ba85253200.png)


* [예시코드](https://github.com/limsaehyun/Rx-and-Reactive-Programming/tree/main/SynchronousAndAsynchronous/AsynchroExample)



## 비동기식 처리 (Asynchronous)

비공기식 처리 모델(Asynchronous processing model & Non-Blocking processing model)은 병렬적으로 태스크(task)를 수행한다.

즉, 태스크가 종료되지 않는 상태라 하더라고 대기하지 않도 다음 태스크를 실행한다.



- 예시로, 서버에 데이터를 요청한 이후 서버로부터 데이터가 응답될 때까지 대기하지 않고(Non-Blocking) 즉시 다음 태스크를 수행한다.


![Untitled](https://user-images.githubusercontent.com/80076029/135789468-62a4d234-d915-4337-92a5-db395d90bfbb.png)

* [예시 코드(Multi Thread)](https://github.com/limsaehyun/Rx-and-Reactive-Programming/tree/main/SynchronousAndAsynchronous/AsynchroExample)
