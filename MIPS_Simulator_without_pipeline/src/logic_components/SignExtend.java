
package logic_components;


public class SignExtend {
	 public static String address;
	 public SignExtend(){
		 
	 }
	 public static String signextend(int address){
		 return String.format("%32s", Integer.toBinaryString(address)).replace(' ', '0');
		 
	 }
	 public static String unsignedxtend(int address){
		 
		 return String.format("%32s", Integer.toBinaryString(address)).replace(' ', '0');
		 
	 }
}