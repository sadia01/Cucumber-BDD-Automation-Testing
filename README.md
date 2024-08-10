# Cucumber Automation Testing Framework

## Overview
This repository contains a comprehensive automation framework built to test two primary features of an e-commerce application:

1. **Search Product** - Validates if products searched on the homepage are available on the offers page.
2. **Checkout** - Verifies the checkout process including adding items to the cart, validating the checkout page, and applying promo codes.

The framework leverages Cucumber for Behavior-Driven Development (BDD), TestNG for test execution, and the Page Object Model (POM) for code organization.

## Features

### 1. Search Product
**Objective:** Validate if products searched on the homepage appear in the offers page.

**Steps:**
1. Land on the homepage.
2. Search for products using short names (e.g., `tom` for `tomato`, `beet` for `beetroot`).
3. Navigate to the offers page (opened as a child window).
4. Check if the searched products are available in the top deals on the offers page.
5. Validate if products found on both pages match.

**Example:**
- Searching for `tom` should return `true` if found on both pages, indicating a test pass.
- Searching for `beet` should return `false` if not found on the offers page, indicating a test failure.

### 2. Checkout
**Objective:** Verify the checkout process including adding items to the cart, validating details on the checkout page, and applying a promo code.

**Steps:**
1. Land on the homepage.
2. Search for a product using short names.
3. Add 3 units of the found product to the cart.
4. Proceed to checkout.
5. Validate that the product details match those on the homepage.
6. Verify the functionality of entering a promo code and placing the order.

## Project Structure

1. **`pageobject`:**
   - Contains page factory classes for `LandingPage`, `CheckoutPage`, `OffersPage`, and `PageObjectManager`.

2. **`utils`:**
   - `TextContextSetup`: Manages shared objects and driver initialization.
   - `BaseTest`: Manages global properties and browser initiation. Configurable via Maven terminal commands.
   - `GenericUtils`: Contains reusable code, such as switching to child windows.

3. **`stepdefinitions`:**
   - Includes step definition files for `searchProduct` and `checkout` features, divided into:
     - `LandingPage`
     - `CheckoutPage`
     - `OffersPage`
   - Contains hooks for test lifecycle management (e.g., quitting the driver, setting screenshot paths for failed tests).

4. **`CucumberOptions`:**
   - **`TestRunner`**: Configures TestNG to run Cucumber tests with feature file paths, tags, and plugins. Generates Extent, HTML, and JSON reports. Uses Extent adapter and extends `AbstractTestNGCucumberTests` for TestNG integration. Utilizes DataProvider for handling multiple datasets.
   - **`FailedTestRunner`**: Produces `failedScenario.txt` to identify failed tests.

5. **`Resources`:**
   - **Global Property**: Stores browser name and QA URL.
   - **Extent Property**: Configures extent reporting.
