# README
## About project
#### Automated tests for website: https://demoqa.com/
##### All tests were implemented by Kacper Pelc

## About me
##### Github: https://github.com/kacperpelc
##### LinkedIn: https://www.linkedin.com/in/kacperpelc/

## Used technologies:
* Java 11
* Maven
* Selenium 4
* JUnit 5
* RestAssured

## To run all tests in chrome without close after test:
> mvn clean test

## To run single test:
> mvn clean test -P browser -P close -D"groups=number"

where:
- browser stands for browser name: **chrome** or **edge**
- **close** stands for close browser after each test (empty if not)
- number stands for **@Tag()**, for example:
> mvn clean test -P **edge** -D"**groups=111**"

or

> mvn clean test -P **chrome** -P **close** -D"groups=**elements**"

## By default:
- chromedriver
- browser isn't closed after
- screenshots on fails
- red borders around found elements

## TODO:
- implement firefoxDriver
- implement selenium grid 4
- improve profiles in maven
- improve logs
- implement reports, eg. allure


