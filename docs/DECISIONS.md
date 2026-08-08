# Architecture Decision Records

## ADR-001 – SQLite als Datenbank

### Status

Akzeptiert

### Entscheidung

SQLite wird für das MVP verwendet.

### Begründung

- einfache lokale Installation
- keine separate Datenbankinstanz notwendig
- für eine persönliche Single-User-Anwendung ausreichend
- einfache Backups über eine Datenbankdatei
- späterer Wechsel auf PostgreSQL möglich

### Konsequenz

Die Architektur soll Datenbankdetails kapseln, damit ein späterer Wechsel möglichst wenig Einfluss auf die Fachlogik hat.

---

## ADR-002 – Spring Boot

### Status

Akzeptiert

### Entscheidung

Spring Boot wird als Backend-Framework verwendet.

### Begründung

- etabliertes Java-Ökosystem
- REST-Unterstützung
- Dependency Injection
- Validation
- Testing
- gute Erweiterbarkeit

---

## ADR-003 – Geldbeträge

### Status

Akzeptiert

### Entscheidung

Geld wird in Java mit `BigDecimal` behandelt und in der Datenbank als Centbetrag gespeichert.

### Begründung

Vermeidung von Ungenauigkeiten durch binäre Floating-Point-Darstellung.

---

## ADR-004 – DTOs

### Status

Akzeptiert

### Entscheidung

REST-Endpunkte verwenden DTOs statt direkt JPA-Entities zurückzugeben.

### Begründung

- klare API-Verträge
- bessere Entkopplung
- Schutz der Persistenzmodelle
- leichteres API-Versionieren
