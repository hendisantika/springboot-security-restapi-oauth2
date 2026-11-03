# Spring Boot Security REST API with OAuth2

[![Java CI with Maven](https://github.com/hendisantika/springboot-security-restapi-oauth2/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/springboot-security-restapi-oauth2/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot)
[![Dependabot](https://img.shields.io/badge/Dependabot-enabled-025E8C?logo=dependabot)](.github/dependabot.yml)

A Spring Boot 4.1 application demonstrating OAuth2 Authorization Server and Resource Server implementation using Spring
Security 7.

## Tech Stack

- Java 25 (LTS)
- Spring Boot 4.1.2
- Spring Security 7
- Spring Authorization Server
- Lombok

## Features

- OAuth2 Authorization Server with JWT tokens
- Client Credentials Grant support
- Authorization Code Grant support
- OIDC (OpenID Connect) support
- In-memory user and client management
- Protected REST API endpoints

## Prerequisites

- JDK 25 or later
- Maven 3.9+ (or use the bundled Maven Wrapper `./mvnw`, which downloads Maven 3.10.0)

## Running the Application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## OAuth2 Endpoints

| Endpoint                            | Description             |
|-------------------------------------|-------------------------|
| `/oauth2/authorize`                 | Authorization endpoint  |
| `/oauth2/token`                     | Token endpoint          |
| `/oauth2/jwks`                      | JWK Set endpoint        |
| `/.well-known/openid-configuration` | OIDC Discovery endpoint |

## Testing

### Get Access Token (Client Credentials)

```bash
curl -X POST http://localhost:8080/oauth2/token \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -u "my-trusted-client:secret" \
  -d "grant_type=client_credentials&scope=read write"
```

### Access Protected Endpoint

```bash
curl -H "Authorization: Bearer <access_token>" http://localhost:8080/user
```

## Default Credentials

### Users

| Username | Password | Roles |
|----------|----------|-------|
| admin    | 12345    | ADMIN |
| naruto   | 12345    | USER  |

### OAuth2 Client

| Property      | Value                                                 |
|---------------|-------------------------------------------------------|
| Client ID     | my-trusted-client                                     |
| Client Secret | secret                                                |
| Scopes        | openid, profile, read, write                          |
| Grant Types   | authorization_code, refresh_token, client_credentials |

## Project Structure

```
src/main/java/com/hendisantika/springbootsecurityrestapioauth2/
├── SpringbootSecurityRestapiOauth2Application.java  # Main application class
├── config/
│   └── AuthorizationServerConfig.java              # OAuth2 & Security configuration
├── controller/
│   ├── UserRestController.java                     # REST API endpoints
│   └── RestClient.java                             # Example OAuth2 client
├── model/
│   ├── User.java                                   # User entity
│   └── AuthTokenInfo.java                          # Token information DTO
└── service/
    ├── UserService.java                            # User service interface
    └── UserServiceImpl.java                        # User service implementation
```

## Configuration

Key configuration in `AuthorizationServerConfig.java`:

- **JWT**: RSA 2048-bit key pair for token signing
- **Access Token TTL**: 5 minutes
- **Refresh Token TTL**: 30 minutes
- **Password Encoder**: BCrypt

## Building

```bash
./mvnw clean package
```

## Running Tests

```bash
./mvnw test
```

## CI/CD

GitHub Actions workflow [`.github/workflows/maven.yml`](.github/workflows/maven.yml):

- Runs on every push and pull request to `master` (and manually via `workflow_dispatch`)
- Builds and tests with **Temurin JDK 25** using `./mvnw -B verify` with Maven dependency caching
- Least-privilege `permissions` and `concurrency` (cancels outdated runs on the same branch)
- Submits the Maven dependency graph to GitHub (only on push to `master`) to improve Dependabot alerts

## Dependency Updates (Dependabot)

Configured in [`.github/dependabot.yml`](.github/dependabot.yml):

| Ecosystem      | Schedule                 | Grouping                                         |
|----------------|--------------------------|--------------------------------------------------|
| Maven          | Daily, 21:00 WIB         | `spring`, `test`, `maven-plugins` (minor/patch)  |
| GitHub Actions | Weekly (Mon), 21:00 WIB  | All actions in a single PR                       |

PRs are labeled (`dependencies`, `java` / `github-actions`), assigned, and use conventional commit prefixes
(`chore(deps)`, `ci(deps)`).
