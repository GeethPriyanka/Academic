@ ARM Assembly - sample program 

	.text 	@ instruction memory
	.global main
main:
	@ stack handling, will discuss later
	@ push (store) lr to the stack
	sub sp, sp, #4
	str lr, [sp, #0]

	@ load values --> can be changed
	mov r0, #10
	mov r1, #20
	mov r2, #7
	mov r3, #-8

	
	@ Write YOUR CODE HERE
	@ ---------------------
	
	cmp r0, r1
	bhs print1
	b print2


	
		
	
	@ ---------------------
	
	
	@ load aguments and print

print1:
	ldr r0, =format1
	@mov r1, r5
	bl printf

	b end
print2:
	ldr r0, =format2
	@mov r1, r5
	bl printf
end:
	@ stack handling (pop lr from the stack) and return

	ldr lr, [sp, #0]
	add sp, sp, #4
	mov pc, lr

	.data	@ data memory
format1: .asciz "i is greater than j\n"
format2: .asciz "i is lower than j \n"
