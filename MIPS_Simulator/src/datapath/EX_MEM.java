package datapath;

public class EX_MEM {

	public static boolean zero;
	public static String aluResult;
	public static String data2;
	public static String outregdst;
	public static String pc;
	
	public static boolean branch;
	public static boolean regWrite;

	public EX_MEM() {

	}
	
	public void set(boolean zero , String aluResult , String data2 , String outregdst , String pc){
		this.zero = zero;
		this.aluResult = aluResult;
		this.data2 = data2;
		this.outregdst = outregdst;
		this.pc = pc ;
	}
}
