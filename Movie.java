import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
public class Movie {
		static int t1 = 20, t2 = 20,  t3 = 20,  t4 = 20,  t5 = 20;
	
		public static void Lock(int x, int t){
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
		public static void UnLock(int x, int t){
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
		public static int Get_remain(int x, int t){
			if (t == 1) {
				return t1;
			} else if (t == 2) {
				return t2;
			} else if  (t == 3) {
				return t3;
			} else if (t == 4) {
				return t4;
			} else {
				return t5;
			}
		}
		
		public static void main(String[] args){
			SimpleDateFormat format = new SimpleDateFormat("YYYY MM dd HH:mm:ss");
	        //System.out.println("2. " + format.format(new Date()));
			Movie m = new Movie();
			Random rn = new Random();
			
			Thread t1 = new Thread(){
				 public void run(){
					 for(int i=1;i<5;i++){  
						 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5) + 1;
						 int selected_ticket = rn.nextInt(5) + 1;
						 m.Lock(selected_ticket, selected_movie);
						 System.out.println(format.format(new Date()) +" : "+"lock movie" + selected_movie + " nb_ticket : "+ selected_ticket +" remain : "+ m.Get_remain(selected_ticket, selected_movie) );
						 	
						 }  
				    }
			};
			Thread t2 = new Thread(){
				 public void run(){
					 for(int i=1;i<5;i++){  
						 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
						 int selected_movie = rn.nextInt(5) + 1;
						 int selected_ticket = rn.nextInt(5) + 1;
						 
						 m.Lock(selected_ticket, selected_movie);
						 System.out.println(format.format(new Date()) +" : "+"lock movie" + selected_movie + " nb_ticket : "+ selected_ticket +" remain : "+ m.Get_remain(selected_ticket, selected_movie) ); 
						}  
				    }
			};
		    t1.start();
		    t2.start();
		}
	
}
