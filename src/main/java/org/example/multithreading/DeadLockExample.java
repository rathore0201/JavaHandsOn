package org.example.multithreading;

class Pen{
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen and trying to get paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " is finished using pen.");
    }
}

class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper and trying to get pen");
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " is finished using paper.");
    }
}

class Task1 implements Runnable{
    private Pen pen;

    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); // Thread1 locks pen and tries to lock paper
    }
}

class Task2 implements Runnable{
    private Pen pen;

    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        paper.writeWithPaperAndPen(pen); // Thread2 locks paper and tries to lock pen
    }

//    Solution : Consistent ordering
//    @Override
//    public void run() {
//        synchronized (pen){ // task 2 tries to lock pen first and if it is available then will lock paper, but since as pen is locked by task 2, it will not lock paper then
//            paper.writeWithPaperAndPen(pen);
//        }
//    }
}

public class DeadLockExample {
    public static void main(String[] args){
        Pen pen = new Pen();
        Paper paper = new Paper();

        Task1 task1 = new Task1(pen, paper);
        Task2 task2 = new Task2(pen, paper);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
