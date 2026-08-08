# API-Spezifikation

## Dashboard

### GET /api/dashboard

Liefert die wichtigsten Kennzahlen.

Beispiel:

```json
{
  "monthlyBudgetCents": 250000,
  "monthlyExpensesCents": 184250,
  "remainingBudgetCents": 65750,
  "monthlySubscriptionsCents": 6797,
  "savingsGoals": []
}
```

## Categories

```text
GET    /api/categories
POST   /api/categories
PUT    /api/categories/{id}
DELETE /api/categories/{id}
```

## Budgets

```text
GET    /api/budgets?year=2026&month=8
POST   /api/budgets
PUT    /api/budgets/{id}
DELETE /api/budgets/{id}
```

## Expenses

```text
GET    /api/expenses
POST   /api/expenses
PUT    /api/expenses/{id}
DELETE /api/expenses/{id}
```

## Subscriptions

```text
GET    /api/subscriptions
POST   /api/subscriptions
PUT    /api/subscriptions/{id}
DELETE /api/subscriptions/{id}
```

## Savings Goals

```text
GET    /api/savings-goals
POST   /api/savings-goals
PUT    /api/savings-goals/{id}
DELETE /api/savings-goals/{id}
```

## HTTP Statuscodes

- 200 OK
- 201 Created
- 204 No Content
- 400 Bad Request
- 404 Not Found
- 409 Conflict
- 500 Internal Server Error
