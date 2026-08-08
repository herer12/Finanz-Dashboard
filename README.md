# Finanz-Dashboard


Persönliches Finanz-Dashboard zur Verwaltung von Budgets, Ausgaben, Abonnements und Sparzielen.

## Ziel

Die Anwendung soll finanzielle Kennzahlen übersichtlich darstellen und dabei helfen:

- Budgets pro Kategorie zu definieren und zu überwachen
- Ausgaben zu erfassen und Kategorien zuzuordnen
- monatliche Abo-Kosten zu verfolgen
- Sparziele anzulegen und deren Fortschritt zu visualisieren
- zentrale Finanzkennzahlen in einem Dashboard zusammenzufassen

## Technologie-Stack

- Java 24
- Spring Boot
- Maven
- SQLite
- Spring Data JPA / Hibernate
- REST API
- HTML/CSS/JavaScript als initiales Frontend
- JUnit 5
- Mockito
- Flyway für Datenbankmigrationen

## Projektstatus

**Phase:** Planung / initiale Entwicklung

## Dokumentation

- [Projektplan](docs/PROJECT_PLAN.md)
- [Architektur](docs/ARCHITECTURE.md)
- [Datenmodell](docs/DATA_MODEL.md)
- [API-Spezifikation](docs/API.md)
- [Entwicklungs-Roadmap](docs/ROADMAP.md)
- [Definition of Done](docs/DEFINITION_OF_DONE.md)
- [Entscheidungen](docs/DECISIONS.md)

## Start

Voraussetzungen:

- JDK 24
- Maven 3.9+
- Git

Nach dem Erstellen des Spring-Boot-Projekts:

```bash
./mvnw spring-boot:run
```

Die SQLite-Datenbank wird lokal als Datei geführt.

## Entwicklungsprinzipien

- Geldbeträge werden fachlich mit `BigDecimal` behandelt.
- Datenbankwerte für Geld werden vorzugsweise als Ganzzahlen in Cent gespeichert.
- Geschäftslogik gehört in Services, nicht in Controller.
- Persistenz wird über Repository-Abstraktionen gekapselt.
- Datenbankschema wird versioniert.
- API-Verträge werden explizit dokumentiert.
- Tests werden für kritische Geschäftslogik geschrieben.

## Lizenz

Apache License Version 2.0
