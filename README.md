
# Application for the registration of medical records of a clinic

![](https://i.ibb.co/6nTBjDD/1.jpg)


![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) ![](https://img.shields.io/github/release/pandao/editor.md.svg) ![](https://img.shields.io/github/issues/pandao/editor.md.svg) ![](https://img.shields.io/bower/v/editor.md.svg)


**Table of Contents**

[TOCM]

[TOC]

#Justification

Although we know that the clinics have a management that allows them to store medical records, however, as mentioned above, due to the state in which our health system is located, it has been a major battle to obtain the efficiency that is needs to.
Although the situation has been progressively complicated, it obtained a huge increase due to the outbreak of the disease within our territory. Consequently, while the number of infected grows in our capital, Covid-19 spread throughout the country, reaching even to remote places where the only help center is a “post.” Although before the quarantine this care center had a maximum of 7 people, during the current problem they were not enough to reach all the citizens who come to the establishment. In addition, it was affected by the lack of trained personnel to record medical records; consequently, there is a deficiency, which even affected decision-making by doctors.

##Target
The general objective is to implement an application that allows the registration of a patient's clinical history in order to streamline the care process in medical posts.
###Our system contains
**1** Allow the modification and deletion of the registered data, in order to control the registration of the clinical history.

------------


**2** .Improve the obtaining of data from the clinical history for its eventual use in medical

------------

**3** .posts through a system that allows the visualization of the recorded data.

------------


**4**.Manage the information obtained through a database, which will be implemented in order to improve the system.

------------


**5**.Develop interfaces that allow access for each person in charge of said medical post, depending on the functions that each one needs to execute in the application.

------------


**6**.Develop an interface that contains the generator of the clinical history of each patient, to facilitate the report of each one of them.

------------


**7**.Authorization to the respective manager so that he can register or eliminate a worker from the medical post so that he can use the software, storing his information in the database implemented in the system.

------------
####Limitations
The spaces will be defined, described and shown without considering dimensions, specifications, costs, adaptation and identity image.
It is not intended to create a cataloging or classification of patients who have a major or minor accident.
The review of patient data may only be reviewed by those who are at the same medical post
####INSTALLATION

After cloning the repository, you should open the .jar from the Netbeans IDE `<Netbeans 12.5>` (all versions).

    
When trying to open it, an error will be presented, which mentions the lack of libraries.
All the libraries used are included in the project, therefore, to solve the error, the libraries must be selected according to their name and location: in this case they are:
**1. mysql-connector-java-8.0.27**
**2. RSScaleLabel**
**3. jcalendar-1.4**
    
![](https://i.ibb.co/6DDcz2Q/2.jpg)


####MySQL　
### Create in PhpMyAdmin
We will create a Database called System, where we will include two tables: historias and usuarios
####Table historias
```sql
CREATE TABLE historias(
	codigo varchar(10) NOT NULL primary Key,
	fecha VARCHAR(50) NULL,
	dni VARCHAR(50) NULL,
	sexo VARCHAR(50) NULL,
	apellido VARCHAR(50) NULL,
	nomrbes VARCHAR(50) NULL,
	tipodesangre VARCHAR(50) NULL,
	edad VARCHAR(50) NULL,
	ocupación VARCHAR(50) NULL,
	fechadenacimiento  VARCHAR(50) NULL,
	estadocivil VARCHAR(50) NULL,
	nacionalidad VARCHAR(50) NULL,
	residenciaactual VARCHAR(50) NULL,
	gradodeintruccion VARCHAR(50) NULL,
	horadellegada VARCHAR(50) NULL,
	motivodeconsulta VARCHAR(50) NULL,
	antecedentes VARCHAR(50) NULL,
	internacion  VARCHAR(50) NULL,
	diagnostico VARCHAR(50) NULL,
	derivacion VARCHAR(50) NULL,
	medicacion VARCHAR(50) NULL,
	instrucciones VARCHAR(50) NULL,
	recomendaciones VARCHAR(50) NULL
);
SELECT * FROM historias;
INSERT INTO historias VALUES('C001','PACIENTE','PACIENTE','A','B','7','3','2900.00','a','b','c','d','e','f','g','h','y','j','k','m','l','m','n');
```

####Table Usuarios

```sql
CREATE TABLE usuarios(
	id VARCHAR(50)  NULL ,
	nombre VARCHAR(50) NULL,
	apellidos VARCHAR(50) NULL,
	email VARCHAR(50) NULL,
	username VARCHAR(50) NULL,
	pass VARCHAR(50) NULL
);
SELECT * FROM usuarios; 


INSERT INTO usuarios VALUES('1','Andres','Rangel','mi_correo@gmail.com','admin','admin#0');
```
                
###FlowChart

```flow
st=>start: Login
op=>operation: Login operation
cond=>condition: Successful Yes or No?
e=>end: To admin

st->op->cond
cond(yes)->e
cond(no)->op
```
![](https://i.ibb.co/XYwmKqq/3.jpg)
![](https://i.ibb.co/RbhNQMB/5.jpg)

![](https://i.ibb.co/QKRZxwW/6.jpg)
![](https://i.ibb.co/5cb4sxS/7.jpg)
![](https://i.ibb.co/LJfhCZJ/8.jpg)
###End
