package coreJava.reflect;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) throws ReflectiveOperationException{
        String name ;
        if(args.length > 0 ) name = args[0];
        else{
            var in = new Scanner(System.in);
            System.out.println("Enter a class name (e.g. java.util.Date):");
            name = in.next();
        }
        // print class name and superclass name (if !=Object)
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length() > 0)
            System.out.println(modifiers+" ");
        System.out.println("class" + name);
        if(supercl !=null &&supercl!=Object.class)
            System.out.println("extends" + supercl.getName());
        System.out.println("\n{\n");
        printConstructor(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }

    public static void printConstructor(Class cl){
        Constructor[] contructors = cl.getDeclaredConstructors();
        for(Constructor c : contructors){
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name+"(");
            //print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++){
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Print all method of a class
     * @param cl a class
     */
    public static void printMethods(Class cl){
        Method[] methods = cl.getMethods();
        for(Method m :methods){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");

            //print modifiers,return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length()> 0)
                System.out.print(modifiers+" ");
            System.out.print(retType.getName() +" "+name+"(");

            //print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0; j < paramTypes.length;j++){
                if(j > 0 ) System.out.print(", ");
                System.out.print( paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all fields of a class
     * @param cl a class
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();
        for(Field f : fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name+";");
        }
    }












}
