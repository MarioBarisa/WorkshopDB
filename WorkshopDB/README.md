
<div align="center">
 <h1 style="display:flex; align-items:center; justify-content:center; gap:12px;">
    <svg viewBox="0 0 24 24" fill="none" width="68" height="68" xmlns="http://www.w3.org/2000/svg">
      <path opacity="0.1" d="M20 7C20 9.20914 16.4183 11 12 11C7.58172 11 4 9.20914 4 7C4 4.79086 7.58172 3 12 3C16.4183 3 20 4.79086 20 7Z" fill="#ffffff"/>
      <path opacity="0.1" d="M19.75 13.4766C19.3141 14.0925 18.6191 14.6267 17.7687 15.052C16.2794 15.7966 14.2395 16.25 12 16.25C9.76047 16.25 7.72059 15.7966 6.23134 15.052C5.38086 14.6267 4.68587 14.0925 4.25 13.4766V17C4.25 17.9588 5.03381 18.8942 6.45495 19.6048C7.86113 20.3079 9.82126 20.75 12 20.75C14.1787 20.75 16.1389 20.3079 17.5451 19.6048C18.9662 18.8942 19.75 17.9588 19.75 17V13.4766Z" fill="#ffffff"/>
      <path d="M20 7C20 9.20914 16.4183 11 12 11C7.58172 11 4 9.20914 4 7C4 4.79086 7.58172 3 12 3C16.4183 3 20 4.79086 20 7Z" stroke="#ffffff" stroke-width="2"/>
      <path d="M20 12C20 14.2091 16.4183 16 12 16C7.58172 16 4 14.2091 4 12" stroke="#ffffff" stroke-width="2"/>
      <path d="M4 7V17C4 19.2091 7.58172 21 12 21C16.4183 21 20 19.2091 20 17V7" stroke="#ffffff" stroke-width="2"/>
    </svg>
    WorkshopDB
  </h1>
  <p><strong>A workshop / car repair shop management application built with Spring Boot & Thymeleaf.</strong></p>
  <p><em>Aplikacija za upravljanje automehaničarskom radionicom.</em></p>
</div>

<div align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.0-6DB33F?style=flat&logo=springboot&logoColor=white" alt="Spring Boot 4.1.0">
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat&logo=mysql&logoColor=white" alt="MySQL 8.0">
  <img src="https://img.shields.io/badge/Bootstrap-5.3.3-7952B3?style=flat&logo=bootstrap&logoColor=white" alt="Bootstrap 5.3.3">
  <img src="https://img.shields.io/badge/Thymeleaf-3.1.5-005F0F?style=flat&logo=thymeleaf&logoColor=white" alt="Thymeleaf 3.1.5">
  <img src="https://img.shields.io/badge/License-GPLv3-blue.svg" alt="License: GPL v3">
</div>

---

## Table of Contents / Sadržaj

