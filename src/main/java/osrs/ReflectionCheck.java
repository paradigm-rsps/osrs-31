package osrs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionCheck extends Node {
    int id;
    int size;
    int[] intReplaceValues;
    int[] operations;
    int[] creationErrors;
    Field[] fields;
    Method[] methods;
    byte[][][] arguments;
}
