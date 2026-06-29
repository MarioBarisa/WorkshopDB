# PLACEHOLDER DATA — WorkshopDB


SQL script for inserting placeholder data into each table, order is important due to FK constraints `client` → `auto`, `mechanic` → `RepairHistory`.

SQL skripta za ubacivanje placeholder podataka.
Order je bitan zbog foreign keyova: `client` → `auto`, `mechanic` → `RepairHistory`.

```sql
-- =============================================================
-- 1. CLIENTS
-- =============================================================
INSERT INTO WorkshopDB.client (name, telnumber, email) VALUES
('Ivan Horvat',     '091 234 5678', 'ivan.horvat@email.hr'),
('Ana Marić',       '098 765 4321', 'ana.maric@email.hr'),
('Marko Kovačević', '099 111 2223', 'marko.kovacevic@email.hr'),
('Petra Jurić',     '095 444 5556', 'petra.juric@email.hr'),
('Tomislav Novak',  '092 777 8889', 'tomislav.novak@email.hr'),
('Leo Kraljić',  '098 745 8234', 'leo@kraljic.hr');

-- =============================================================
-- 2. MECHANICS
-- =============================================================
INSERT INTO WorkshopDB.mechanic (name, phone) VALUES
('Josip Babić',       '091 100 2001'),
('Darko Knežević',    '098 200 3002');

-- =============================================================
-- 3. AUTOS  (FK → client.client_id)
-- =============================================================
INSERT INTO WorkshopDB.auto (client_id, make, model, VIN, enginetype, engine, kW, year, mileage) VALUES
(1, 'Volkswagen', 'Golf 7',    'WVWZZZAUZJW123456', 'Dizel',   '2.0 TDI',   110, 2018, 85000),
(2, 'BMW',        'X5',        'WBAKS420X0E789012', 'Benzin',  '3.0 Turbo', 225, 2020, 42000),
(3, 'Opel',       'Astra K',   'W0LPG6EU1G1234567', 'Dizel',   '1.6 CDTI',  100, 2017, 112000),
(4, 'Ford',       'Focus',     'WF0AXXWPMD1234568', 'Benzin',  '1.5 Ecoboost', 110, 2019, 63000),
(1, 'Škoda',      'Octavia',   'TMBGG7NE1J0123456', 'Dizel',   '2.0 TDI',   135, 2021, 34000),
(5, 'Tesla',      'Model S',   'TASGG7WE1J0654321', 'Electric',   'Dual motor',   335, 2023, 38000);

-- =============================================================
-- 4. REPAIR HISTORY  (FK → auto.auto_id, mechanic.mechanic_id)
-- =============================================================
INSERT INTO WorkshopDB.repair_history (auto_id, mechanic_id, date, title, about, price) VALUES
(1, 1, '2025-11-15', 'Redovni servis',       'Zamjena ulja, filtera i svjećica. Provjera kočionog sustava.',                    320.00),
(2, 2, '2026-01-20', 'Zamjena kočnica',       'Prednje i stražnje kočione pločice + diskovi. Ispust zraka iz sustava.',          580.50),
(3, 1, '2025-09-10', 'DPF regeneracija',      'Prisilna regeneracija DPF filtera. Dijagnostika sustava za ispuh.',                250.00),
(4, 2, '2026-03-05', 'Zamjena spojke',         'Novi set spojke (lamela + potisna ploča + ležaj). Ispitivanje mjenjača.',        890.00),
(5, 1, '2026-05-12', 'Zamjena guma + balans',  '4x ljetna guma 225/45R17, balansiranje i centriranje napravljeno.',               620.00);
```


