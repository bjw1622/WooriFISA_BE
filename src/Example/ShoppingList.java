package Example;

public class ShoppingList {
    public static void main(String[] args) {
        String[] itemNames = {"한우 꽃등심", "참치 선물팩", "맥스봉 한팩"};
        int[] itemPrices = {112500, 25500, 500};

        System.out.println("품명: " + itemNames[0] + "  가격: " + itemPrices[0]);
        System.out.printf("품명: %s  가격 : %d \n", itemNames[1], itemPrices[1]);
        System.out.printf("품명: %s  가격 : %d \n", itemNames[2], itemPrices[2]);
    }
}
