# Weather Application

This is a Spring Boot-based weather application that fetches weather data from an external API and caches the response using Redis. The application demonstrates how to make non-blocking requests with `WebClient` and handle caching with Redis.

## Features
- **Fetch Weather Data**: Retrieves weather information for a specific city and country from an external weather API (Visual Crossing API).
- **Redis Caching**: Caches the weather data to avoid making repeated API calls for the same request.
- **Error Handling**: Handles different types of errors such as invalid requests or server-side errors from the external API.

## Technologies Used
- **Spring Boot**: Framework for building Java applications.
- **WebClient**: Non-blocking, reactive client for making HTTP requests.
- **Redis**: In-memory data store used for caching.
- **Docker**: Containerization of Redis using `docker-compose`.
- **Maven**: Build and dependency management.

## Prerequisites
- **Java 17** or higher
- **Maven** (for building the project)
- **Redis** (can be run using Docker)
- **Docker and Docker Compose** (optional, for running Redis)

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/weather-app.git
cd weather-app
