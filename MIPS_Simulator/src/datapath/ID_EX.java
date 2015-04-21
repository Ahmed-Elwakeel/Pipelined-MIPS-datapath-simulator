package datapath;

public class ID_EX {
	public static String pc;
	public static String instruction;
	public static String opcode;
	public static String rs;
	public static String rt;
	public static String rd;
	public static String shamt;
	public static String funct;
	public static String address;
	public static boolean RegDst;
	public static boolean Branch;
	public static boolean MemRead;
	public static boolean MemtoReg;
	public static String ALUOp;
	public static boolean MemWrite;
	public static boolean ALUSrc;
	public static boolean RegWrite;
	
	public static String signExtend;
	public static String readdata1;
	public static String readdata2;
	public ID_EX(){
		
	}
	
	
	
    public void set(String instruction){
    	this.instruction=IF_ID.instruction;
    	this.opcode=instruction.substring(31, 26);
    	this.rs=instruction.substring(25, 21);
    	this.rt=instruction.substring(20, 16);
    	this.rd=instruction.substring(15, 11);
    	this.shamt=instruction.substring(10, 6);
    	this.funct=instruction.substring(5, 0);
    	this.address=instruction.substring(15, 0);
    }
}