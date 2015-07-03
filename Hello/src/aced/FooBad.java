/**
 * 
 */
package aced;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LO
 *
 */
public class FooBad {
	public int pauseTime = 1000;
	public ReentrantLock lock1;
	
	public FooBad(){
		lock1 = new ReentrantLock();
		
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
