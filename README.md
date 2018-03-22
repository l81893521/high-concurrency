# high-concurrency
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
1.
