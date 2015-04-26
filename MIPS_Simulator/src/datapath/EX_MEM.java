package datapath;

public class EX_MEM {
	public static boolean visited ;
	public static boolean zero;
	public static String aluResult;
	public static String data2;
	public static String outregdst;
	public static String pc; //after adding 4 for the branch
	public static String jpc; // for the jump	
	
	public static boolean bneBranch;
	public static boolean branch;
	public static boolean regWrite;
	public static boolean memRead;
	public static boolean memWrite;
	public static boolean memToReg;
	public static boolean lb;
	public static boolean sb;
	public static boolean j;
	public static boolean jal;
	public static boolean jr;
	public static boolean lui;
	public static String returnAddress;
	public EX_MEM() {

	}
	//malhash lazma;
	public void set(boolean zero , String aluResult , String data2 , String outregdst , String pc){
		this.zero = zero;
		this.aluResult = aluResult;
		this.data2 = data2;
		this.outregdst = outregdst;
		this.pc = pc ;
	}
}
