
//ALU

module alu(Result,DATA1,DATA2,Select);

	input [7:0]DATA1,DATA2;
	input [2:0] Select;
	output reg [7:0]Result;

	always@(DATA1,DATA2,Select)

	begin
		case(Select)

			3'b000 : Result = DATA1;
			3'b001 : Result = DATA1 + DATA2;
			3'b010 : Result = DATA1 & DATA2;
			3'b011 : Result = DATA1 | DATA2;

		endcase
	
	end

endmodule

module regfile8x8a(
input clk,
input [2:0] INaddr,
input [7:0] IN,
input [2:0] OUT1addr,
output [7:0] OUT1,
input [2:0] OUT2addr,
output [7:0] OUT2);

	reg [7:0] reg0, reg1, reg2, reg3,reg4,reg5,reg6,reg7;

	assign OUT1 = 	OUT1addr == 0 ? reg0 :
					OUT1addr == 1 ? reg1 :
					OUT1addr == 2 ? reg2 :
					OUT1addr == 3 ? reg3 :
					OUT1addr == 4 ? reg4 :
					OUT1addr == 5 ? reg5 :
					OUT1addr == 6 ? reg6 : reg7;
	
	// add until 8 //
	assign OUT2 =   OUT2addr == 0 ? reg0 :
					OUT2addr == 1 ? reg1 :
					OUT2addr == 2 ? reg2 :
					OUT2addr == 3 ? reg3 :
					OUT2addr == 4 ? reg4 :
					OUT2addr == 5 ? reg5 :
					OUT2addr == 6 ? reg6 : reg7;
					
//add until 8//


	always @(negedge clk) 
	begin
		case(INaddr)
			0 : reg0 = IN;
			1 : reg1 = IN;
			2 : reg2 = IN;
			3 : reg3 = IN;
			4 : reg4 = IN;
			5 : reg5 = IN;
			6 : reg6 = IN;
			7 : reg7 = IN;
		endcase	
	end // always @ (negedgeclk)
endmodule


module mux(out,in1,in2,select);

input [7:0] in1,in2;
output [7:0] out;
input select;

	assign out = (select) ? in1 : in2; 

endmodule


module counter (clk, reset,Read_addr);
	
input clk;
input reset;
output [31:0] Read_addr;
	// The outputs are defined as registers too
reg [31:0] Read_addr = 0;

	always @(negedge clk)
	begin
		Read_addr = Read_addr + 1;
	end

endmodule


module instruction_reg( clk,read_addr,instruction);

input clk;
input [31:0] read_addr;
output reg [31:0] instruction;

	always @(read_addr) 
	begin
		case(read_addr)
			32'h00000000: instruction = 32'h080400FF;
			32'h00000001: instruction = 32'h080400FF;
			32'h00000002: instruction = 32'h080600AA;
			32'h00000003: instruction = 32'h080300BB;
			32'h00000004: instruction = 32'h01050603;
			32'h00000005: instruction = 32'h02010405;
			32'h00000006: instruction = 32'h03020106;
			32'h00000007: instruction = 32'h00070002;
			32'h00000008: instruction = 32'h09040703;
		endcase
	end

	always @(negedge clk) 
	begin
	//add your code here//
		
	end

endmodule	


module Twos_cmp(in,out);

input [7:0] in;
output [7:0] out;
wire [7:0] x;
	
	assign x = ~ in;
	assign out = x + 8'b00000001;	

endmodule



module control(instruction, OUT1addr, OUT2addr, INaddr , select , mux_one , mux_two , mux_three , OPcode , immediate);

