# Architektur

## Ziel

Die Anwendung folgt einer klassischen Schichtenarchitektur.

```text
HTTP
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
JPA/Hibernate
 ↓
SQLite
```

## Packages

### model

Persistente Domänenmodelle.

### dto

API-spezifische Request- und Response-Objekte.

### mapper

Konvertierung zwischen Entity und DTO.

### repository

Spring-Data-Repositories und Datenbankabfragen.

### service

Geschäftslogik.

### controller

REST API.

### exception

Zentrale Fehlerbehandlung.

### config

Anwendungs- und Infrastrukturkonfiguration.

## Grundsätze

- Controller bleiben dünn.
- Services enthalten Geschäftsregeln.
- Entities werden nicht direkt als API-Verträge verwendet.
- DTOs bilden die öffentliche API.
- Datenbankzugriff erfolgt ausschließlich über Repositories.
- Berechnungen werden testbar in Services oder fachlichen Komponenten gehalten.
