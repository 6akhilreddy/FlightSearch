# FlightSearch
Allow you to search the flights between two places

This is a Desktop Application where the user provides From, To and Date of his travel and the application search for all flights in that route and displays the flight image, name, departureTime, arrivalTime, etc., It allows user to select the flight, reserve the ticket for number of people specified by the user checking the database for available seats and upload the data to the database. There is an AdminPanel where admin can upload the flight details.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Prerequisites

1.Java

2.Eclipse IDE

3.ojdbc6.jar,ojdbc14.jar

4.oracle database(oracle 11g prefered)

## Installing

A step by step series of examples that tell you how to get a development environment running

1.clone the repository to your eclipse IDE

2.Add ojdbc6.jar,ojdbc14.jar to your classpath

3.Open the oracle database and create two tables

```
1.create table flight(fid varchar2(10) primary key,fname varchar2(50),source varchar2(50),destination varchar2(50),starttime varchar2(10),endtime varchar2(10),nos number(5),price number(10),Image blob);

2.create table reserved(fid varchar2(10),uname varchar2(50),email varchar2(50),ddate varchar2(10),amount number(10),noseats number(5),phno varchar2(10),CONSTRAINT fk FOREIGN KEY (fid) REFERENCES flight(fid));
```
4.Change the Database configurations(username,password) in all the files before you start with the application.

```
1.Adminadd.java/ line-267

2.ViewPassenger.java/ line-54

3.DeleteFlights.java/ line-52,line-235

4.Home.java/ line-157

5.View.java/ line-50

6.BookFlight.java/ line-137,line-293
```
5.Run Adminadd.java file in Eclipse IDE to upload the flight details to the database.

6.Run Home.java File in Eclipse IDE for actual Application.

## Built With
* Java Swings

![img1](https://user-images.githubusercontent.com/31363761/42859984-dea4a108-8a72-11e8-9ae4-0595d6f3c615.png)

![img6](https://user-images.githubusercontent.com/31363761/42859985-deda2134-8a72-11e8-9a02-0fcbdc92f282.png)

![img7](https://user-images.githubusercontent.com/31363761/42859986-df13c89e-8a72-11e8-93d1-2245ab31b284.png)

![img8](https://user-images.githubusercontent.com/31363761/42859988-df4add5c-8a72-11e8-829a-ae3e4fe6919b.png)

![img9](https://user-images.githubusercontent.com/31363761/42859989-df7fd200-8a72-11e8-96df-5df284bde25f.png)

![img10](https://user-images.githubusercontent.com/31363761/42859990-dfb704be-8a72-11e8-9c38-269f682c8ccc.png)

![img12](https://user-images.githubusercontent.com/31363761/42859991-dfee9186-8a72-11e8-9d02-cad8991cfe6d.png)
