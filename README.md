# CafeManagement
This is SpringBoot application, which consists of 3 modules (business, manager_web, waiter_web),
 with application.yml config file in manager_web and waiter_web modules, where the following database settings are given:

Database name: cafe_manager
Database username: root
Database password:

To run manager_web, use port 8088
To run waiter_web, use port 8089

There are web security configs given for both manager_web and waiter_web.
Manager login page: localhost:8088/login
Waiter login page: localhost:8089/login

There is ApplicationStartupRunner class in manager_web module's util package, where one single manager initially created
with following initials:
username: manager
password:pwd
