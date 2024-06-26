package com.day25;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class Operation implements Serializable{
	private static final long serialVersionUID = 1L;
	private double number1;
	private double number2;
	private String operation;
	public Operation(double number1, double number2, String operation) {
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}
	public double getNumber1() {
		return number1;
	}
	public double getNumber2() {
		return number2;
	}
	public String getOperation() {
		return operation;
	}
}

public class TCPClientServer {

	public static void main(String[] args) {
		new Thread (() -> startServer()).start();
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		startClient();

	}
	private static void startServer() {
		try(ServerSocket serverSocket = new ServerSocket(6666)){
			System.out.println("Server started and waiting for a client...");
			try(Socket socket = serverSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())){
				System.out.println("Client connected");
				Operation operation = (Operation) ois.readObject();
				double result = performOperation(operation);
				oos.writeObject(result);
				System.out.println("Result sent to client: " + result);
			}
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static double performOperation(Operation operation) {
		double num1 = operation.getNumber1();
		double num2 = operation.getNumber2();
		String op = operation.getOperation();
		switch(op) {
		case "+":
			return num1 + num2;
		case "-":
			return num1-num2;
		case "*":
			return num1 * num2;
		case "/":
			if(num2 != 0) {
				return num1 / num2;
			} else {
				throw new ArithmeticException("Division by zero");
			}
			default:
				throw new IllegalArgumentException("Invalid operation: " + op);
		}
	}
	private static void startClient() {
		try(Socket socket = new Socket("localhost", 6666);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in)){
			System.out.println("Enter first number: ");
			double number1 = sc.nextDouble();
			System.out.println("Enter second number: ");
			double number2 = sc.nextDouble();
			System.out.println("Enter operator(+, -, *, /): ");
			String operator = sc.next();
			Operation operation = new Operation(number1, number2, operator);
			oos.writeObject(operation);
			System.out.println("Operation sent to server: " + operation.getNumber1() + " " + operation.getOperation() + " " + operation.getNumber2());
			double result = (double) ois.readObject();
			System.out.println("Result received from server: " + result);
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
