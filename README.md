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

## To run all tests in chrome:
> mvn clean test

## To run single test:
> mvn clean test -P browser -D"groups=number"

where:
- name stands for browser's name, currently supported: **chrome** and **edge**
- number stands for **@Tag()**, for example:
> mvn clean test -P chrome -D"groups="111"

## By default:
- chromedriver
- local
- close browser after tests

## TODO:
- implement firefoxDriver
- implement headless test run
- implement to choose close browser or not
- implement selenium grid 4
- implement screenshot making after test fail
- improve profiles in maven
- improve logs


