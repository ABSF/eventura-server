# eventura-server
 Backend dla serwisu eventura.pl

---
### Uruchomienie środowiska deweloperskiego
##### Wymagania:
* Docker for Windows lub Docker i Docker Compose
* IntelliJ IDEA
* JDK 11

##### Uruchomienie:
1. Pobrać kod
2. Zaimportować projekt do IDE
3. Uruchomić Docker\`a i w lokalizacji projektu odpalić polecenie: `docker-compose up -d`
4. Połączyć się do bazy i uruchomić skrypt `recreate-dev-database.sql`
5. Uruchomić aplikację w IDE (bootRun)
