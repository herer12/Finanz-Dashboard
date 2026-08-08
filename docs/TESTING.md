# Testing Strategy

## Unit Tests

Fokus auf fachliche Regeln:

- Budgetverbrauch
- Restbudget
- Abo-Monatskosten
- Jahresabo-Umrechnung
- Sparfortschritt
- Validierung

## Integration Tests

- Repository gegen SQLite
- Datenbankmigrationen
- Service + Repository
- REST API

## Testdaten

Testdaten werden ausschließlich für Tests verwendet und dürfen keine echten Finanzdaten enthalten.

## Ziel

Kritische Geschäftslogik muss deterministisch und reproduzierbar getestet werden.
