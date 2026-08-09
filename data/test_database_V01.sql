-- =========================
-- Category
-- =========================

INSERT INTO "Category" ("id", "name", "active") VALUES
                                                    (1, 'Wohnen', true),
                                                    (2, 'Lebensmittel', true),
                                                    (3, 'Transport', true),
                                                    (4, 'Freizeit', true),
                                                    (5, 'Abonnements', true),
                                                    (6, 'Gesundheit', true),
                                                    (7, 'Shopping', true),
                                                    (8, 'Urlaub', false);


-- =========================
-- Budget
-- =========================

INSERT INTO "Budget" ("id", "categoryId", "amountCents", "year", "month") VALUES
                                                                              (1, 1, 120000, 2026, 8),
                                                                              (2, 2, 50000, 2026, 8),
                                                                              (3, 3, 30000, 2026, 8),
                                                                              (4, 4, 25000, 2026, 8),
                                                                              (5, 5, 15000, 2026, 8),
                                                                              (6, 6, 20000, 2026, 8),
                                                                              (7, 7, 30000, 2026, 8),

                                                                              (8, 1, 120000, 2026, 9),
                                                                              (9, 2, 50000, 2026, 9),
                                                                              (10, 3, 30000, 2026, 9),
                                                                              (11, 4, 25000, 2026, 9),
                                                                              (12, 5, 15000, 2026, 9),
                                                                              (13, 6, 20000, 2026, 9),
                                                                              (14, 7, 30000, 2026, 9);


-- =========================
-- Expense
-- =========================

INSERT INTO "Expense"
("id", "categoryId", "amountCents", "description", "expenseDate") VALUES
                                                                      (1, 1, 95000, 'Miete August', '2026-08-01'),
                                                                      (2, 2, 4250, 'Wocheneinkauf Supermarkt', '2026-08-02'),
                                                                      (3, 2, 1890, 'Bäckerei', '2026-08-03'),
                                                                      (4, 3, 4990, 'Monatskarte öffentliche Verkehrsmittel', '2026-08-01'),
                                                                      (5, 4, 1299, 'Kino', '2026-08-04'),
                                                                      (6, 2, 3275, 'Supermarkt', '2026-08-05'),
                                                                      (7, 7, 5999, 'T-Shirt', '2026-08-06'),
                                                                      (8, 6, 2500, 'Apotheke', '2026-08-06'),
                                                                      (9, 4, 1890, 'Restaurant', '2026-08-07'),
                                                                      (10, 3, 3500, 'Taxi', '2026-08-07'),
                                                                      (11, 2, 2875, 'Supermarkt', '2026-08-08'),
                                                                      (12, 4, 850, 'Kaffee', '2026-08-08');


-- =========================
-- Subscription
-- =========================

INSERT INTO "Subscription"
("id", "name", "amountCents", "nextPaymentDate", "active", "billingCycle") VALUES
                                                                               (1, 'Netflix', 1799, '2026-09-01', true, 'monthly'),
                                                                               (2, 'Spotify', 1099, '2026-09-05', true, 'monthly'),
                                                                               (3, 'Amazon Prime', 899, '2026-09-10', true, 'monthly'),
                                                                               (4, 'Disney+', 1099, '2026-09-15', true, 'monthly'),
                                                                               (5, 'GitHub', 499, '2026-09-20', true, 'monthly'),
                                                                               (6, 'Fitnessstudio', 2999, '2026-09-03', true, 'monthly'),
                                                                               (7, 'Amazon Prime Jahresabo', 8990, '2027-06-15', false, 'yearly'),
                                                                               (8, 'Cloud Storage', 2999, '2027-01-10', true, 'yearly');


-- =========================
-- SavingsGoal
-- =========================

INSERT INTO "SavingsGoal"
("id", "name", "targetAmountCents", "currentAmountCents", "targetDate") VALUES
                                                                            (1, 'Notgroschen', 500000, 275000, '2027-06-30'),
                                                                            (2, 'Neues Fahrrad', 150000, 85000, '2026-12-31'),
                                                                            (3, 'Urlaub 2027', 300000, 125000, '2027-05-01'),
                                                                            (4, 'Neuer Laptop', 200000, 45000, '2027-02-28');