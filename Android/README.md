# Android



### 비교 표

|                | Dagger2          | Koin             | Hilt         |
| -------------- | ---------------- | ---------------- | ------------ |
| Java           | O                | X                | O            |
| Kotlin         | O                | O                | O            |
| 에러 검출 시점 | Compile Time     | Runtime          | Compile Time |
| 검증           | 많은 앱에서 검증 | 많은 앱에서 검증 | BETA버전     |



### Dagger2

------

- 가장 많이 보이는 DI Framework이다.
- Dagger2 적용을 위해선 환경을 세팅해야 하는 과정과 원활한 적용에 필요한 러닝커브가 크다.
- 러닝커브에 사용되는 비용이 상대적으로 저렴한 (부담이 적은) 사람들이 쓰기에 적합하다.

[Dagger2](https://github.com/limsaehyun/DI-Study/tree/main/Android/Dagger2)



## Koin

------

- Kotlin DSL (Domain Specific Language) 로 만들어졌다.
- Kotlin 개발 환경에 쉽게 적용할 수 있는 경령화된 DI 프레임워크, Kotlin 개발 환경에서 도입하기에 가장 가볍고 빠르게 적용할 방법이다.
- Koin은 리플렉션을 이용해 런타임에 의존성을 주입을 하다보니 앱 성능이 저하된다 → 큰 규모의 프로젝트에서는 Dagger-Hilt가 적합하다.

[Koin](https://github.com/limsaehyun/DI-Study/tree/main/Android/Koin)



## Hilt

------

- Dagger를 기반으로 만들어진 DI Framewor이다.
- 안정성 보장과 개발 환경과의 충돌이 될 수 있다.
- 보수적이고 안정적인 프로젝트에서는 사용이 어렵지만, 개인 프로젝트 단계에서는 써볼만하다.

[Hilt](https://github.com/limsaehyun/DI-Study/tree/main/Android/Hilt)





■ 참고 문헌

------

https://velog.io/@sysout-achieve/Android-DI-Framework-선택지Dagger2-Koin-Hilt