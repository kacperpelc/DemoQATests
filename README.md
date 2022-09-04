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

## To run regression:
> mvn clean test

## To run single test:
> mvn clean test -D"groups=number"

where number stands for **@Tag()**, for example:
> mvn clean test -D"groups="111"

## By default:
- chromedriver
- local

## TODO:
- implement another WebDrivers: firefoxdriver, edgedriver
- implement headless test run
- implement selenium grid 4
- implement maven profiles, for example 
- implement screenshot making after test fail
- improve logs


