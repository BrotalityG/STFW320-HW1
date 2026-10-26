//* ************************************************************************************************
//* Class: SFTW 320 
//* Author: Branden Stahl
//* Created: 10/23/2026
//* Modified: 10/23/2026 - Created
//*
//* Purpose: This class is used to demonstrate the basic design principles
//*          of object-oriented programming as it is covered in SFTW 320.
//* 
//* Attributes: 
//*         int[] a1 - This attribute is an array of integers that is used (a1).
//*
//*         int[] a2 - This attribute is an array of integers that is used (a2).
//* 
//* Methods:
//*         void voidDoubler(int[] inArray) - This method takes an array of
//*             integers as an argument and doubles the value of each
//*             element in the array. This method does not return a value.
//*
//*         int[] returnDoubler(int[] inArray) - This method takes an array of
//*             integers as an argument and doubles the value of each
//*             element in the array. This method returns the modified
//*             array.
//*
//*         int[] returnDoublerSeparate(int[] inArray) - This method takes an
//*             array of integers as an argument and doubles the value of
//*             each element in the array. This method returns a new array
//*             that contains the modified values.
//*
//*         int[] returnDoublerNew(int[] inArray) - This method takes an array of
//*             integers as an argument and doubles the value of each
//*             element in the array. This method returns a new array that
//*             contains the modified values.
//*
//*         void testHandles(int[] a1, int[] a2, String step) - This method
//*             takes two arrays of integers and a string as arguments and
//*             tests whether the two arrays are the same object in memory.
//*             This method prints the result of the test to the console.
//*
//*         void testValues(int[] a1, int[] a2, String step) - This method takes
//*             two arrays of integers and a string as arguments and tests
//*             whether the two arrays contain the same values. This method
//*             prints the result of the test to the console.
//*
//*         int[] getA1() - This method returns the value of the a1 attribute.
//*
//*         int[] getA2() - This method returns the value of the a2 attribute.
//* 
//* ************************************************************************************************

class Main {
    private int[] a1;
    private static int[] a2;

    public static void main(String[] args) {
        Main main = new Main();
        main.initializeArrays(); //? Initialize the arrays to have 10 integers (Step 3)
        System.out.println("Calling method initializeArrays() to initialize the arrays to have 10 integers.");

        main.voidDoubler(main.getA1()); //? Step 5, Call foo1(a1).
        System.out.println("Calling method voidDoubler(a1) to double the values in array 1.");
        System.out.println("6. Array 1 after foo1: " + java.util.Arrays.toString(main.getA1()) + ";");

        a2 = main.returnDoubler(main.getA1()); //? Step 7, Call a2 = foo2(a1).
        System.out.println("Calling method returnDoubler(a1) to double the values in array 1 and return the modified array.");
        System.out.println("8. Array 1 after foo2: " + java.util.Arrays.toString(main.getA1()) + ";\n8. Array 2 after foo2: " + java.util.Arrays.toString(main.getA2()) + ";");

        main.testHandles(main.getA1(), main.getA2(), "9");
        System.out.println("Calling method testHandles(a1, a2, \"9\") to test if the handles of array 1 and array 2 are equal.");
        main.testValues(main.getA1(), main.getA2(), "10");
        System.out.println("Calling method testValues(a1, a2, \"10\") to test if the values of array 1 and array 2 are equal.");

        a2 = main.returnDoublerSeparate(main.getA1()); //? Step 11, Call a2 = foo3(a1).
        System.out.println("Calling method returnDoublerSeparate(a1) to double the values in array 1 and return a new array with the modified values.");
        System.out.println("12. Array 1 after foo3: " + java.util.Arrays.toString(main.getA1()) + ";");
        main.testHandles(main.getA1(), main.getA2(), "13");
        System.out.println("Calling method testHandles(a1, a2, \"13\") to test if the handles of array 1 and array 2 are equal.");
        main.testValues(main.getA1(), main.getA2(), "14");
        System.out.println("Calling method testValues(a1, a2, \"14\") to test if the values of array 1 and array 2 are equal.");

        a2 = main.returnDoublerNew(main.getA1()); //? Step 15, Call a2 = foo4(a1).
        System.out.println("Calling method returnDoublerNew(a1) to double the values in array 1 and return a new array with the modified values.");
        System.out.println("16. Array 1 after foo4: " + java.util.Arrays.toString(main.getA1()) + ";\n17. Array 2 after foo4: " + java.util.Arrays.toString(main.getA2()) + ";");
        main.testHandles(main.getA1(), main.getA2(), "18");
        System.out.println("Calling method testHandles(a1, a2, \"18\") to test if the handles of array 1 and array 2 are equal.");
        main.testValues(main.getA1(), main.getA2(), "19");
        System.out.println("Calling method testValues(a1, a2, \"19\") to test if the values of array 1 and array 2 are equal.");
    }

    public void testHandles(int[] a1, int[] a2, String step) {
        boolean handlesEqual = a1 == a2;
        System.out.println(step + ". Are the handles equal? " + handlesEqual + ";");
    }

    public void testValues(int[] a1, int[] a2, String step) {
        boolean valuesEqual = java.util.Arrays.equals(a1, a2);
        System.out.println(step + ". Are the values equal? " + valuesEqual + ";");
    }

    private void initializeArrays() {
        a1 = this.fillArray(new int[10], 10); //? Step 1
        a2 = this.fillArray(new int[10], 0); //? Step 2

        System.out.println("4. Array 1: " + java.util.Arrays.toString(a1) + ";");
    }

    private int[] fillArray(int[] array, int factor) {
        for (int i = 0; i < array.length; i++) {
            array[i] = factor == 0 ? 0 : 1 + (int) (Math.random() * factor);
        }

        return array;
    }

    public void voidDoubler(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            inArray[i] *= 2;
        }
    }

    public int[] returnDoubler(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            inArray[i] *= 2;
        }

        return inArray;
    }
    
    public int[] returnDoublerSeparate(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            inArray[i] = inArray[i] * 2;
        }

        int[] newArray = inArray.clone();

        return newArray;
    }

    public int[] returnDoublerNew(int[] inArray) {
        int[] newArray = new int[inArray.length];
        for (int i = 0; i < inArray.length; i++) {
            newArray[i] = inArray[i] * 2;
        }

        return newArray;
    }

    public int[] getA1() {
        return a1;
    }

    public int[] getA2() {
        return a2;
    }
}