javac *.java
rmic CentralIMPL
rmiregistry | java -Djava.security.policy=java.policy Server (Dans un autre terminal)
java Client
