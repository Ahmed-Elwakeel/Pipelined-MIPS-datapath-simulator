package datapath;

import logic_components.SignExtend;
import storage_components.Control;
import storage_components.Registers;

public class Decode_Instruction {
	public static String instruction;
	public static String opcode;
	//public static ID_EX idex;
    //public static Register r;
	public static Control c;
	public static SignExtend se;
	
	public Decode_Instruction(){
		this.instruction = IF_ID.instruction;
		set(instruction);
	}
	
	public void set(String instruction){
		this.opcode=instruction.substring(0, 6);
    	c.controlSignals(this.opcode);
    	//this.r=new Register();
    	//idex.rsv=r.reg.get(instruction.substring(25, 21));
    	//idex.rtv=r.reg.get(instruction.substring(20, 16));
    	ID_EX.readdata1=Registers.registers.get(instruction.substring(6,11));
    	ID_EX.readdata2=Registers.registers.get(instruction.substring(11,16));
    	
    	//idex.rd=instruction.substring(15, 11);
    	ID_EX.rt = instruction.substring(11,16);
    	ID_EX.rd = instruction.substring(16,21);
    	//idex.shamt=instruction.substring(10, 6);
    	//idex.funct=instruction.substring(5, 0);
    	//ID_EX.address=instruction.substring(16, 32);
    	//int add =Integer.parseInt(idex.address);
    	ID_EX.address=se.signextend(Integer.parseInt(instruction.substring(16,32)));
    	
    	ID_EX.RegDst=c.regDst;
    	ID_EX.Branch=c.branch;
    	ID_EX.MemRead=c.memRead;
    	ID_EX.MemtoReg=c.memToReg;
    	ID_EX.ALUOp=c.ALUOp;
    	ID_EX.MemWrite=c.memWrite;
    	ID_EX.ALUSrc=c.ALUSrc;
    	ID_EX.RegWrite=c.regWrite;
    }
}