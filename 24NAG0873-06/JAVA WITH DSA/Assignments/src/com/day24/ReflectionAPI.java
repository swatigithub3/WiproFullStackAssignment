package com.day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee {
	private String employeeName;
	private int employeeId;
	public Employee(String employeeName, int employeeId) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
	}
	public void displayInfo() {
		System.out.println("Employee Name: " + employeeName + ", Employee Id: " + employeeId);
	}
	@SuppressWarnings("unused")
	private void secretMethod() {
		System.out.println("This is a secret method");
	}
}

public class ReflectionAPI {
	public static void main(String[] args) {
		try {
			Class<?> employeeClass = Employee.class;
			System.out.println("Fields:");
			Field[] fields = employeeClass.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(field);
			}
			System.out.println("\nConstructors:");
			Constructor<?>[] constructors = employeeClass.getDeclaredConstructors();
			for(Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}
			System.out.println("\nMethods:");
			Method[] methods = employeeClass.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method);
			}
			Constructor<?> employeeConstructor = employeeClass.getConstructor(String.class, int.class);
			Employee employeeInstance = (Employee) employeeConstructor.newInstance("John Doe", 121);
			System.out.println("\nOriginal Field Values:");
			employeeInstance.displayInfo();
			Field nameField = employeeClass.getDeclaredField("employeeName");
			nameField.setAccessible(true);
			nameField.set(employeeInstance, "Swati");
			System.out.println("\nModified Field value: ");
			employeeInstance.displayInfo();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}


