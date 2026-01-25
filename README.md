# AI-Assisted Selenium Automation Framework – Login Testing (POM)

![Java](https://img.shields.io/badge/Java-21-blue) ![Selenium](https://img.shields.io/badge/Selenium-4.40.0-green) ![TestNG](https://img.shields.io/badge/TestNG-7.9.0-orange) ![Automation](https://img.shields.io/badge/QA-Automation-blueviolet)

---

## 🚀 Project Overview

This project is a **real-world AI-assisted Selenium Automation Framework** developed using **Java, Selenium 4, TestNG, and Page Object Model (POM)**.

It automates the **login functionality** of a **public practice website** ([Practice Test Automation Login](https://practicetestautomation.com/practice-test-login/)) with **positive and negative scenarios**, focusing on **stability, intelligence, and reliability**, rather than just script execution.

This framework is designed for **professional QA automation practice** and showcases hands-on skills that recruiters look for in automation candidates.

---

## 🧠 AI-Assisted Intelligence

While not ML-based, this framework is **AI-assisted** because it makes **smart runtime decisions** that simulate human-like test behavior:

- **Smart Explicit Waits** – dynamic waits based on element readiness
- **Decision-Based Validations** – automatically detects login success or failure
- **Safe Element Handling** – prevents stale element crashes
- **Self-Recovery** – retry logic for page navigation
- **Automatic Screenshots** – captures failures for debugging

These features demonstrate your ability to **write intelligent, maintainable, and robust automation scripts**, which recruiters highly value.

---

## ✅ Key Features

- **Page Object Model (POM)**: Clean separation of locators and actions for maintainable code
- **BaseTest Architecture**: Centralized browser setup, teardown, retries, and reporting
- **Intelligent Wait Utility**: Handles dynamic and unstable UI without test failure
- **Decision-Based Validation**: Automatically determines login success or failure
- **Positive & Negative Test Coverage**:
  - Valid Login
  - Invalid Username
  - Invalid Password

- **Failure Handling & Debug Support**: Auto screenshots on test failure
- **Git & GitHub**: Version control and clean project management

---

## 📂 Project Structure

```
SeleniumFramework/
 ├── pom.xml
 ├── src
 │   ├── main/java
 │   │   ├── base
 │   │   │   └── BaseTest.java
 │   │   ├── pages
 │   │   │   └── LoginPage.java
 │   │   └── utils
 │   │       └── WaitUtil.java
 │   └── test/java
 │       └── tests
 │           └── LoginTest.java
 └── testng.xml
```

---

## ⚡ How to Run

1️⃣ Clone the repository

```bash
git clone https://github.com/<your-username>/SeleniumFramework.git
```

2️⃣ Open the project in **IntelliJ IDEA**
3️⃣ Ensure:

- Java 21 is installed
- Chrome browser is installed
- Selenium Manager handles ChromeDriver automatically

4️⃣ Run tests using:

- `testng.xml` OR
- Directly run `LoginTest.java`

---

## 🧪 Test Scenarios

**✔ Positive Test:**

- Login with valid credentials
- Verify successful login behavior

**❌ Negative Tests:**

- Invalid username
- Invalid password
- Error message verification

---

## 💡 Skills Demonstrated

- Java, Selenium WebDriver, TestNG, POM design pattern
- Intelligent wait strategies and failure recovery
- Automation of real-world public websites
- Version control using Git & GitHub
- QA methodologies: SDLC, STLC, Agile

---

## 🔗 Live Application Under Test

[Practice Test Automation – Login Page](https://practicetestautomation.com/practice-test-login/)

---
