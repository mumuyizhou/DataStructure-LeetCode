package aimatoffer;

/**
 * @author ZhouPan
 * @date 2020-06-06
 */
public class Temp {
	public void add(Integer a){
		a += new Integer(1);
	}

	public static void main(String[] args) {
		Integer a = new Integer(5);
		Temp temp = new Temp();
		temp.add(a);
		System.out.println(a.toString());
	}
}
