package datapath;

import logic_components.ALU;

public class Execute_Instruction {
	static boolean zero;
	static String output;
	static String pc;
	static String outregdst;
	public Execute_Instruction(){
		alu();
		addpc();
		regdst();
		//EX_MEM ex_mem  = new EX_MEM();
		//ex_mem.set(zero, output, ID_EX.readdata2, outregdst, pc);
		EX_MEM.visited = true;
		EX_MEM.zero = zero;
		EX_MEM.aluResult = output;
		EX_MEM.data2 = ID_EX.readdata2;
		EX_MEM.outregdst = outregdst;
		EX_MEM.pc = pc;
		EX_MEM.branch = ID_EX.Branch;
	    EX_MEM.regWrite = ID_EX.RegWrite;
	    EX_MEM.memRead = ID_EX.MemRead;
	    EX_MEM.memWrite = ID_EX.MemWrite;
	    EX_MEM.memToReg= ID_EX.MemtoReg;
	    
	    Mem mem = new Mem();
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
