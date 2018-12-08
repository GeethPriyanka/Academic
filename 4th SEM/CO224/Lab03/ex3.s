@ ARM Assembly - exercise 3

	.text 	@ instruction memory

	
@ Write YOUR CODE HERE	

@ ---------------------	
@ Fibonacci:

Fibonacci:
	cmp r4, #0
	beq end1

	cmp r4, #1
	beq end1

	add r8, r6, r7

	mov r7, r6
	mov r6, r8
	add r10, r10, #1
	cmp r10, r0
	
	bne Fibonacci

	mov r5, r6

	b end






@ ---------------------
	
	.global main
main:
	@ stack handling, will discuss later
	@ push (store) lr to the stack
	sub sp, sp, #4
	str lr, [sp, #0]

	mov r4, #8 	@the value n

	@ calling the Fibonacci function
	mov r0, r4 	@the arg1 load
	mov r6, #1
	mov r7, #1
	mov r10, #1
	bl Fibonacci
	mov r5,r0

	b end

end1:
	mov r5, #1
	
end:
	@ load aguments and print
	ldr r0, =format
	mov r1, r4
	mov r2, r5
	bl printf

	@ stack handling (pop lr from the stack) and return
	ldr lr, [sp, #0]
	add sp, sp, #4
	mov pc, lr

	.data	@ data memory
format: .asciz "F_%d is %d\n"

