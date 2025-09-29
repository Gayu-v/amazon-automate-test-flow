# Amazon Automation Framework (Selenium + TestNG + POM)

## Overview
This project is a **Selenium WebDriver automation framework** built using:
- **Java**
- **TestNG** for test execution
- **Page Object Model (POM)** design pattern
- **Maven** for build and dependency management

The framework automates a simple flow on **Amazon.in**:
1. Login to Amazon
2. Search for a product
3. Select and add product to cart
4. Update quantity
5. Verify price calculation in the cart

---

##  Project Structure

src/test/java
├── base
│ └── BaseTest.java # Browser setup & teardown
├── pages # Page Object classes
│ ├── LoginPage.java # Handles login actions
│ ├── HomePage.java # Handles search and homepage actions
│ ├── SearchResultsPage.java # Handles product selection
│ └── CartPage.java # Handles cart actions & price assertion
└── tests
└── AmazonTest.java # End-to-end test flow
