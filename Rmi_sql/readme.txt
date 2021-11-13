javac *.java
rmic CentralIMPL
rmiregistry | java -Djava.security.policy=java.policy -cp ".:sqlite-jdbc-3.30.1.jar" Server -> (Dans un autre terminal) 
java Client 1(n°capteur)  2000(Freq d'aquisition en ms) -> (Dans un autre terminal)
java ClientTerminal 1(n°terminal) -> (Dans un autre terminal)
