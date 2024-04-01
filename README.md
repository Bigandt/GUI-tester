# Application XYZ GUI test

Lorem ipsum dolor sit amet

# How to run on the local environment

Go to class com.company.appxyz.test.gui.RunEndToEndCukeTest and run from IntelliJ with Play button.

# Framework documentation

## Description and instruction

https://www.swtestacademy.com/selenium-spring-boot-cucumber-junit5-project

# How to use template

### Refactor steps

1. Copy folder containing project and name it something like application-xyz-gui-test
2. Refactor packages in src and test from com.company.appxyz
3. Refactor cucumber-package in test 'com.company.appxyz.test.gui.cucumber.appxyz' 
4. Refactor pages-package in test 'com.company.appxyz.test.gui.pages.appxyz'
5. Refactor folder 'src\test\resources\features\appxyz'

### Create tests

1. Create a class for each page in the application in refactored package 'pages.appxyz'
2. Create a StepDefs-class for each page in the application in refactored package 'cucumber.appxyz'
3. Create tests in refactored 'test\resources\features\appxyz'

# Improvements todo

- @TakeScreenshot does not seem to work
- @ElapsedTime does not seem to work 
- Use different browsers (not tested)
- Use Extensions for browser
- Generate reports
- Logging

