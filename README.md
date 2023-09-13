# PlaywrightUI
UI Automation using Playwright

# Command to record the actions and generate the automation script
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://automationintesting.online/"

# To enable debug mode, set below parameter in run configuration
PWDEBUG=1
