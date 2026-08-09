
CREATE TABLE IF NOT EXISTS "Category" (
                            "id"	Long UNIQUE,
                            "name"	String NOT NULL,
                            "active"	boolean NOT NULL,
                            PRIMARY KEY("id")

);

CREATE TABLE IF NOT EXISTS "Budget"(
    "id" Long Unique,
    categoryId Long,
    amountCents Long,
    year Int,
    month Int,
    PRIMARY KEY("id"),
    Unique("categoryId", "year", "month"),
    foreign key ("categoryId") references "Category"("id")
);

Create Table IF NOT EXISTS "Expense"(
    id Long UNIQUE,
    categoryId Long,
    amountCents Long,
    description String,
    expenseDate LocalDate,
    PRIMARY KEY("id"),
    foreign key ("categoryId") references "Category"("id")
);

Create TABLE IF NOT EXISTS "Subscription"(
    id Long,
    name String,
    amountCents Long,
    nextPaymentDate LocalDate,
    active boolean,
    billingCycle CHECK ( billingCycle IN ('monthly', 'yearly') ),
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "SavingsGoal"(
    id Long,
    name String,
    targetAmountCents Long,
    currentAmountCents Long,
    targetDate LocalDate,
    PRIMARY KEY("id")
)

