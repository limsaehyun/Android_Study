# GraphQL



### GrqphQL

* Graph QL(이하 gql)은 Structed Query Language(이하 sql)와 마찬가지로 쿼리 언어입니다. 하지만 gql과 sql의 언어적 구조 차이는 매우 큽니다. 또한 gql과 sql이 실전에서 쓰이는 방식의 차이도 매우 큽니다. gql과 sql의 언어적 구조 차이가 활용 측면에서의 차이를 가져왔습니다. 이 둘은 애초에 탄생 시기도 다르고 배경도 다릅니다. sql은 **데이터베이스 시스템**에 저장된 데이터를 효율적으로 가져오는 것이 목적이고, gql은 **웹 클라이언트**가 데이터를 서버로 부터 효율적으로 가져오는 것이 목적입니다. sql의 문장(statement)은 주로 백앤드 시스템에서 작성하고 호출 하는 반면, gql의 문장은 주로 클라이언트 시스템에서 작성하고 호출 합니다.



**GraphQL 파이프라인**

![img](http://tech.kakao.com/files/graphql-pipeline.png)



### REST API와의 차이점

REST API가 URL, METHOD등을 조합하여 다양한 Endpoint가 존재한 반면 GQL은 단 하나의 Endpoint가 존재합니다. 또한 GQL은 불러오는 데이터의 종류를 쿼리 조합을 통해서 결정 합니다. REST API에서는 각 Endpoint마다 데이터베이스 SQL쿼리가 달라지는 반면 GQL API는 스키마의 타입마다 데이터베이스 SQL 쿼리가 달라집니다

![img](http://tech.kakao.com/files/graphql-mobile-api.png)