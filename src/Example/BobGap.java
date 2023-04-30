package Example;

public class BobGap {
    public static void main(String[] args) {
        int fork = 8000;
        int noodle = 6000;
        int mandoo = 5000;

        int[] numbers = new int[3];
        for(int i=0; i<3; i++){
            numbers[i] = i+12;
        }

//        System.out.println(numbers[1]);
        System.out.printf("돈가스 x %d = %d \n", numbers[0], numbers[0]*fork);
        System.out.printf("칼국수 x %d = %d \n", numbers[1], numbers[1]*noodle);
        System.out.printf("왕만두 x %d = %d \n", numbers[2], numbers[2]*mandoo);

    }
}
