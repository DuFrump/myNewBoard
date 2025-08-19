# MyNewBoard :: Spring Boot & JPA 기반 웹 게시판 프로젝트 🚀

Spring Boot, Spring Data JPA, Spring Security를 기반으로 제작된 웹 게시판 프로젝트입니다. 사용자 인증(자체 회원가입, Google OAuth2)과 CRUD 기능을 갖춘 게시판의 핵심 로직을 학습하고, Docker를 이용해 배포하는 전 과정을 경험하는 것을 목표로 합니다.

## ✨ 주요 기능

-   **👤 회원 기능**
    -   자체 이메일/비밀번호를 통한 회원가입 및 로그인
    -   Google 계정을 연동한 소셜 로그인 (OAuth2/OIDC)
-   **📝 게시판 CRUD**
    -   인증된 사용자의 게시글 생성, 조회, 수정, 삭제 기능
    -   게시글 수정/삭제 시 작성자 본인 확인 로직 포함
-   **🔒 보안**
    -   Spring Security를 통한 인증/인가 관리 및 URL 접근 제어
    -   BCrypt를 이용한 비밀번호 단방향 암호화
    -   CSRF(Cross-Site Request Forgery) 공격 방어 활성화

## 🛠️ 기술 스택

-   **Backend**: Java 17, Spring Boot 3.5.4, Spring Security, Spring Data JPA
-   **Frontend**: Thymeleaf, JavaScript, HTML/CSS
-   **Database**: PostgreSQL (Production), H2 (Development)
-   **Build Tool**: Gradle
-   **Deployment**: Docker, Render.com

## 🚀 시작하기

### 사전 요구사항

-   Java 17 (JDK 17)
-   Git

### 로컬에서 실행하기

1.  **프로젝트 클론**
    ```bash
    git clone [https://github.com/DuFrump/myNewBoard.git](https://github.com/DuFrump/myNewBoard.git)
    cd myNewBoard
    ```

2.  **환경 변수 설정**
    Google OAuth2 로그인을 사용하려면 `application.yml` 파일에 있는 아래 항목들을 실제 값으로 설정해야 합니다.
    -   `GOOGLE_CLIENT_ID`
    -   `GOOGLE_CLIENT_SECRET`

    운영 환경(Production)에서 PostgreSQL을 사용하려면 `application_prod.yml` 파일의 데이터베이스 관련 환경 변수를 설정해야 합니다.

3.  **애플리케이션 실행**
    아래 명령어를 통해 H2 인메모리 데이터베이스와 함께 애플리케이션을 실행할 수 있습니다.
    ```bash
    ./gradlew bootRun
    ```

## 🐳 Docker를 이용한 배포

프로젝트 루트 경로에 포함된 `Dockerfile`을 사용하여 애플리케이션을 컨테이너화하고 배포할 수 있습니다.

```bash
# Docker 이미지 빌드
docker build -t mynewboard .

# Docker 컨테이너 실행
docker run -p 8080:8080 -e GOOGLE_CLIENT_ID=your-id -e GOOGLE_CLIENT_SECRET=your-secret mynewboard
```
