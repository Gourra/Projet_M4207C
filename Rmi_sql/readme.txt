javac *.java
rmiregistry | java -Djava.security.policy=java.policy -cp ".:sqlite-jdbc-3.30.1.jar" Server

Dans un autre terminal :
java Client <n°capteur>  <Freq d'actualisation en ms>
ex : #java Client 1 3000

Dans un autre terminal :
java ClientTerminal <n°terminal>
ex : #java ClientTermianl 1
