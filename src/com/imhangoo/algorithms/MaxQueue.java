import java.util.Vector;

public class MaxQueue {
	private Vector<Integer> queue1 = new Vector<Integer>();
	private Vector<Integer> queue2 = new Vector<Integer>();
	private int front1 = 0, rear1 = 0;
	private int front2 = 0, rear2 = 0;

	
	public void enqueue(int value){
		// operations on queue1
		queue1.add(value);
		rear1++;
		// operations on queue2
		if(rear2==0 || value <= queue2.get(rear2-1)){
			queue2.add(value);
			rear2++;	
			
		}else{
			queue2.set(rear2-1, value);
			while(rear2>1 && queue2.get(rear2-1)>queue2.get(rear2-2)){
				queue2.set(rear2-2, queue2.get(rear2-1));
				queue2.remove(rear2-1);
				rear2--;
			}
		}
	}
	
	public void dequeue(){
		// operations on queue1
		if(rear1<=front1) return;
		front1++;
		// operations on queue2
		if(queue1.get(front1-1)==queue2.get(front2)){
			front2++;
		}
	}
	
	public void printQ1(){
		System.out.println("Q1");
		for(int i = front1;i < rear1;i++){
			System.out.println(queue1.get(i));
		}
	}
	
	public void printQ2(){
		System.out.println("Q2");
		for(int i = front2;i < rear2;i++){
			System.out.println(queue2.get(i));
		}

	}
	
	public int max(){
		return queue2.get(front2);
	}
	
	public Vector<Integer> getVector1() {
		return queue1;
	}


	public Vector<Integer> getVector2() {
		return queue2;
	}


	
	
	


}
