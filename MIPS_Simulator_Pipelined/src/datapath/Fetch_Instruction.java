package datapath;

import simulator.Simulator;

public class Fetch_Instruction {
	
	static String [] threeFields = {"add","addi","sub","sll","srl","and","nor","beq","bne","slt","sltu"};
	static String [] twoFields = {"lw","lb","lbu","sw","sb","lui"};
	static String [] oneFields = {"j","jal","jr"};
	
	public Fetch_Instruction(int pc){
		String instuction[] = Simulator.instructionmem.get(pc).split(" ");
		
		String operation = instuction[0];
		
	}
	
	public static void main(String[] args) {
		
	}
}
