# Cucumber Automation Testing Framework
# Overview
This repository contains a framework designed to test two main features:

# 1. searchProduct
# 2. Checkout
The framework utilizes Cucumber for Behavior-Driven Development (BDD), TestNG for test execution, and Page Object Model (POM) for organizing code.

# Features
# 1. searchProduct
Objective: Validate if the products searched on the homepage are available in the offers page.
Steps:
1. Land on the homepage.
2. Search for products using short names (e.g., tom for tomato, beet for beetroot).
3. Navigate to the offers page (opened as a child window).
4. Check if the searched products are available in the top deals on the offers page.
5. Validate if products found on both pages match.

Example:

tom should return as true if found in both pages hence Test passed
beet should return as false if not found in the offers page hence Test failed. 

# 2. Checkout
Objective: Verify the checkout process including the addition of items to the cart, validation on the checkout page, and the ability to enter a promo code.
Steps:
1. Land on the homepage.
2. Search for a product using short names.
3. Add 3 units of the found product to the cart.
4. Proceed to checkout.
5. Validate that the product details match those on the homepage.
6. Verify the functionality of entering a promo code and placing the order.

# Project Structure

1. pageobject:
Contains page factory classes for LandingPage, CheckoutPage, OffersPage, and PageObjectManager.
2. utils:
TextContextSetup: for sharing objects and managing driver initialization.
BaseTest: Manages global properties and browser initiation. Configurable via Maven terminal commands.
GenericUtils: Contains resusable code like switching to child window.
3. stepdefinitions:
Includes step definition files for searchProduct and checkout features which will be divided into 3 step definition file such as - LandingPage, CheckoutPage, OffersPage.
Contains hooks for test lifecycle management (e.g., quitting the driver, setting screenshot paths for failed tests).
4. CucumberOptions::
TestRunner for configuring TestNG and running Cucumber tests.
1. TestNGTestRunner 
Configures TestNG runner with feature file paths, tags, and plugins.
Generates Extent, HTML and JSON reports.
Uses Extent adapter and extends parent class AbstractTestNGCucumberTests to run using TestNG
Utilizes DataProvider for handling multiple datasets.
3. FailedTestRunner
Produces a failedScenario.txt to identify failed tests.
5. Resources
Here global property and extent property and necessary browser drivers will be stored.
1. Global Property - Contains browser name and QAURL
2. Extent Property - To generate extent report
