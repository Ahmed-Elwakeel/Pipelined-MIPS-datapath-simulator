package datapath;

import logic_components.ALU;

public class Execute {
	static boolean zero;
	static String output;
	static String pc;
	static String outregdst;
	public Execute(){
		alu();
		addpc();
		regdst();
		EX_MEM ex_mem  = new EX_MEM();
		ex_mem.set(zero, output, ID_EX.readdata2, outregdst, pc);
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
			ALU alu = new ALU(ID_EX.readdata1 , ID_EX.signExtend);
		}else{
			ALU alu = new ALU(ID_EX.readdata1 , ID_EX.readdata2);
		}	
		output = ALU.output;
		zero = ALU.zero;
		
	}
	
	public void addpc(){
		int x = Integer.parseInt(ID_EX.signExtend, 2);
		int y = Integer.parseInt(ID_EX.pc, 2);
		
		int res = x + y;
		
		pc = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
		
	}
	
	public static void main(String[] args) {
		
	}
}
