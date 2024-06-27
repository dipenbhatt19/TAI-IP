/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

/**
 *
 * @author dipen
 */
import java.util.*;
public class Calculator 
{
	public static void main(String[] args) 
	{
		int a,b;
		char ch;
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter the value of a: ");
		a=sc.nextInt();
		System.out.print("Enter the value of b : ");
		b=sc.nextInt();
		System.out.print("Enter an operator : ");
		ch=sc.next().charAt(0);
		switch(ch)
		{
			case '+':
			{
                            System.out.println("a+b="+(a+b));
                            break;
				
			}
			case '-':
			{
                            System.out.println("a-b="+(a-b));
                            break;
				
			}
			case'*':
			{
                            System.out.println("a*b="+(a*b));
                            break;
				
			}
			case'/':
			{
                            System.out.println("a/b="+(a/b));
                            break;
				
			}
			case '√':
			{
                            System.out.println("√a="+(Math.sqrt(a)));
                            break;
			}
			case'^':
			{
                            System.out.println("a^="+(Math.exp(a)));
                            break;
				
			}
			default:
			{
                            System.out.println("Enter valid operator");
				
			}
		}		
	}
}