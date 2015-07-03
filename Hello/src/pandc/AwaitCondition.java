package pandc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sun.nio.ch.ChannelInputStream;

public class AwaitCondition {
	private int size = 10;
	private PriorityQueue<Integer> p = new PriorityQueue<Integer>(size);
	private Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		AwaitCondition a = new AwaitCondition();
//		Producer p = a.new Producer();
//		Costomer c = a.new Costomer();
//		p.start();
//		c.start();
//		File file = new File("D:/hello.txt");
//		FileOutputStream o = new FileOutputStream(file);
//		FileChannel channel = o.getChannel();
//		ByteBuffer buffer = ByteBuffer.allocate(1024);
//		String str = "java io";
//		buffer.put(str.getBytes());
//		buffer.flip();
//		channel.write(buffer);
//		channel.close();
//		o.close();
		String sa = "124";
		final String sb = "12";
		String sc = sb+4;
		System.out.println(sa==sc);
	}
	private class Producer extends Thread{
		
		public void run(){
			while(true){
				lock.lock();
				try {
					while (p.size() == size) {
						try {
							notFull.await();
							System.out.println("¬˙¡À"+p.size());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					p.offer(1);
					notEmpty.signal();
				} finally{
					lock.unlock();
				}
			}
		}
	}
	protected class Costomer extends Thread{
		public void run(){
			while(true){
				lock.lock();
				try {
					while (p.size() == 0) {
						try {
							notEmpty.await();
							System.out.println("ø’¡À"+p.size());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					p.poll();
					notFull.signal();
				} finally{
					lock.unlock();
				}
			}
		}
	}
}