- [English](#eng)
  - [Features](#features)
  - [Screenshots](#screenshots)
  - [Tech Stack](#tech-stack)
  - [Run Locally](#run-locally)
  - [AI Assistant](#ai-assistant)
- [Hrvatski](#hrv)
  - [Značajke](#značajke)
  - [Screenshotovi](#screenshotovi)
  - [Tehnologije](#tehnologije)
  - [Lokalno pokretanje](#lokalno-pokretanje)
  - [AI asistent](#ai-asistent)
- [License / Licenca](#license--licenca)

---

# ENG

**WorkshopDB** is a web application for managing a car repair workshop. It provides CRUD operations for clients, cars, mechanics, and repair history, plus an AI assistant powered by OpenRouter.

## Features

- **Clients** — Add, edit, view, and delete clients; view all cars owned by a client
- **Cars** — Add, edit, and list cars with full specs (engine, VIN, year, mileage, kW)
- **Mechanics** — Manage mechanics and view their repair history
- **Repair History** — Log repairs with dates, titles, descriptions, and prices
- **AI Assistant** — Ask natural-language questions about your workshop data (powered by OpenRouter)
- **Responsive UI** — Bootstrap 5.3.3, mobile-friendly navbar

## Screenshots

<div style="overflow-x:auto;">
<table style="width:100%; border-collapse:collapse;">

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/home.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Home page">
  <br><em>Home page — dashboard overview</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/clientList.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Client list">
  <br><em>Client list — all registered clients</em>
</td>
</tr>

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/clientInfo.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Client info">
  <br><em>Client info — details + owned cars</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/carList.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Car list">
  <br><em>Car list — all cars in the workshop</em>
</td>
</tr>

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/mechanicList.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Mechanic list">
  <br><em>Mechanic list — workshop staff</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/mechanichRepairInfo.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Mechanic repair info">
  <br><em>Mechanic repair info — repairs per mechanic</em>
</td>
</tr>

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/specificRepairHistory.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Repair history">
  <br><em>Repair history — full log of all repairs</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/AiScreen.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="AI assistant">
  <br><em>AI assistant — ask questions about your data</em>
</td>
</tr>

</table>
</div>

## Tech Stack

| Technology     | Version  |
|----------------|----------|
| Java           | 17       |
| Spring Boot    | 4.1.0    |
| Spring MVC     | —        |
| Spring Data JPA | —       |
| Thymeleaf      | 3.1.5    |
| Bootstrap      | 5.3.3    |
| MySQL          | 8.0      |
| Lombok         | —        |
| OpenRouter API | —        |

## Run Locally

```bash
git clone https://github.com/MarioBarisa/WorkshopDB.git
cd WorkshopDB
```

> **Prerequisite:** MySQL 8.0 running on `localhost:3306`, database `WorkshopDB` with user `root` / password `12345678`. You can change this if needed.

```bash
./mvnw spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080).

### AI Assistant

To use the AI assistant, create ( Use OpenRouter or any other API provider of choice. ) `application-local.properties` in `src/main/resources/`: 

```properties
openrouter.api.key=sk-or-v1-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
openrouter.api.url=https://openrouter.ai/api/v1/chat/completions
```

---

# HRV

**WorkshopDB** je web aplikacija za upravljanje automehaničarskom radionicom. Omogućuje CRUD operacije nad klijentima, automobilima, mehaničarima i povijesti popravaka, te AI asistenta pokretanog putem OpenRoutera.

## Značajke

- **Klijenti** — Dodavanje, uređivanje, pregled i brisanje klijenata; pregled svih automobila klijenta
- **Automobili** — Dodavanje, uređivanje i pregled automobila s kompletnim specifikacijama (motor, VIN, godina, kilometraža, kW)
- **Mehaničari** — Upravljanje mehaničarima i pregled njihove povijesti popravaka
- **Povijest popravaka** — Evidencija popravaka s datumom, naslovom, opisom i cijenom
- **AI asistent** — Postavljajte pitanja prirodnim jezikom o podacima u radionici (pokreće OpenRouter)
- **Responzivno sučelje** — Bootstrap 5.3.3, mobilno prilagođena navigacija

## Screenshotovi

<div style="overflow-x:auto;">
<table style="width:100%; border-collapse:collapse;">

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/home.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Početna stranica">
  <br><em>Početna stranica — pregled radionice</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/clientList.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Popis klijenata">
  <br><em>Popis klijenata — svi registrirani klijenti</em>
</td>
</tr>

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/clientInfo.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Informacije o klijentu">
  <br><em>Informacije o klijentu — detalji + automobili</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/carList.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Popis automobila">
  <br><em>Popis automobila — svi automobili u radionici</em>
</td>
</tr>

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/mechanicList.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Popis mehaničara">
  <br><em>Popis mehaničara — osoblje radionice</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/mechanichRepairInfo.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Informacije o popravcima mehaničara">
  <br><em>Popravci mehaničara — pregled po mehaničaru</em>
</td>
</tr>

<tr>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/specificRepairHistory.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="Povijest popravaka">
  <br><em>Povijest popravaka — kompletna evidencija</em>
</td>
<td style="text-align:center; padding:10px; border:1px solid #ddd;">
  <img src="https://github.com/MarioBarisa/WorkshopDB/blob/main/screenshots/AiScreen.jpg?raw=true" style="width:100%; max-width:450px; height:auto; border-radius:6px;" alt="AI asistent">
  <br><em>AI asistent — postavljajte pitanja o podacima</em>
</td>
</tr>

</table>
</div>

## Tehnologije

| Tehnologija     | Verzija  |
|-----------------|----------|
| Java            | 17       |
| Spring Boot     | 4.1.0    |
| Spring MVC      | —        |
| Spring Data JPA | —        |
| Thymeleaf       | 3.1.5    |
| Bootstrap       | 5.3.3    |
| MySQL           | 8.0      |
| Lombok          | —        |
| OpenRouter API  | —        |

## Lokalno pokretanje

```bash
git clone https://github.com/MarioBarisa/WorkshopDB.git
cd WorkshopDB
```

> **Preduvjet:** MySQL 8.0 pokrenut na `localhost:3306`, baza `WorkshopDB`, korisnik `root` / lozinka `12345678`. Ovo možete promjeniti ukoliko je potrebno.

```bash
./mvnw spring-boot:run
```

Otvori [http://localhost:8080](http://localhost:8080).

### AI asistent

Za korištenje AI asistenta, kreiraj ( koristite OpenRouter ili bilo koji druig API poslužitelj ) `application-local.properties` u `src/main/resources/`: 

```properties
openrouter.api.key=sk-or-v1-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
openrouter.api.url=https://openrouter.ai/api/v1/chat/completions
```

---

## License / Licenca

[GNU General Public License v3.0](LICENSE)
