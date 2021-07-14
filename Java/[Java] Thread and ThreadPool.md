# [Java] Thread and ThreadPool



### | Definition From WiKi 

```
Thread : 

In CS, a thread of execution is the smallest sequence of programming instructions that can be managed independently by a scheduler, which is typically a part of the OS. The implementation of threads and processes differs between operating systems, but in most cases a thread is a component of a process. Multiple Threads can exists within one process, executing concurrently and sharing resources such as memory, while different processes do not share these resources. In particular, the threads of a process share its executable code and the values of its dynamically allocated variables and non-thread-local global variables at any given time. 
```

```
Thread pool : 

In CS, a thread pool is a software design pattern for achieving concurrency of execution in a computer program. Often also called a replicated workers or worker-crew model, a threadpool maintains multiple wating for tasks to be allocated for concurrent execution by the supervising program. By maintaining a pool of threads, the model increases performance and avoids latency(대기시간) in execution due to frequent creation and destruction of threads for short-lived tasks. The number of available threads is tuned to the computing resources available to the program, such as a parellel task queue after completion of execution. 

-위키 백과- 
```

### | How Thread pool work?







### | Reference 

https://www.baeldung.com/thread-pool-java-and-guava

