package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintOrder {
    class Foo {
        private Semaphore sem1, sem2;

        public Foo() {
            sem1 = new Semaphore(0);
            sem2 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sem1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            sem1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sem2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            sem2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo2 {
        private int turn = 0;

        public Foo2() {
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            turn = 1;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {

            while (turn != 1) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            turn = 2;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {

            while (turn != 2) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo3 {

        private AtomicInteger turn;

        public Foo3() {
            turn = new AtomicInteger(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            turn.set(1);
        }

        public void second(Runnable printSecond) throws InterruptedException {

            while (turn.get() != 1)
                Thread.yield();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            turn.set(2);
        }

        public void third(Runnable printThird) throws InterruptedException {

            while (turn.get() != 2)
                Thread.yield();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
