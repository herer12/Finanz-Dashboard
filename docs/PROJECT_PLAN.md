# Projektplan – Finance Dashboard

## 1. Projektübersicht

### Projektname

Finance Dashboard

### Projekttyp

Persönliche Finanzmanagement-Anwendung als Webanwendung.

### Ausgangslage

Finanzielle Informationen wie Budgets, Ausgaben, Abonnements und Sparziele sollen an einem Ort erfasst und übersichtlich dargestellt werden.

### Vision

Eine einfache, übersichtliche und technisch saubere Anwendung, die einen schnellen Überblick über die persönliche finanzielle Situation ermöglicht.

---

## 2. Ziele

### Primäre Ziele

1. Budgets pro Kategorie verwalten.
2. Ausgaben erfassen und gegen Budgets vergleichen.
3. Abonnements verwalten.
4. Monatliche Abo-Gesamtkosten berechnen.
5. Sparziele verwalten.
6. Sparfortschritt visualisieren.
7. Zentrale Kennzahlen auf einem Dashboard darstellen.

### Sekundäre Ziele

- saubere Schichtenarchitektur
- nachvollziehbare Datenhaltung
- automatisierte Tests
- versionierte Datenbankmigrationen
- REST-API als stabile Backend-Schnittstelle
- Erweiterbarkeit für zukünftige Funktionen

---

## 3. Umfang

### In Scope – MVP

#### Dashboard

- Monatsbudget
- aktuelle Ausgaben
- verbleibendes Budget
- monatliche Abo-Kosten
- Sparfortschritt
- Budgetstatus pro Kategorie

#### Kategorien

- Kategorie erstellen
- Kategorie bearbeiten
- Kategorie deaktivieren
- Kategorien für Budgets und Ausgaben verwenden

#### Budgets

- Monatsbudget pro Kategorie
- Budgetbetrag ändern
- Budgetverbrauch berechnen
- verbleibendes Budget berechnen
- Status: normal / Warnung / überschritten

#### Ausgaben

- Ausgabe erfassen
- Betrag
- Kategorie
- Datum
- Beschreibung
- Ausgaben pro Monat und Kategorie aggregieren

#### Abonnements

- Abo anlegen
- Name
- Betrag
- Abrechnungsintervall
- nächste Zahlung
- aktiv/inaktiv
- monatliche Kosten berechnen
- jährliche Kosten optional anzeigen

#### Sparziele

- Ziel erstellen
- Zielbetrag
- aktueller Betrag
- Zieltermin
- Sparfortschritt
- Sparziel aktualisieren

---

## 4. Out of Scope für MVP

Folgende Funktionen werden bewusst später betrachtet:

- Bankkonto-Anbindung
- PSD2/Open-Banking-Integration
- automatische Transaktionsimporte
- Benutzerverwaltung
- Multi-User
- Cloud-Synchronisation
- mobile native App
- automatische Steuerberatung
- KI-basierte Finanzberatung
- Echtzeit-Börsendaten
- komplexe Investmentverwaltung

---

## 5. Nichtfunktionale Anforderungen

### Performance

- normale API-Anfragen sollen im lokalen Betrieb schnell reagieren
- Datenbankabfragen sollen keine unnötigen vollständigen Tabellen-Scans verursachen

### Wartbarkeit

- klare Trennung von Controller, Service und Repository
- aussagekräftige Namen
- kleine, testbare Methoden
- keine Geschäftslogik in REST-Controllern

### Sicherheit

- keine Passwörter oder Secrets im Repository
- Eingaben validieren
- keine SQL-Strings aus ungeprüften Benutzereingaben zusammensetzen
- spätere Authentifizierung vorbereiten

### Datenintegrität

- Pflichtfelder mit Datenbank-Constraints absichern
- Fremdschlüssel verwenden
- positive Geldbeträge validieren
- konsistente Datums- und Währungsregeln

---

## 6. Technische Architektur

```text
Frontend
   |
   | HTTP/JSON
   v
REST Controller
   |
   v
Service Layer
   |
   v
Repository Layer
   |
   v
SQLite
```

### Schichten

#### Controller

Verantwortlich für:

- HTTP-Endpunkte
- Request/Response
- Validierung auf API-Ebene
- HTTP-Statuscodes

#### Service

Verantwortlich für:

- Geschäftslogik
- Berechnungen
- Regeln
- Transaktionen

#### Repository

Verantwortlich für:

- Datenbankzugriff
- Queries
- Persistenz

#### Model

Enthält die fachlichen Datenstrukturen.

---

## 7. Projektstruktur

```text
finance-dashboard/
├── README.md
├── pom.xml
├── .gitignore
├── .env
├── LICENSE
├── .gitattributes
├── docs/
│   ├── PROJECT_PLAN.md
│   ├── ARCHITECTURE.md
│   ├── DATA_MODEL.md
│   ├── API.md
│   ├── ROADMAP.md
│   ├── DEFINITION_OF_DONE.md
│   └── DECISIONS.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── finance/
│   │   │       ├── FinanceApplication.java
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       ├── dto/
│   │   │       ├── mapper/
│   │   │       ├── exception/
│   │   │       └── config/
│   │   └── resources/
│   └── test/
│       └── java/
└── data/
    └── finance.db
```

---

## 8. Fachliche Regeln

### Geld

- Java: `BigDecimal`
- Datenbank: Integer in Cent
- keine Berechnung mit `double`

