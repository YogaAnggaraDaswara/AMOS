package com.mobile.framework.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.util.Log;

public class Reflection {
	
	public static boolean fieldUpdate(Object src, Object dst) {
		boolean retVal = false;
		
		if (src != null && dst != null) {
			Class<?> srcClass = src.getClass();
			Class<?> dstClass = dst.getClass();
			Field[] srcFields = srcClass.getDeclaredFields();
			Field dstField = null;
			Object srcValue = null;
			
			try {
				if (srcFields != null) {
					for (Field srcField : srcFields) {
						dstField = dstClass.getField(srcField.getName());
						dstField.setAccessible(true);
						srcField.setAccessible(true);						
						if (dstField != null) {
							if (dstField.getType().isAssignableFrom(srcField.getType())) {
								dstField.setAccessible(true);
								srcValue = srcField.get(src);
								if (srcValue != null) {
									dstField.set(dst, srcValue);
								}
							}
						}
					}
				}
			} catch (Exception e) {
				Log.i(Reflection.class.getName(), 
						String.format("fieldUpdate fail, Exception: %s", e.getMessage()));
			}
		}
		
		return retVal;
	}
	
	public static boolean propertiesUpdate(Object src, Object dst) {
		boolean retVal = false;
		
		if (src != null && dst != null) {
			Class<?> srcClass = src.getClass();
			Class<?> dstClass = dst.getClass();
			Method[] srcMethodes = srcClass.getDeclaredMethods();
			Method dstMethode = null;
			Method srcMethode = null;
			Object srcValue = null;
			Class<?> srcMethodeType = null;
			String setterMethodName = "";
			String getterMethodName = "";
			
			try {
				if (srcMethodes != null) {
					for (int methodeCounter = 0; methodeCounter < srcMethodes.length; methodeCounter++) {
						srcMethode = srcMethodes[methodeCounter];
						if (srcMethode != null) {
							getterMethodName = srcMethode.getName(); 
							if (getterMethodName.startsWith("get") && getterMethodName.length() > 3) {
								srcMethodeType = srcMethode.getReturnType();
								setterMethodName = String.format("set%s", getterMethodName.substring(3));
								try {
									srcValue = srcMethode.invoke(src, (Object[]) null);
									dstMethode = dstClass.getDeclaredMethod(setterMethodName, srcMethodeType);
									if (dstMethode != null) {
										dstMethode.invoke(dst, srcValue);
									}
								} catch (Exception e) {
									// do nothing
//									Log.i(Reflection.class.getName(), 
//											String.format("reflectionUpdate, Exception: %s", 
//													e.getMessage()));
								}
							}
						}
					}
					retVal = true;
				}
			} catch (Exception e) {
				Log.i(Reflection.class.getName(), 
						String.format("reflectionUpdate fail, Exception: %s", e.getMessage()));
			}
		}
		
		return retVal;
	}
}
