## Activity Life Cycle
* 사용자가 앱을 탐색하고, 앱에서 나가고, 앱으로 다시 돌아가는 등의 활동을 하면 앱의 **Activity** 인스턴스는 수명 주기 안에서 서로 다른 상태를 통해 전환된다.
* **Activity 클래스**는 활동이 상태 변화(시스템이 활동을 생성, 중단, 또는, 다시 시작하거나, 활동이 있는 프로세스를 종료하는 등)을 알아차릴 수 있는 여러 콜벡을 제공한다.

* 사용자가 활동을 벗어났다가, 다시 돌아왔을 때 활동이 작동하는 방식을 수명 주기 콜백 메서드에서 선언할 수 있다.
	* 예) 스트리밍 동영상 플레이어를 빌드하는 경우, 사용자가 다른 앱으로 전환할 때 동영상을 일시중지하고 네트워크를 연결을 종료할 수 있다. 사용자가 돌아오면 네트워크를 다시 연결하고, 사용자가 일시중지한 지점에서 동영상을 다시 시작하도록 허용해야한다. 즉, 각각의 콜백은 상태 변화에 적합한 특정 작업을 실행할 수 있어야 한다. 적시에 알맞은 작업을 하고 적절하게 전환을 처리하면 앱이 더욱 안정적으로 기능할 수 있다. -> 따라서 수명 주기 콜백을 잘 구현하면 앱에서 다음과 같은 문제가 발생하지 않도록 예방하는 데 도움이 될 수 있다.
		* 사용자가 앱을 사용하는 도중에 전화가 걸려오거나 다른 앱으로 전환할 때 비정상 종료되는 문제
		* 사용자가 앱을 활발하게 사용하지 않는 경우 시스템 리로스가 소비되는 문제
		* 사용자가 앱에서 나갔다가 나중에 돌아왔을 때 사용자의 진행 상태가 저장되지 않는 문제
		* 화면이 가로 방향과 세로 방햔 간에 회전할 경우, 비정상 종료되거나 사용자의 진행 상태가 저장되지 않는 문제

## Life Cycle 개념
* activity 생명 주기는 6가지 콜백으로 구성된 핵심 집합의 onCreate(), onStart(), onResume(), onPause(), onStop(), onDestory()를 제공한다. 활동이 새로운 상태에 들어가면 시스템은 각 콜백을 호출한다.

![Untitled](https://user-images.githubusercontent.com/80076029/135637611-32feb57d-5702-4a60-b2dd-7c7522e20442.png)

![image](https://user-images.githubusercontent.com/80076029/135637668-e746be86-e1fc-415a-ad12-f9418e7f2636.png)
