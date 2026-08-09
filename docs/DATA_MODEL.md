# Datenmodell

## Category

| Feld | Typ | Beschreibung |
|---|---|---|
| id | Long | Primärschlüssel |
| name | String | Kategoriename |
| active | boolean | Aktivstatus |

## Budget

| Feld | Typ | Beschreibung |
|---|---|---|
| id | Long | Primärschlüssel |
| categoryId | Long | Kategorie |
| amountCents | long | Budget in Cent |
| year | int | Jahr |
| month | int | Monat |

Constraint:

```text
UNIQUE(category_id, year, month)
```

## Expense

| Feld | Typ | Beschreibung |
|---|---|---|
| id | Long | Primärschlüssel |
| categoryId | Long | Kategorie |
| amountCents | long | Betrag in Cent |
| description | String | Beschreibung |
| expenseDate | LocalDate | Ausgabedatum |

## Subscription

| Feld | Typ | Beschreibung |
|---|---|---|
| id | Long | Primärschlüssel |
| name | String | Anbieter/Name |
| amountCents | long | Betrag |
| billingCycle | enum | MONTHLY / YEARLY |
| nextPaymentDate | LocalDate | nächste Zahlung |
| active | boolean | Aktivstatus |

## SavingsGoal

| Feld | Typ | Beschreibung |
|---|---|---|
| id | Long | Primärschlüssel |
| name | String | Zielname |
| targetAmountCents | long | Zielbetrag |
| currentAmountCents | long | aktueller Betrag |
| targetDate | LocalDate | Zieltermin |

## Geldbeträge

Java-Domain:

```java
long 
```

Persistenz:

```text
INTEGER / BIGINT in Cent
```

Dadurch werden Rundungsprobleme mit `double` vermieden.
