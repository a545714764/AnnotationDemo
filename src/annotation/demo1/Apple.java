package annotation.demo1;

import java.lang.reflect.Field;

import annotation.demo1.FruitColor.Color;

public class Apple {
	@FruitName("Apple")
	private String appleName;

	@FruitColor(fruitColor = Color.RED)
	private String appleColor;

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleName() {
		return appleName;
	}

	public void displayName() {
		System.out.println("水果的名字是：苹果");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		Apple apple = new Apple();
		System.out.println(apple.getAppleColor());
		System.out.println(apple.getAppleName());
		
		Class c = Class.forName("annotation.demo1.Apple");

		Field[] f = c.getDeclaredFields();
		for (Field field : f) {
			boolean isExist = field.isAnnotationPresent(FruitName.class);
			if(isExist) {
				FruitName fn = (FruitName) field.getAnnotation(FruitName.class);
				System.out.println(fn.value());
			}
		}
		
		for (Field field : f) {
			boolean isExist = field.isAnnotationPresent(FruitColor.class);
			if(isExist) {
				FruitColor fn = (FruitColor) field.getAnnotation(FruitColor.class);
				System.out.println(fn.fruitColor());
			}
		}
		
		
		
	}
}
