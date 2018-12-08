@ ARM Assembly - Exercise 3

	.text 	@ instruction memory
	.global main
	
main:
	
	sub sp, sp, #4
	str lr, [sp, #0]

	@ load values
	ldr r0, =array_a
	
	@ ---------------------

	mov r7, #0
	ldr r6, [r0,r7]
	add r7, r7, #4
	ldr r8, [r0,r7]
	add r7, r7, #8
	ldr r9, [r0,r7]
	add r7, r7, #4
	ldr r10, [r0,r7]

	cmp r6,r10
	bne notpal

	cmp r8, r9
	bne notpal

	ldr r0, =format1
	mov r1,r5
	bl printf

	b exit
	
notpal:
	@ load aguments and print
	ldr r0, =format2
	mov r1,r5
	bl printf
exit:
	@ stack handling (pop lr from the stack) and return
	ldr lr, [sp, #0]
	add sp, sp, #4
	mov pc, lr
	
	.data	@ data memory
	
format1: .asciz "The number is a palindrome\n"
format2: .asciz "The number is not a palindrome\n"
	
	
	@array called array_a of size 40 bytes
	.balign 4 			@align to an address of multiple of 4
array_a: .word 2,3,9,3,2
