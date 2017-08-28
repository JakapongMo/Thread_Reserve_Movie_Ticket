import java.util.Date;
import java.text.SimpleDateFormat;
public class Movie {
		static int t1 = 20, t2 = 20,  t3 = 20,  t4 = 20,  t5 = 20;
	
		public static void lock(int x, int t){
			if (t == 1) {
				t1 -= x;
			} else if (t == 2) {
				t2 -= x;
			} else if  (t == 3) {
				t3 -= x;
			} else if (t == 4) {
				t4 -= x;
			} else if (t == 5) {
				t5 -= x;
			}
		}
		public static void unlock(int x, int t){
			if (t == 1) {
				t1 += x;
			} else if (t == 2) {
				t2 += x;
			} else if  (t == 3) {
				t3 += x;
			} else if (t == 4) {
				t4 += x;
			} else if (t == 5) {
				t5 += x;
			}
			
		}
		
		public static void main(String[] args){
			SimpleDateFormat format = new SimpleDateFormat("YYYY MM dd HH:mm:ss");
	        //System.out.println("2. " + format.format(new Date()));
			Movie m = new Movie();
			Thread t1 = new Thread(){
				 public void run(){
					 for(int i=1;i<5;i++){  
						 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
						 	System.out.println(format.format(new Date()) +" : "+ i);  
						 }  
				    }
			};
			Thread t2 = new Thread(){
				 public void run(){
					 for(int i=1;i<5;i++){  
						 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
						  System.out.println(format.format(new Date()) + " : "+ i);  
						}  
				    }
			};
		    t1.start();
		    t2.start();
		}
	
}
