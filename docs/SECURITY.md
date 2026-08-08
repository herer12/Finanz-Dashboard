# Security

## Grundsätze

- Keine Secrets im Git-Repository.
- Finanzdaten nicht unnötig loggen.
- API-Eingaben validieren.
- Datenbankzugriffe ausschließlich über sichere Abstraktionen.
- Bei späterem Remote-Betrieb Authentifizierung und Autorisierung verpflichtend einführen.

## Datenschutz

Die Anwendung ist zunächst als lokale Single-User-Anwendung konzipiert. Sobald personenbezogene Finanzdaten über ein Netzwerk verarbeitet werden, müssen Datenschutz, Zugriffsschutz, Backups und Verschlüsselung gesondert betrachtet werden.
