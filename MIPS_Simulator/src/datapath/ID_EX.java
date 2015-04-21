package datapath;
import storage_components.Register;
public class ID_EX {
	public static Register reg;
	public static int pc;
	public static String instruction;
	public static String opcode;
	public static String rsv;
	public static String rtv;
	public static String rdv;
	public static String shamt;
	public static String funct;
	public static String address;
	public static boolean RegDst;
	public static boolean Branch;
	public static boolean MemRead;
	public static boolean MemtoReg;
	public static boolean ALUOp;
	public static boolean MemWrite;
	public static boolean ALUSrc;
	public static boolean RegWrite;
	public ID_EX(){
		
	}
    public void set(String instruction){
    	this.reg=new Register();
    	this.instruction=IF_ID.instruction;
    	this.opcode=instruction.substring(31, 26);
    	this.rsv=reg.reg.get(instruction.substring(25, 21));
    	this.rtv=reg.reg.get(instruction.substring(20, 16));
    	this.rdv=reg.reg.get(instruction.substring(15, 11));
    	this.shamt=instruction.substring(10, 6);
    	this.funct=instruction.substring(5, 0);
    	this.address=instruction.substring(15, 0);
    }
}