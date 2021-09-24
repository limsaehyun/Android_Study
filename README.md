# Android JetPack

---

## Architecture

- [Data Binding](https://www.notion.so/Data-Binding-c53459f6e24e48fc8e7169711277b8a1)
- Lifecycles
- Navigation
- Paging
- Room
- ViewModel
- WorkManager

## Foundation

- Appcompat
- Android KTX
- Multidex
- Test

## UI/UX

- Animation & Transitions
- Auto, TV & Wear
- Emoji
- Fragment
- Layout
- Palette

## Behavior

- Download Manager
- Media & Playback
- Permissions
- Notifications
- Sharing
- Slices

---

## Jetpack에 대해서

Google Developet 공식 사이트에 의하면 Jetpack을 다음과 같이 정의하고 있다.

> 개발자가 관심 있는 코드에 집중할 수 있도록 권장사항 준수, 상용구 코드 제거, 모든 Android 버전과 기기에서 일관되게 작동하는 코드 작성을 돕는 라이브러리 모읍이다.

쉽게 설명하자면 개발에 자주 쓰이는 여러 라이브러리들과 툴들을 묶어놓은 모음집이다.

## Jetpack의 구성요소



### Architecture

- Data Binding: xml파일에 Data를 연결해서 사용할 수 있게 도와준다
- Lifecycles: 안드로이드 activity 생명주기 관련 유틸리티
- LiveData: 데이터가 변경될때 실시간으로 view에 알려준다
- Navigation: activity, fragment간 이동을 쉽게 도와준다
- Paging: 대량의 데이트를 관리해주는 유틸리티
- Room: Database 보다 쉽게 사용할 수 있게 도와준다
- WorkManager: 백그라운드 작업을 보다 쉽게 도와준다

### Foundation

- AppCompat: 하위 안드로이드 앱에서 최긴버전 sdk를 사용할 수 있도록 도와준다.
- Android KTX: 코틀린 코드를 더욱 간결하게 만들어준다.
- Multidex: dex 관리 관련 유틸리티
- Test: 안드로이드 테스티관련 유틸리티

### Behavior

- Download manager: 큰 파일 다운로드을 service 차원에서 관리를 도와준다.
- Media & Playback: 미디어 파일 재생 관련 유틸리티
- Permissions: 안드로이드 권한 관련 유틸리티
- Notifications: 안드로이드 notification 관련 유틸리티
- Sharing: Actionbar에서 데이터를 보다 쉽게 공유할 수 있도록 도와준다

### UI

- 앱에서의 다양한 애니메이션, 이모지 또는 다양한 플랫폼 (TV, 워치) 과련 유틸리티를 사용할 수 있는 컴포넌트.

- Jetpack의 컴포넌트는 안드로이드 API 플랫폼의 일부가 아니기 떄문에 원하는 컨포넌트들만 androidx.* 패키지에서 선택해서 사용할 수 있습니다.
