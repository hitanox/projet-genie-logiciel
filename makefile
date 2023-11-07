	
all: 
	mvn package
	java -cp target/Panier-1.0-SNAPSHOT-jar-with-dependencies.jar fr.ufrsciencestech.panier.Main

allNoTests:
	mvn package -DskipTests
	java -cp target/Panier-1.0-SNAPSHOT-jar-with-dependencies.jar fr.ufrsciencestech.panier.Main
