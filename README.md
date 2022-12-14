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
* Selenium4
* JUnit5
* RestAssured

## To run all tests in chrome without close after test and with graphical display:
> mvn clean test

## To run single test:
> mvn clean test -P browser -P close -P headless -D"groups=number"

where:
- browser stands for browser name: **chrome** or **edge**
- **close** stands for close browser after each test (empty if not)
- **headless** stands for non-graphical display (empty if not)
- number stands for **@Tag()**, for example:
> mvn clean test -P **edge** -P **headless** -D"**groups=111**"

or

> mvn clean test -P **chrome** -P **close** -D"groups=**elements**"

## By default:
- chromedriver
- close browser after tests
- real browser display

## TODO:
- implement firefoxDriver
- implement selenium grid 4
- implement screenshot making after test fail
- improve profiles in maven
- improve logs


