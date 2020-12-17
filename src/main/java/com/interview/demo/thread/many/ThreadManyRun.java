package com.interview.demo.thread.many;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.concurrent.*;

public class ThreadManyRun {

    private static ThreadLocal threadLocal = new ThreadLocal();




        /**
         * ThreadPoolExecutor
         *
         * 1、newSingleThreadExecutor
         * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
         * 2、newFixedThreadPool
         * 创建一个固定数量,无边界的线程池，可控制线程最大并发数，超出的线程会在队列中等待。
         * 3、newScheduledThreadPool
         * 创建一个可定期或者延时执行任务的定长线程池，支持定时及周期性任务执行。
         * 4、newCachedThreadPoo
         * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
         */

        /**
         * 创建一个线程池，该线程池重用在共享的无边界队列中操作的固定数量的线程。
         * 在任何时候，{@codenthreads}线程最多将是活动的处理任务。
         * 如果在所有线程都处于活动状态时提交了其他任务，则它们将在队列中等待，直到有一个线程可用。
         * 如果任何线程在关闭之前的执行过程中由于失败而终止，则在需要执行后续任务时，将替换一个新线程。
         * 池中的线程将一直存在，直到显式地{@link ExecutorService#shutdown shutdown}。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        /**
         * 创建一个线程池，该线程池根据需要创建新线程，但在以前构建的线程可用时将重用这些线程。
         * 这些池通常会提高执行许多短期异步的程序的性能任务。
         * 通话to{@code execute}将重用以前构造的线程（如果可用）。
         * 如果没有可用的线程，将创建一个新线程并将其添加到池中。 60秒未使用的线程将被终止并从缓存中删除。
         * 因此，保持足够长时间空闲的池不会消耗任何资源。
         * 请注意，可以使用{@link ThreadPoolExecutor}构造函数创建具有类似属性但详细信息不同（例如超时参数）的池。
         */
//        Executors.newCachedThreadPool();
        /**
         * 创建一个线程池，该线程池可以安排命令在给定延迟后运行，或定期执行。
         */
        private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        /**
         * 创建一个执行器，该执行器使用单个工作线程在无界队列中操作。
         * （但是请注意，如果这个单线程在关闭之前的执行过程中由于失败而终止，则在需要执行后续任务时，将替换一个新线程。）
         * 保证任务按顺序执行，并且在任何给定的时间内不会有多个任务处于活动状态。
         * 与其他等价的{@code newFixedThreadPool（1）}不同的是，返回的执行器保证不会被重新配置以使用其他线程。
         */
//        Executors.newSingleThreadExecutor();
        /**
         * 创建一个单线程执行器，该执行器可以安排命令在给定延迟后运行，或定期执行。
         * （但是请注意，如果这个单线程在关闭之前的执行过程中由于失败而终止，则在需要执行后续任务时，将替换一个新线程。）
         * 保证任务按顺序执行，并且在任何给定的时间内不会有多个任务处于活动状态。
         * 与其他等价的{@code newScheduledThreadPool（1）}不同的是，返回的执行器保证不会被重新配置以使用其他线程。
         */
//        Executors.newSingleThreadScheduledExecutor();
        /**
         * 使用所有{@link Runtime#availableProcessors available processors}作为其目标并行级别，创建一个窃取工作的线程池。
         */
//        Executors.newWorkStealingPool();


        /**
         * 拒绝策略
         * 1. AbortPolicy ： 直接抛出异常，阻止系统正常运行。
         * 2. CallerRunsPolicy ： 只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。显然这样做不会真的丢弃任务，但是，任务提交线程的性能极有可能会急剧下降。
         * 3. DiscardOldestPolicy ： 丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试再次提交当前任务。
         * 4. DiscardPolicy ： 该策略默默地丢弃无法处理的任务，不予任何处理。如果允许任务丢失，这是最好的一种方案。
         */
        /**
         * Java 中的阻塞队列
         * 1. ArrayBlockingQueue ：由数组结构组成的有界阻塞队列。
         * 2. LinkedBlockingQueue ：由链表结构组成的有界阻塞队列。
         * 3. PriorityBlockingQueue ：支持优先级排序的无界阻塞队列。
         * 4. DelayQueue：使用优先级队列实现的无界阻塞队列。
         * 5. SynchronousQueue：不存储元素的阻塞队列。
         * 6. LinkedTransferQueue：由链表结构组成的无界阻塞队列。
         * 7. LinkedBlockingDeque：由链表结构组成的双向阻塞队列
         */

        /**
         * ArrayBlockingQueue ArrayBlockingQueue
         * 用数组实现的有界阻塞队列。此队列按照先进先出（FIFO）的原则对元素进行排序。默认情况下
         * 不保证访问者公平的访问队列，所谓公平访问队列是指阻塞的所有生产者线程或消费者线程，当
         * 队列可用时，可以按照阻塞的先后顺序访问队列，即先阻塞的生产者线程，可以先往队列里插入
         * 元素，先阻塞的消费者线程，可以先从队列里获取元素。通常情况下为了保证公平性会降低吞吐
         * 量。我们可以使用以下代码创建一个公平的阻塞队列：
         */
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(100);

        /**
         * LinkedBlockingQueue 两个独立锁提高并发
         * 基于链表的阻塞队列，同ArrayListBlockingQueue 类似，此队列按照先进先出（FIFO）的原则对
         * 元素进行排序。而LinkedBlockingQueue 之所以能够高效的处理并发数据，还因为其对于生产者
         * 端和消费者端分别采用了独立的锁来控制数据同步，这也意味着在高并发的情况下生产者和消费
         * 者可以并行地操作队列中的数据，以此来提高整个队列的并发性能。
         * LinkedBlockingQueue 会默认一个类似无限大小的容量（Integer.MAX_VALUE）。
         */
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();

