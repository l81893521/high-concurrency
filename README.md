# high-concurrency(高并发知识概括)
### Atomic包
[概括说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/package-info.java)

1.[atomicInteger](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/AtomicExample1.java)

2.[atomicLong](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/AtomicExample2.java)

3.[longAdder](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/AtomicExample3.java)

4.[atomicReference](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/AtomicExample4.java)

5.[atomicIntegerFieldUpdater](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/AtomicExample5.java)

6.[atomicBoolean](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/atomic/AtomicExample6.java)

### Synchronized
[概括说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/sync/package-info.java)

1.[修饰代码块和方法](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/sync/SynchronizedExample1.java)

2.[修饰类和静态方法](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/sync/SynchronizedExample2.java)

### 发布与逸出
[概括说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/publish/package-info.java)

1.[非安全发布](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/publish/UnsafePublish.java)

2.[逸出](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/publish/Escape.java)

### 安全发布与注意事项
[概括说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/package-info.java)

1.[单例模式-懒汉, 非线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample1.java)

2.[单例模式-饿汉, 线程安全并且描述缺点](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample2.java)

3.[单例模式-懒汉, 线程安全, 但是不推荐写法](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample3.java)

4.[单例模式-懒汉, 由于指令重排导致的非线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample4.java)

5.[单例模式-懒汉, 线程安全, 解决由于指令重排导致的问题](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample5.java)

6.[单例模式-饿汉, 线程安全, 使用静态块需要主要的问题](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample6.java)

7.[单例模式-懒汉, 线程安全, 使用枚举来实现, 推荐写法](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/singleton/SingletonExample7.java)

### 线程安全策略
[概括说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/immutable/package-info.java)

1.[final的基本说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/immutable/ImmutableExample1.java)

2.[unmodifiable类的使用](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/immutable/ImmutableExample2.java)

3.[Immutable类的使用](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/immutable/ImmutableExample3.java)

4.threadLocal的使用

4.1[概括说明](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/threadLocal/package-info.java)

4.2[ThreadLocal](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/threadLocal/RequestHolder.java)

4.3[HttpFilter](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/HttpFilter.java)

4.4[HttpInterceptor](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/HttpInterceptor.java)

4.5[Controller](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/threadLocal/ThreadLocalController.java)

5.线程不安全的类与写法

5.1[StringBuilder, 线程不安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/StringExample1.java)

5.2[StringBuffer, 线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/StringExample2.java)

5.3[SimpleDateFormat, 线程不安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/DateFormatExample1.java)

5.4[SimpleDateFormat, 线程安全的写法](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/DateFormatExample2.java)

5.5[Joda Time, 线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/DateFormatExample3.java)

5.6[ArrayList, 线程不安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/ArrayListExample1.java)

5.7[HashSet, 线程不安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/HashSetExample1.java)

5.8[HashMap, 线程不安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/commonUnsafe/HashMapExample1.java)

6.同步容器

6.1[vector基本使用](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/VectorExample1.java)

6.2[同步容器并非线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/VectorExample2.java)

6.3[遍历集合注意事项](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/VectorExample3.java)

6.4[HashTable, 线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/HashTableExample1.java)

6.5[Collections.synchronizedList, 线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/CollectionsExample1.java)

6.6[Collections.synchronizedSet, 线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/CollectionsExample2.java)

6.7[Collections.synchronizedMap, 线程安全](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/syncContainer/CollectionsExample3.java)

7.并发容器

7.1[CopyOnWriteArrayList](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/concurrent/CopyOnWriteArrayListExample1.java)

7.2[CopyOnWriteArraySet](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/concurrent/CopyOnWriteArraySetExample1.java)

7.3[ConcurrentSkipListSet](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/concurrent/ConcurrentSkipListSetExample1.java)

7.4[ConcurrentSkipListMap](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/concurrent/ConcurrentSkipListMapExample1.java)

7.5[ConcurrentHashMap](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/concurrent/ConcurrentHashMapExample1.java)

### AQS(AbstractQueuedSynchronizer)
[概括描述](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/package-info.java)

[CountDownLatch使用方式1](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/CountDownLatchExample1.java)

[CountDownLatch使用方式2](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/CountDownLatchExample2.java)

[SemaphoreExample使用方式1](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/SemaphoreExample1.java)

[SemaphoreExample使用方式2](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/SemaphoreExample2.java)

[SemaphoreExample使用方式3](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/SemaphoreExample3.java)

[SemaphoreExample使用方式4](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/SemaphoreExample4.java)

[CyclicBarrierExample使用方式1](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/CyclicBarrierExample1.java)

[CyclicBarrierExample使用方式2](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/CyclicBarrierExample2.java)

[CyclicBarrierExample使用方式3](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/aqs/CyclicBarrierExample3.java)

### Locks
[概括描述](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/lock/package-info.java)

[Synchronized](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/lock/LockExample1.java)

[ReentrantLock](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/lock/LockExample2.java)

[ReentrantReadWriteLock](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/lock/LockExample3.java)

[StampedLock](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/lock/LockExample4.java)

[ReentrantLock and Condition](https://github.com/l81893521/high-concurrency/blob/master/src/main/java/com/will/highconcurrency/example/lock/LockExample5.java)
