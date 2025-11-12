# STAYLOG

> Acorn Team404 Final Project - 숙박 예약 플랫폼

## 프로젝트 소개

STAYLOG는 사용자에게 편리한 숙박 시설 검색 및 예약 서비스를 제공하는 플랫폼입니다.


## 기술 스택

### Backend
- **Java**: 17
- **Spring Boot**: 3.5.6
- **Spring Security**: JWT 기반 인증
- **MyBatis**: 3.0.5
- **Database**: Oracle Database (ojdbc11)

### Infrastructure
- **Connection Pool**: HikariCP
- **API Documentation**: Swagger (springdoc-openapi 2.7.0)
- **Build Tool**: Maven

### External APIs
- **Kakao Local API**: 위치 기반 서비스
- **Toss Payments**: 결제 시스템
- **Email**: SMTP (Gmail)

## 🛠 시스템 아키텍처

STAYLOG의 백엔드 구조는 **Spring Boot 기반의 REST API 서버**로 구성되어 있으며,  
클라이언트(React, JSP 등)와의 통신은 JSON 형태로 이루어집니다.  
Toss Payments, Kakao API 등 외부 서비스와의 연동을 통해 예약, 결제, 알림 기능을 제공합니다.

```mermaid
flowchart LR
    Client[Frontend - Staylog Web/App]
    subgraph Backend["Staylog Backend (Spring Boot)"]
        Controller["Controller Layer"]
        Service["Service Layer"]
        Mapper["MyBatis Mapper"]
        DB[(Oracle DB)]
        External["External APIs (Toss, Kakao, SMTP)"]
    end

    Client -->|REST API (JSON)| Controller
    Controller --> Service
    Service --> Mapper
    Mapper --> DB
    Service --> External
```
## 주요 기능

### 사용자 기능
- 회원 가입 및 로그인 (JWT 인증)
- 숙박 시설 검색 및 예약
- 리뷰 작성 및 조회
- 마이페이지 (예약 내역, 쿠폰 관리)
- 게시판 (문의 및 커뮤니티)
- 실시간 알림 (SSE)

### 관리자 기능
- 숙박 시설 관리
- 예약 관리
- 회원 관리

### 결제 기능
- Toss Payments 연동
- 가상계좌 결제 지원

## 프로젝트 구조

```
src/main/java/com/staylog/staylog/
├── domain/
│   ├── accommodation/    # 숙박 시설 관리
│   ├── admin/           # 관리자 기능
│   ├── board/           # 게시판
│   ├── home/            # 홈 화면
│   ├── image/           # 이미지 관리
│   ├── mypage/          # 마이페이지
│   └── notification/    # 알림 시스템
└── global/
    └── config/          # 전역 설정

src/main/resources/
├── mapper/              # MyBatis XML 매퍼
├── application-common.yml
└── static/
```

## 환경 설정

### 필수 요구사항
- Java 17 이상
- Maven 3.6 이상
- Oracle Database

### 설정 파일

`application-common.yml` 파일에 다음 정보를 설정해야 합니다:

- Database 연결 정보
- JWT Secret Key
- Email 인증 정보
- Kakao API Key
- Toss Payments API Key
- 
## API 문서


## 주요 엔드포인트

- `/api/accommodations` - 숙박 시설 조회
- `/api/rooms` - 객실 정보
- `/api/reservations` - 예약 관리
- `/api/reviews` - 리뷰
- `/api/board` - 게시판
- `/api/mypage` - 마이페이지
- `/api/admin` - 관리자

## 보안

- JWT 기반 인증 시스템
- Access Token 유효기간: 1시간
- Refresh Token 유효기간: 14일
- Spring Security를 통한 API 접근 제어

## 개발 브랜치



