cd devmail
mvn clean install assembly:single
echo 
echo
echo "-----------"
echo "HOW TO USE:"
echo "-----------"
echo 
echo "Get help: java -cp target/devmail.jar gs.mail.server -h"
echo "Get help: java -cp target/devmail.jar gs.mail.smtp -h"

echo "java -cp devmail/target/devmail.jar gs.mail.server"
echo "java -cp devmail/target/devmail.jar gs.mail.smtp"

