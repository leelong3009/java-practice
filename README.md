# java-core
### java concurrency series
http://www.baptiste-wicht.com/2010/05/java-concurrency-part-1-threads/ 
http://www.baptiste-wicht.com/2010/05/java-concurrency-part-2-manipulate-threads/ 
http://www.baptiste-wicht.com/2010/08/java-concurrrency-synchronization-locks/ 
http://www.baptiste-wicht.com/2010/08/java-concurrency-part-4-semaphores/ 
http://www.baptiste-wicht.com/2010/09/java-concurrency-part-5-monitors-locks-and-conditions/ 
http://www.baptiste-wicht.com/2010/09/java-concurrency-atomic-variables/ 
http://www.baptiste-wicht.com/2010/09/java-concurrency-part-7-executors-and-thread-pools/ 

### java concurrency in practice source code
http://jcip.net.s3-website-us-east-1.amazonaws.com/listings.html

### Java Thread Safety
Thread safety is the process to make our program safe to use in multithreaded environment, there are different ways through which we can make our program thread safe.

- Synchronization is the easiest and most widely used tool for thread safety in java.
- Use of Atomic Wrapper classes from java.util.concurrent.atomic package. For example AtomicInteger
- Use of locks from java.util.concurrent.locks package.
- Using thread safe collection classes, check this post for usage of ConcurrentHashMap for thread safety.
- Using volatile keyword with variables to make every thread read the data from memory, not read from thread cache.

### Exception & Error
![](https://raw.githubusercontent.com/leelong3009/java-core/master/Exception_Classes.png)

1. Error:
	- Indicates the serious problems that reasonable application should not try to catch.
	- It's bad idea to use `try-catch` clause for Errors. Most often, recovery from Error is **not possible**, the application should be allowed to **terminate**. (OutOfMemoryError, StackOverFlowError).
2. Exceptions
	- Indicates conditions that a reasonable application might want to catch
	- Checked exception a generally those from which a program can recover. (FileNotFoundException...)
	- Unchecked exception are those exceptions that might not happen if everything is in order, but they do occur (ArrayIndexOutOfBoundException...)
	- RunTimeException & Error are consider as unchecked exception.
	- RunTimeException could be handled in code but it's not required. It's usually caused by bad programming.
	
### Java build path vs classpath
http://www.ntu.edu.sg/home/ehchua/programming/howto/environment_variables.html
- Classpath is a parameter in the Java Virtual Machine or the Java compiler that specifies the location of user-defined classes and packages.
- The build path is used for building your application. It contains all of your source files and all Java libraries that are required to compile the application.