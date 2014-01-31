DEVMAIL
=======

Local loopback mail server for developers. It supports SMTP, POP3 and IMP.

HOW TO USE
----------

java -cp target/devmail.jar <appId> <params>
where 
	<appId> : gs.mail.server  OR gs.mail.smtp
	<params> : parameters can be retrieved by 
		java -cp path/devmail.jar gs.mail.server -h
		java -cp path/devmail.jar gs.mail.smtp -h


EXAMPLE GS.MAIL.SERVER:
-----------------------
Get help:
```
	java -cp path/devmail.jar gs.mail.server -h
```	
Run SMTP & POP3 & IMA loop back server at standard ports
```
	sudo java -cp path/devmail.jar gs.mail.server 
```	
   Note that: you need to run with root user in order to bind to low port number

Run SMTP & POP3 & IMA loop back server at specific port
```
	sudo java -cp path/devmail.jar gs.mail.server -p 8000
```	
   Port number = standard + 8000 (ex: POP3 listen at port 8025, SMTP listen at port 8110)

EXAMPLE GS.MAIL.SMTP:
---------------------
Get help:
```
	java -cp path/devmail.jar gs.mail.smtp -h
```	

Send a message:
```
	java -cp path/devmail.jar gs.mail.smtp 
```	
   Send a default message to SMTP server local host at port 25

Send a message:
```
	java -cp path/devmail.jar gs.mail.smtp -host localhost -p 8025 -s "Subject" -b "You have a new mail"
```	
   Send message "You have a new mail" to port 25 at local host
 
