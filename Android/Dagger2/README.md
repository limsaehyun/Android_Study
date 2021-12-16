# Dagger2



```markdown
자바와 Android를 위해 완전히 정적으로 컴파일 타임 의존성 주입 프레임워크
```

- 컴파일 시 어노테이션을 읽고 scope에 맞는 DI container와 주입할 class파일을 generate하여 의존성을 주입한다.
- 컴파일 시간이 늘어나게 되고, 문제가 있을 경우 compile 시점에서 에러를 발생시킨다. → 빌드가 완료된 파일은 어느 정도 의존성 주입에 대해서는 안정성이 보장된다.

## Dagger2의 핵심 개념

### Inject

- 의존성 주입을 요청한다. Inject 어노테이션으로 주입을 요청하면 연결된 Component가 Module로부터 객체를 생성하여 Inject를 요청한 쪽으로 넘겨준다.

### Component

- 연결된 Module을 이용해 객체를 생성하고, Inject로 요청받은 인스턴스에 생성한 객체를 주입한다.

### Module

- Component에 연결되어 의존성 객체를 생성하여 제공한다. 생성 후 Scope에 따라 관리도 한다.

### Scope

- 생서된 객체의 Lifecycle 범위를 뜻한다.

### Subcomponent

- Component는 계층 관계를 만들 수 있다. Subcomponent는 Inner Class 방식의 하위 계층 Component이다.
- Subcomponent는 Dagger의 중요한컨셉인 그래프를 형성한다.
- Inject로 주입을 요청받으면 Subcompoennt에서 먼저 의존성을 검색하고 없으면 부모로 올라가면서 검색한다.

## Dagger2의 장단점

### 장점

- 자원공유의 단순화 및 지정된 범위의 생명주기 내에서 동일한 인스턴스를 제공한다.
- 복잡한 의존성을 단순하게 설정할 수 이싿.
- 유닛 테스트를 쉽게 할 수 있다.
- 자동 코드 생성을 통해 디버깅이 가능하다.

![Untitled](https://user-images.githubusercontent.com/80076029/145322945-089b2595-cc46-45c8-8dc6-7075c8d6c21c.png)


