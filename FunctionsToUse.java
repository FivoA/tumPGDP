import java.util.Arrays;
class FunctionsToUse {

    //General Functions for integers

    //Number of Digits of an INT
    public static int calculateNumberOfDigits(int n) {
        int numberOfDigits = 0;
        while(n > 0) {
            n = n / 10;
            numberOfDigits = numberOfDigits + 1;
        }
        return numberOfDigits;
    }
    //Reverse an INT
    public static int reverseNumber(int n) {
        int reversedNumber = 0;
        while(n > 0) {
            reversedNumber = reversedNumber * 10;
            reversedNumber = reversedNumber + n % 10;
            n = n / 10;
        }
        return reversedNumber;
    }
    //Is INT a palindrome?
    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }
    //Is INT a prime number?
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    // General Functions for Arrays

    // Zip up two diff arrays
    public static int[] zip(int[] a, int[] b){
        int[] zippedArray = new int[a.length + b.length];
        int minLength = Math.min(a.length, b.length);

        for(int i = 0; i < minLength; i++) {
            zippedArray[2*i] = a[i];
            zippedArray[2*i + 1] = b[i];
        }

        if(a.length < b.length) {
            for(int i = minLength; i < b.length; i++) {
                zippedArray[minLength + i] = b[i];
            }
        } else {
            for(int i = minLength; i < a.length; i++) {
                zippedArray[minLength + i] = a[i];
            }
        }

        return zippedArray;
    }

    // Zip many arrays, like all arrays in a 2d array
    public static int[] zipMany(int[][] arrays){
        int maxLength = 0;
        int sumOfLengths = 0;
        for(int i = 0; i < arrays.length; i++) {
            sumOfLengths += arrays[i].length;
            if(arrays[i].length > maxLength) {
                maxLength = arrays[i].length;
            }
        }

        int[] zippedArray = new int[sumOfLengths];
        int nextPosition = 0;
        for(int j = 0; j < maxLength; j++) {
            for(int i = 0; i < arrays.length; i++) {
                if(j < arrays[i].length) {
                    zippedArray[nextPosition] = arrays[i][j];
                    nextPosition++;
                }
            }
        }

        return zippedArray;
    }

    //Zahlen aus Array entfernen, die nicht im gegebenen Intervall liegen
    public static int[] filter(int[] array,int min,int max){
        int firstUnusedPosition = 0;
        int[] out = new int[array.length];
        for (int j = 0; j < array.length; j++){
            if(array[j] >= min && array[j] <= max) {
                out[firstUnusedPosition] = array[j];
                firstUnusedPosition++;
            }
        }

        return Arrays.copyOf(out,firstUnusedPosition);
    }

    // Zahlen in einem Array rotieren, nach vorne oder hinten
    public static void rotate(int[] array, int amount) {
        int length = array.length;

        if(length == 0) {
            return;
        }

        // Get rotation amount into range [0, array.length - 1]
        amount = amount % length;
        if(amount < 0) {
            amount += length;
        }

        // Rotate into new array
        int[] rotated = new int[length];
        for(int i = 0; i < length; i++) {
            rotated[(i + amount) % length] = array[i];
        }

        // Copy from this new array back into old one
        for(int i = 0; i < length; i++) {
            array[i] = rotated[i];
        }
    }

    //Die Anzahl jeder vorkommenden Zahl in einem Array zahlen und in einem 2d array geben
    public static int[][] quantities(int[] array) {
        int[][] quantitiesArray = new int[array.length][2];
        int nextPosition = 0;

        for(int i = 0; i < array.length; i++) {
            boolean isInQuantitiesArray = false;
            for(int j = 0; j < nextPosition; j++) {
                if(quantitiesArray[j][0] == array[i]) {
                    quantitiesArray[j][1]++;
                    isInQuantitiesArray = true;
                    break;
                }
            }

            if(!isInQuantitiesArray) {
                quantitiesArray[nextPosition] = new int[] { array[i], 1 };
                nextPosition++;
            }
        }

        // Cut of unnecessary parts
        int[][] reducedQuantitiesArray = new int[nextPosition][2];
        for(int i = 0; i < nextPosition; i++) {
            reducedQuantitiesArray[i] = quantitiesArray[i];
        }

        return reducedQuantitiesArray;
    }

    // Binary search of array
    public int binarySearch(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length-1;
        while(p1<=p2){
            int middle = (p1+p2)/2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[middle] < target){
                p1 = middle+1;
            }
            if(nums[middle] > target){
                p2 = middle-1;
            }

        }
        //if it didnt find, return -1
        return -1;
    }

    // Letzte Zahl in array um 1 hochmachen
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i>=0; i--){
            if (digits[i] < 9){
                digits[i] = digits[i] +1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] digitsNew = new int[digits.length+1];
        digitsNew[0] = 1;
        return digitsNew;

    }

    //Find index of a number in an array
    public static int findIndex(int[] nums, int target){
        //look for the correct index
        for(int i=0; i<nums.length; i++){
            if(nums[i] > target){
                return i;
            }
            if(nums[i] < target){
                if (i==nums.length-1){
                    return i+1;
                }
                //check if the next one is bigger, if so, thats the index
                // if not, keep checking
                if (nums[i+1] > target){
                    return i+1;
                }
                else{
                    //
                }
            }
        }
        return -1;
    }

    // two sum problem
    public int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        boolean solutionFound = false;
        int index = 0;
        A: while(!solutionFound){
            int firstNum = nums[index];
            for(int i = index+1; i<nums.length; i++){
                if (nums[i] + firstNum == target){
                    returnArray[0] = index;
                    returnArray[1] = i;
                    return returnArray;
                }
            }
            index+=1;
        }
        return null;
    }

    //print 1d array
    public static void print(int[] a) {
        System.out.print("{");

        if (a.length > 0) {
            System.out.print(a[0]);
            for (int i = 1; i < a.length; i++) {
                System.out.print(", " + a[i]);
            }
        }

        System.out.print("}");
    }

    //min and max of a 1d array
    public static void minAndMax1d(int[] a) {
        if (a.length == 0) {
            return;
        }

        int min = a[0];
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Minimum = " + min + ", Maximum = " + max);
    }

    //min and max of every element of 2d array
    public static int[][] minsAndMaxs(int[][] a) {
        int[][] out = new int[a.length][2];

        for (int i = 0; i < a.length; i++) {
            // 2D Arrays are arrays of arrays
            // so a[i] is an array
            out[i] = minAndMax(a[i]);
        }

        return out;
    }
    public static int[] minAndMax(int[] a) {
        if (a.length == 0) {
            return null;
        }

        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        return new int[]{min, max};
    }



    //check if an array is sorted with increasing order
    public static boolean isOrderedAscendingly(int[] a) {
        boolean isOrdered = true;
        for(int i = 0; i < a.length - 1; i++) {
            isOrdered &= a[i] <= a[i + 1];
        }
        return isOrdered;
    }

    //invert an array
    public static void invert(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            int symmetricalIndex = a.length - 1 - i;
            a[i] = a[symmetricalIndex];
            a[symmetricalIndex] = tmp;
        }
    }

    //resize an array
    public static int[] resize(int[] a, int length) {
        if (length <= 0) {
            return new int[0];
        }

        int[] resized = new int[length];

        for (int i = 0; i < length && i < a.length; i++) {
            resized[i] = a[i];
        }

        return resized;
    }

    //check if a value is in an array before its index
    private static boolean containsBeforeIndex(int[] a, int value, int index) {
        for(int i = 0; i < index; i++) {
            if(a[i] == value) {
                return true;
            }
        }
        return false;
    }

    //make 2d array into 1d array
    public static int[] linearize(int[][] a) {
        int linearizedlength = 0;

        for (int i = 0; i < a.length; i++) {
            linearizedlength += a[i].length;
        }

        int[] linearized = new int[linearizedlength];
        int linearizedIndex = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                linearized[linearizedIndex++] = a[i][j];
            }
        }

        return linearized;
    }


    //print 2d array
    public static void print2dArray(int[][] a){
        System.out.print("{");
        for (int i = 0; i<a.length; i++){
            print(a[i]);
        }
        System.out.println("}");
    }





    public static void main(String [] args){

    }

}
