# hangman-webapp
Simple Hangman Java REST Webapp example

Use the command "mvn -Dhangman.word=cat jetty:run" to run this app locally.
(You can substitute your favorite word for "cat".)
Then you can run the web client at the URL <http://localhost:8080/hangman.html>.

The [wiki](https://github.com/sorenlassen-csumb/hangman-webapp/wiki)
shows how to access the /rest/start and /rest/match endpoints, which
power the web client.

If you want to run the webapp on AWS Elastic Beanstalk,
build the war with "mvn package" and deploy it to the Tomcat platform.
You will need to set the hangman.word system property to cat
(or your favorite word) by going to the AWS app dashboard and go to

Configuration > Software Configuration > Environment Properties

and enter Property Name hangman.app, Property Value cat
and press Apply.
