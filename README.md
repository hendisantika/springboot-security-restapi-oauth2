# Spring Boot Security REST API with OAuth2

A Spring Boot 4.0 application demonstrating OAuth2 Authorization Server and Resource Server implementation using Spring
Security 7.

## Tech Stack

- Java 21
- Spring Boot 4.0.0
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

- JDK 21 or later
- Maven 3.9+

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