input [31:0] instruction;
output [2:0] OUT1addr;
output [2:0] OUT2addr;
output [2:0] INaddr;
output reg mux_one,mux_two,mux_three;
output [2:0] select;
output [7:0] immediate;
output [7:0] OPcode;
 
	assign select = instruction[26:24];
	assign OUT1addr = instruction[2:0];
	assign OUT2addr = instruction[10:8];
	assign INaddr = instruction[18:16];
	assign immediate = instruction[7:0];
	assign OPcode = instruction[31:24];

	always @(OPcode) 

	begin

		case(OPcode)

			0:begin //mov
				mux_one = 1'b1;
				mux_two = 1'b0;
				mux_three = 1'b1;
				end

			1:begin //add
				mux_one = 1'b1;
				mux_two = 1'b0;
				mux_three = 1'b1;
				end

			2:begin //and
				mux_one = 1'b1;
				mux_two = 1'b0;
				mux_three = 1'b1;
				end

			3:begin //or
				mux_one = 1'b1;
				mux_two = 1'b0;
				mux_three = 1'b1;
				end

			8:begin //ldr
				mux_one = 1'b1;
				mux_two = 1'b1;
				end
				
			9:begin //sub
				mux_one = 1'b0;
				mux_two = 1'b0;
				mux_three = 1'b1;
				end

		endcase

	end

endmodule

module simulate;

	reg clk,reset,reset_reg;
	
	wire [31:0] Read_addr,Instruction;
	wire [7:0] OPCODE,Immediate,OUT1,OUT2,RESULT,twosComplement0,twosComplement1,mux2out,mux1out,mux0out,result;
	wire [2:0] alu_select,OUT1addr,OUT2addr,INaddr,select;
	wire mux1,mux2,mux0;

	counter count(clk, reset,Read_addr);
	instruction_reg insReg( clk,Read_addr,Instruction);
 	control cont(Instruction, OUT1addr, OUT2addr, INaddr , select , mux0 , mux1 , mux2 , OPCODE , Immediate);

	regfile8x8a regs(clk,INaddr,result,OUT1addr,OUT1,OUT2addr,OUT2);
	Twos_cmp two1(OUT1,twosComplement0);
	Twos_cmp two2(OUT2,twosComplement1);
	mux m0(mux0out,OUT1,twosComplement0,mux0);
	mux m1(mux1out,Immediate,mux0out,mux1);
	mux m2(mux2out,OUT2,twosComplement1,mux2);
	alu alu(result,mux1out,mux2out,select);

	always #10 clk = ~clk;

	initial begin
		$dumpfile("wavedata.vcd");
		$dumpvars(0,simulate);	
		clk = 0;
		reset = 1;
		reset = 0;
		reset_reg = 1;
		reset_reg = 0;
		#160 $finish;
	end

	initial begin
		while(1) begin
		#20 $display("%h	OUT1addr=%d 	OUT2addr=%d 	INaddr=%d	Out1=%d	Out2=%d	im=%d	m1=%d	m2=%d	mc3=%d	Result=%d	select=%d",Instruction,OUT1addr,OUT2addr,INaddr,OUT1,OUT2,Immediate,mux0out,mux1out,mux2out,result,select);
		
		end
	end

endmodule

/*
module simulate;


	wire [7:0]result;
	reg [2:0]Select;	
	
	reg clk;
	reg [2:0] INaddr;
	reg [7:0] IN;
	reg [2:0] OUT1addr;
	wire [7:0] OUT1,OUT3,OUT4;
	reg [2:0] OUT2addr;
	wire [7:0] OUT2;
	reg [8:0] reg0, reg1, reg2, reg3,reg4,reg5,reg6,reg7; 
	
	regfile8x8a regs(clk,INaddr,IN,OUT1addr,OUT1,OUT2addr,OUT2);
	alu alu01(result,OUT1,OUT2,Select);	

	regfile8x8a regs2(clk,INaddr,result,OUT1addr,OUT3,OUT2addr,OUT4);


	initial
	begin

	IN = 20;
	#5 clk = 1;
	INaddr = 1;
	#5 clk = 0;
	
	OUT1addr = 1;

	#5 $display("out = %d",OUT1);
	
	IN = 10;
	#5 clk = 1;
	INaddr = 2;
	#5 clk = 0;
	
	OUT2addr = 2;

	#5 $display("out = %d",OUT2);	

	Select = 1;
	
	IN = 10;
	#5 clk = 1;
	INaddr = 3;
	#5 clk = 0;	

	OUT2addr = 3;
	
	#5 $display("out = %d",OUT4);	

	$finish;

	end
	
endmodule
*/
