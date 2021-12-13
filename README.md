# Dummy User App (Spring application)

## Installing the code

DummyUser is Spring Booth application built using Maven

	1. Either clone the project or download a zip to local directory
	2. Inside Eclipse/STS or IntelliJ
		File -> Import -> Maven -> Existing Maven project
		Then build the project: . Using the IDE right click
                         or ./mvnw generate-resources
	3. update the application properties and set he db props
	4. The application uses the following table in PDREP db
	      CREATE TABLE PDREP.DUMMYUSER (
		ID          NUMBER                            NOT NULL,
		FIRST_NAME  VARCHAR2(45 BYTE)                 NOT NULL,
		LAST_NAME   VARCHAR2(45 BYTE)                 NOT NULL,
		EMAILID     VARCHAR2(45 BYTE)
	      )
      	5. Run the DummyUserApplication
