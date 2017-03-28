/*
 *os가 여러 프로세스들을 동시에 수행하면서 관리할 수 있듯(multi-tasking),
 *하나의 자바프로그램 내에서 세부적 실행단위를 만들어 동시에 수행시킬 수 있다.
 *이러한 세부적 실행 단위를 쓰레드라 한다. 
자바는 개발자가 정의하지 않아도 이미 기본적으로 제공되는 실행용 쓰레드가 있으며
 * 이러한 쓰레드를 가리켜 메인쓰레드라 한다.
 * 결국 자바는 쓰레드 기반이다.
 * 
 * 실시간 감시, 채팅등에 쓰면 좋다.
 * */

package	com.ss.thread;

public class ThreadTest {
		//메인스레드 말고, 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서 원하는 동시작업을 시켜보자!
	//java.lang에 있어 import하지 않아도 된다.
	//Thread thread;
	MyThread thread;
	public ThreadTest() {
		//메인쓰레드와는 독립적으로 실행될 수 있는 세부 실행단위를 생성함
		//쓰레드가 어떤 일을 할 지는 개발자가 결정해야 하기 때문에 상속받아 재정의해야함
		thread=new MyThread(); //머리카락에서 분신 생성
		thread.start(); //run()대신 실행할때써야한다. jvm이 대신 때리는 탁아소(runnable)로 보냄 
		//run();을쓰면 일반메소드가 되어 별도의 실행부가 아닌 main 스레드가 실행해 버린다. 
				
		//메인스레드를 무한루프에 빠뜨리면 앱이 동작하지 않음
		while(true){
			try {
				Thread.sleep(500); //메인스레드의 sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");//메인실행부가 실행
		}
	}
	
	public static void main(String[] args) {
		new ThreadTest();
		
		//int[]arr = new int[3];
		//System.out.println(arr[3]); 
		//배열의 크기 이상의 인덱스의 값을 출력하려고하면 컴파일에서는 못잡음
		//runtime error에서 메인쓰레드에 이상표시
	}
		
		
	
}
