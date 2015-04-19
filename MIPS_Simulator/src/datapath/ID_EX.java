package datapath;

public class ID_EX {
	public static int pc;
	public static String instruction;
	public static String opcode;
	public static String rs;
	public static String rt;
	public static String rd;
	public static String shamt;
	public static String funct;
	public static String address;
	
	public ID_EX(){
		
	}
    public void set(String instruction,String opcode,String rs,String rt,String rd,String shamt, String funct,String address){
    	this.opcode=instruction.substring(31, 26);
    	this.rs=instruction.substring(25, 21);
    	this.rt=instruction.substring(20, 16);
    	this.rd=instruction.substring(15, 11);
    	this.shamt=instruction.substring(10, 6);
    	this.funct=instruction.substring(5, 0);
    	this.address=instruction.substring(15, 0);
    }
}
