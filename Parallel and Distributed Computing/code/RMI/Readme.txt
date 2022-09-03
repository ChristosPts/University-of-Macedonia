$ javac rmi/Interface/*.java
$ javac rmi/Client/*.java
$ javac rmi/Server/*.java
$ java rmi.Server.AdditionServer 

Another terminal
$ java rmi.Client.AdditionClient 

