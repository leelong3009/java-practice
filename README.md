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
