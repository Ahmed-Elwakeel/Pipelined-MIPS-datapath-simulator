package datapath;

public class ID_EX {
	public static String pc;
	public static String readdata1;
	public static String readdata2;
	
	public static String rt; //[20:16]
	public static String rd; //[15:11]
	//public static String shamt;

	public static String address; //[15-0]
	
	public static boolean RegDst;
	public static boolean Branch;
	public static boolean MemRead;
	public static boolean MemtoReg;
	public static String ALUOp;
	public static boolean MemWrite;
	public static boolean ALUSrc;
	public static boolean RegWrite;

	public ID_EX(){

	}
  
}