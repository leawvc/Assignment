# Assignment
commit massege : (기능 이름) 구현
### Swagger url
http://localhost:8080/swagger-ui/index.html#/
<br></br>
### ERD
![image](https://user-images.githubusercontent.com/43610417/189479484-0e605974-00d4-4cb5-ab57-8987d4931d5b.png)
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
* 조건 처리 : https://numchar.tistory.com/32
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