### Budgetverbrauch

```text
Budgetverbrauch = Ausgaben / Budget
```

Ein Budget gilt beispielsweise als:

- unter 80 %: normal
- 80–100 %: Warnung
- über 100 %: überschritten

Die Schwellenwerte sollen später konfigurierbar sein.

### Sparfortschritt

```text
Fortschritt = aktueller Betrag / Zielbetrag
```

Der Wert wird für die UI als Prozentwert ausgegeben.

### Abos

Unterstützte Intervalle im MVP:

- monatlich
- jährlich

Jährliche Kosten können auf einen Monatswert umgerechnet werden.

---

## 9. Datenmodell

Kernentitäten:

- Category
- Budget
- Expense
- Subscription
- SavingsGoal

Beziehungen:

```text
Category 1 ─── N Budget
Category 1 ─── N Expense

SavingsGoal unabhängig
Subscription unabhängig
```

Details siehe `DATA_MODEL.md`.

---

## 10. API

Die API soll REST-orientiert aufgebaut werden.

Beispiele:

```text
GET    /api/dashboard
GET    /api/categories
POST   /api/categories
PUT    /api/categories/{id}
DELETE /api/categories/{id}

GET    /api/budgets
POST   /api/budgets
PUT    /api/budgets/{id}
DELETE /api/budgets/{id}

GET    /api/expenses
POST   /api/expenses
PUT    /api/expenses/{id}
DELETE /api/expenses/{id}

GET    /api/subscriptions
POST   /api/subscriptions
PUT    /api/subscriptions/{id}
DELETE /api/subscriptions/{id}

GET    /api/savings-goals
POST   /api/savings-goals
PUT    /api/savings-goals/{id}
DELETE /api/savings-goals/{id}
```

---

## 11. Validierung

Beispiele:

- Betrag > 0
- Zielbetrag > 0
- aktueller Sparbetrag >= 0
- Zieltermin darf nicht ungültig sein
- Name darf nicht leer sein
- Kategorie muss existieren
- Budget darf nicht doppelt für dieselbe Kategorie und denselben Monat angelegt werden

---

## 12. Fehlerbehandlung

Standardisierte API-Fehler:

```json
{
  "timestamp": "2026-08-08T14:20:00",
  "status": 400,
  "error": "VALIDATION_ERROR",
  "message": "Der Betrag muss größer als 0 sein."
}
```

Geplante Fehlerklassen:

- ValidationException
- ResourceNotFoundException
- BusinessRuleException

---

## 13. Testing

### Unit Tests

Schwerpunkt:

- Budgetberechnungen
- Abo-Berechnungen
- Sparfortschritt
- Validierungsregeln

### Integration Tests

- Repository + SQLite
- Service + Repository
- REST Controller + Service

### Ziel

Kritische Geschäftslogik soll umfassend getestet werden.

---

## 14. Logging

Logging mit Logger vom at.erik_van_haentjens.

Zu loggen:

- wichtige Anwendungsereignisse
- Fehler
- Datenbank-/Integrationsprobleme

Nicht loggen:

- sensible Finanzdaten, sofern nicht erforderlich
- Secrets
- Passwörter
- Tokens

---

## 15. Definition of Done

Eine Funktion gilt als fertig, wenn:

- fachliche Anforderungen erfüllt sind
- Validierung vorhanden ist
- Fehlerfälle behandelt werden
- Unit Tests vorhanden sind
- relevante Integration Tests vorhanden sind
- API dokumentiert ist
- Code formatiert und sauber ist
- keine unnötigen technischen Schulden eingeführt wurden

Details siehe `DEFINITION_OF_DONE.md`.

---

## 16. Risiken

### SQLite

SQLite ist hervorragend für eine lokale Single-User-Anwendung geeignet. Bei späterer Mehrbenutzer- oder Server-Nutzung muss die Datenbankstrategie neu bewertet werden.

### Finanzdaten

Finanzdaten sind sensibel. Falls die Anwendung später öffentlich erreichbar wird, müssen Authentifizierung, Autorisierung, Verschlüsselung, Backups und Datenschutz deutlich erweitert werden.

### Währungsmodell

Zunächst wird eine einzelne Standardwährung angenommen. Multi-Currency wird erst bei konkretem Bedarf umgesetzt.

---

## 19. Zukunft / mögliche Erweiterungen

- Benutzerkonten
- mehrere Währungen
- wiederkehrende Ausgaben
- Einnahmen
- Monatsberichte
- CSV-Import
- CSV-Export
- Diagramme
- PDF-Berichte
- Benachrichtigungen
- Bankintegration
- Investment-Tracking
- Docker
- PostgreSQL für Multi-User-Betrieb
- mobile Frontend-Anwendung

---

## 20. Erfolgskriterien für MVP

Das MVP ist erfolgreich, wenn ein Benutzer:

1. Kategorien anlegen kann.
2. Monatsbudgets definieren kann.
3. Ausgaben erfassen kann.
4. seinen Budgetverbrauch sehen kann.
5. Abos erfassen kann.
6. monatliche Abo-Kosten sehen kann.
7. Sparziele erstellen kann.
8. den Fortschritt seiner Sparziele sehen kann.
9. alle Kerninformationen auf dem Dashboard findet.
10. Daten nach einem Neustart der Anwendung weiterhin vorfindet.
