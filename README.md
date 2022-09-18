# Assignment
commit massege : (기능 이름) 구현
### Swagger url
http://localhost:8080/swagger-ui/index.html#/
<br></br>
### ERD
![image](https://user-images.githubusercontent.com/43610417/189779748-96ae59e3-8779-48a3-a790-19533e82e4e6.png)
<br></br>
## 💻 개발 언어 및 활용 기술
### 개발 환경 
* SpringBoot2.7.1
* 빌드 도구 : Gradle
* Java11
* intellij

### Compile
* window
```
sudo apt-get remove openjdk*
sudo apt-get autoremove --purge
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt install openjdk-11-jdk
java -version
javac AssignmentApplication.java
java -cp AssignmentApplication
```
* Mac
```
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
javac AssignmentApplication.java
java -cp AssignmentApplication
```
### 에러 처리
* Currency : https://numchar.tistory.com/31
* 저자 여러명 : https://numchar.tistory.com/29
* 에러 처리 : https://numchar.tistory.com/27
* Swagger : https://numchar.tistory.com/26
* 조건 처리 : https://numchar.tistory.com/32 -> 리펙토링 코드 : https://numchar.tistory.com/34
### 폴더 구조
* assignment
   * Config
   * Controller
   * Domain
   * DTO
   * Repository
   * Service

### 디렉토리의 분리 이유
1. 기능별로 분리했기에 확장성과 가독성에 편리하다.
2. 코드별로 유지 보수가 편리하다.
3. Servicelmpl의 경우 객체간의 결합도를 낮추며 하나의 인터페이스만 바라보는 경우를 줄여 의존성을 낮춰준다.
4. DTO의 경우 Entity자체를 건들지 않고 값을 전달해주는 역활을 하기에 의존성을 낮춰준다.
5. RequestDto, ResponseDto를 나눌 시 응답을 받을 객체와 값을 전달할 객체를 구분하기에 용이하다.

### 코드 별 사용 이유
1. private final : 생성자를 이용하여 의존성 주입을 위해서 사용, 순환 참조를 방지하며 불변성을 보장한다.
2. @RequiredArgsConstructor : final이 선언된 모든 필드를 인자 값으로 하는 생성자 생성하며 의존성이 변경 될때마다 생성자 코드를 수정하는 것을 방지해준다.
3. @RestController : 컨트롤러에서 View를 반환하기도 하지만 Data를 반환할 수도 있고 Json형태로 객체 데이터를 반환에 사용할 수 있기에 사용
4. @AllArgsConstructor : @Setter를 사용하지 않기에 new()방식으로 객체를 생성한다면 유지 시킨 일관성이 깨질 위험이 있으므로 @Builder어노테이션을 사용 하지만 여기서 @Builder가 적용된 모든 필드의 생성자가 필요하기에 전체 필드에 대한 생성자를 만들어 주는 @AllArgsConstructor 사용
5. @Builder : 생성자를 통해 객체를 생성하게 해주며 가독성을 유지하기 위해서 사용
6. @NoArgsConstructor : 클래스에 기본 생성자를 만들어주지만 접근제한을 걸어서 엔티티의 영속성을 유지시키기 위해서 JPA의 최대 수준의 생성자인 @NoArgsConstructor(access = AccessLevel.PROTECTED)을 사용해서 안전성을 높힘
7. ResponseDto에만 @Setter를 사용한 이유 : set을 사용시 영속성의 일관된 상태가 깨지기에 요청받은 값을 전달하기 위한 객체로 생성한 ResponseDto에만 적용
8. @JsonManagedReference : 순환 참조를 방지하기 위해서 부모 클래스에 사용
9. @JsonBackReference : 순환 참조를 방지하기 위해서 자식 클래스에 사용
10. paging처리 : paging의 기본 값으로 10개를 고정하였고 몇 번째 페이지인지 0번째 부터 값을 RequestParam으로 가져 올 수 있게 하였다.
11. 소수점 조건 처리 : 값을 입력 받아서 소수점으로부터 길이를 측정하려고 하니 float으로 입력 받은 값을 소수점을 기준으로 나눌수 없었다. 그렇기에 입력받는 값을 String형으로 입력을 받아서 contains으로 포함이 되어 있는지 확인을 한 후에 배열에 담은 값을 두 번째 칸을 길이를 측정한 후 2보다 많은 경우 RuntimeError를 넣었다.

### 일정
* 09-07 : Swagger 목업 작업, ERD설계
* 09-08 : Swagger 에러 처리
* 09-09 : Paging 처리
* 09-10 : isbn 처리, Currency 의존성 문제 발견
* 09-11 : Currency 문제 해결 및 조건 처리, 에러 정리
* 09-12 : 연관 관계 편의 메서드 설정, Price isbn조건 처리 완료, Readme 정리
* 09-13 : 에러 정리, Readme 정리
* 09-18 : 코드 리펙토링
