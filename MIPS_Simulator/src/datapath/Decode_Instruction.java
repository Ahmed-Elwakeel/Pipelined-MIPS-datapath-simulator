package datapath;

import logic_components.SignExtend;
import storage_components.Control;
import storage_components.Register;

public class Decode_Instruction {
	public static String instruction;
	public static String opcode;
	public static ID_EX idex;
	public static Register r;
	public static Control c;
	public static SignExtend se;
	public Decode_Instruction(){
		
	}
	
	public void set(String instruction){
		this.opcode=instruction.substring(31, 26);
    	c.controlSignals(this.opcode);
    	this.r=new Register();
    	idex.rsv=r.reg.get(instruction.substring(25, 21));
    	idex.rtv=r.reg.get(instruction.substring(20, 16));
    	idex.rd=instruction.substring(15, 11);
    	idex.shamt=instruction.substring(10, 6);
    	idex.funct=instruction.substring(5, 0);
    	idex.address=instruction.substring(15, 0);
    	int add =Integer.parseInt(idex.address);
    	idex.address=se.signextend(add);
    	idex.RegDst=c.regDst;
    	idex.Branch=c.branch;
    	idex.MemRead=c.memRead;
    	idex.MemtoReg=c.memToReg;
    	idex.ALUOp=c.ALUOp;
    	idex.MemWrite=c.memWrite;
    	idex.ALUSrc=c.ALUSrc;
    	idex.RegWrite=c.regWrite;
    }
}