        /**
         * PriorityBlockingQueue compareTo 排序实现优先
         * 是一个支持优先级的无界队列。默认情况下元素采取自然顺序升序排列。可以自定义实现
         * compareTo()方法来指定元素进行排序规则，或者初始化PriorityBlockingQueue 时，指定构造
         * 参数Comparator 来对元素进行排序。需要注意的是不能保证同优先级元素的顺序。
         */
        PriorityBlockingQueue<Object> priorityBlockingQueue = new PriorityBlockingQueue<>();

        /**
         * DelayQueue 缓存失效、定时任务
         * 是一个支持延时获取元素的无界阻塞队列。队列使用PriorityQueue 来实现。队列中的元素必须实
         * 现Delayed 接口，在创建元素时可以指定多久才能从队列中获取当前元素。只有在延迟期满时才
         * 能从队列中提取元素。我们可以将DelayQueue 运用在以下应用场景：
         * 1. 缓存系统的设计：可以用DelayQueue 保存缓存元素的有效期，使用一个线程循环查询
         *      DelayQueue，一旦能从DelayQueue 中获取元素时，表示缓存有效期到了。
         * 2. 定时任务调度： 使用DelayQueue 保存当天将会执行的任务和执行时间， 一旦从
         *      DelayQueue 中获取到任务就开始执行，从比如TimerQueue 就是使用DelayQueue 实现的。
         */
        DelayQueue<Delayed> delayQueue = new DelayQueue<>();

        /**
         * SynchronousQueue（不存储数据、可用于传递数据）
         * 是一个不存储元素的阻塞队列。每一个put 操作必须等待一个take 操作，否则不能继续添加元素。
         * SynchronousQueue 可以看成是一个传球手，负责把生产者线程处理的数据直接传递给消费者线
         * 程。队列本身并不存储任何元素，非常适合于传递性场景,比如在一个线程中使用的数据，传递给
         * 另外一个线程使用， SynchronousQueue 的吞吐量高于LinkedBlockingQueue 和
         * ArrayBlockingQueue
         */
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();

        /**
         * LinkedTransferQueue
         *
         * 是一个由链表结构组成的无界阻塞TransferQueue 队列。相对于其他阻塞队列，
         * LinkedTransferQueue 多了tryTransfer 和transfer 方法。
         * 1. transfer 方法：如果当前有消费者正在等待接收元素（消费者使用take()方法或带时间限制的
         * poll()方法时），transfer 方法可以把生产者传入的元素立刻transfer（传输）给消费者。如
         * 果没有消费者在等待接收元素，transfer 方法会将元素存放在队列的tail 节点，并等到该元素
         * 被消费者消费了才返回。
         * 2. tryTransfer 方法。则是用来试探下生产者传入的元素是否能直接传给消费者。如果没有消费
         * 者等待接收元素，则返回false。和transfer 方法的区别是tryTransfer 方法无论消费者是否
         * 接收，方法立即返回。而transfer 方法是必须等到消费者消费了才返回。
         * 对于带有时间限制的tryTransfer(E e, long timeout, TimeUnit unit)方法，则是试图把生产者传
         * 入的元素直接传给消费者，但是如果没有消费者消费该元素则等待指定的时间再返回，如果超时
         * 还没消费元素，则返回false，如果在超时时间内消费了元素，则返回true。
         */
        LinkedTransferQueue<Object> linkedTransferQueue = new LinkedTransferQueue<>();

        /**
         * LinkedBlockingDeque
         *
         * 是一个由链表结构组成的双向阻塞队列。所谓双向队列指的你可以从队列的两端插入和移出元素。
         * 双端队列因为多了一个操作队列的入口，在多线程同时入队时，也就减少了一半的竞争。相比其
         * 他的阻塞队列， LinkedBlockingDeque 多了addFirst ， addLast ， offerFirst ， offerLast ，
         * peekFirst，peekLast 等方法，以First 单词结尾的方法，表示插入，获取（peek）或移除双端队
         * 列的第一个元素。以Last 单词结尾的方法，表示插入，获取或移除双端队列的最后一个元素。另
         * 外插入方法add 等同于addLast，移除方法remove 等效于removeFirst。但是take 方法却等同
         * 于takeFirst，不知道是不是Jdk 的bug，使用时还是用带有First 和Last 后缀的方法更清楚。
         * 在初始化LinkedBlockingDeque 时可以设置容量防止其过渡膨胀。另外双向阻塞队列可以运用在
         * “工作窃取”模式中。
         */
        LinkedBlockingDeque<Object> linkedBlockingDeque = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws InterruptedException {

        threadLocal.set("aaa");

        ThreadOne threadOne = new ThreadOne();
        Thread thread = new Thread(threadOne);
        thread.start();

        ThreadTwo threadTwo = new ThreadTwo();
        Thread threadTwoT = new Thread(threadTwo);
        threadTwoT.start();


        testSchedule(scheduledExecutorService);


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    private static void testSchedule(ScheduledExecutorService scheduledExecutorService) throws InterruptedException {

        long l = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long nanoTime = System.currentTimeMillis();
                System.out.println("执行run方法" + (nanoTime - l));
            }
        });

        scheduledExecutorService.schedule(thread, 1000L, TimeUnit.MILLISECONDS);
        System.out.println("执行完毕");
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        scheduledExecutorService.shutdown();
    }


}
