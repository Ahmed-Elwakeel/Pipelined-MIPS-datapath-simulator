package datapath;

import logic_components.ALU;
import logic_components.ALUControl;

public class Execute_Instruction {
	static boolean zero;
	static String output;
	static String pc;
	static String outregdst;
	static String jpc;
	static String returnAddress;
	public Execute_Instruction(){
		if(ID_EX.visited){
		alu();
		addpc();
		regdst();
		j();
		pcJal();
		
		//EX_MEM ex_mem  = new EX_MEM();
		//ex_mem.set(zero, output, ID_EX.readdata2, outregdst, pc);
		EX_MEM.visited = true;
		EX_MEM.zero = zero;
		EX_MEM.aluResult = output;
		EX_MEM.data2 = ID_EX.readdata2;
		
		if(ID_EX.jal){
			EX_MEM.outregdst = ID_EX.ra;
		}else{
		EX_MEM.outregdst = outregdst;
		
		}
		EX_MEM.pc = pc;
		EX_MEM.branch = ID_EX.Branch;
	    EX_MEM.regWrite = ID_EX.RegWrite;
	    EX_MEM.memRead = ID_EX.MemRead;
	    EX_MEM.memWrite = ID_EX.MemWrite;
	    EX_MEM.memToReg= ID_EX.MemtoReg;
	    EX_MEM.bneBranch = ID_EX.bneBranch;
	    EX_MEM.lb = ID_EX.lb;
	    EX_MEM.sb = ID_EX.sb;
	    EX_MEM.j = ID_EX.j;
	    EX_MEM.jpc = jpc;
	    EX_MEM.jal = ID_EX.jal;
	    EX_MEM.jr = ID_EX.jr;
	    EX_MEM.returnAddress = returnAddress;
	    EX_MEM.lui = ID_EX.lui;
	   // Mem mem = new Mem();
	    
	    EX_MEM.visited = true;
		Printing.printing();

		}
	}
	
	
	
	public void pcJal(){
		int x = Integer.parseInt(ID_EX.pc,2);
		int res = x+4;
		returnAddress = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
	}
	
	public void j(){
		String jAdd = ID_EX.jAddress;
		int intJAdd = Integer.parseInt(jAdd,2);
		intJAdd = intJAdd << 2;

		jAdd = String.format("%28s", Integer.toBinaryString(intJAdd)).replace(' ', '0');
		String conPc = ID_EX.pc.substring(0,4);
		jAdd = conPc+jAdd;
		jpc = jAdd;
	}
	
	public void regdst(){
		if(ID_EX.RegDst){
			outregdst = ID_EX.rd;
		}else{
			outregdst = ID_EX.rt;
		}
	}
	
	public void alu(){
		if(ID_EX.ALUSrc){
			ALU alu = new ALU( ID_EX.readdata1 , ID_EX.address );
		}else{
			ALU alu = new ALU(ID_EX.readdata1 , ID_EX.readdata2 );
		}
		output = ALU.output;
		zero = ALU.zero;
		
	}
	
	public void addpc(){
		int x = Integer.parseInt(ID_EX.address, 2);
		x = x << 2;
		int y = Integer.parseInt(ID_EX.pc, 2);
		
		int res = x + y;
		pc = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
		
	}
	
	public static void main(String[] args) {
		
	}
}
