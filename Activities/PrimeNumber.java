package Activities;

// Paul Casigay
public class PrimeNumber {
    public static void main(String[] args) {
        int num = 11;

        boolean isPrimeNumber = isPrimeNumber(num);
        System.out.println(isPrimeNumber);

    }

    static boolean isPrimeNumber(int num) {
        boolean isPrimeNumber = true;
        if ((num % 2 == 0) && (num != 2)) {
            return false;
        }
        for (int i = 3; i < num; i += 2) {
            if ((num % i == 0) && (i != num)) {
                isPrimeNumber = false;
                // break;
            }
        }
        return isPrimeNumber;
    }

}
