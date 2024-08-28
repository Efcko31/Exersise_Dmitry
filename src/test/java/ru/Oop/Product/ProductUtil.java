package ru.Oop.Product;

public class ProductUtil {
    public static void printProducts(Category... categories) {
        for (Category category : categories) {
            System.out.println("\n" + category.getName() + ":\n");
            for (int j = 0; j < category.getProducts().size(); j++) {
                System.out.printf("%s, цена: %.2f, рейтинг: %.1f;\n",
                        category.getProducts().get(j).name,
                        category.getProducts().get(j).price,
                        category.getProducts().get(j).rating);
            }
        }
    }

    public static void printUserBasket(User... users) {
        for (User user : users) {
            System.out.println("\n" + user.getLogin() + "\nТовары в корзине:\n");
            for (int j = 0; j < user.getBasket().getProductsForPurchase().size(); j++) {
                System.out.printf(j + 1 + ")" + "%s, цена: %.2f, рейтинг: %.1f;\n",
                        user.getBasket().getProductsForPurchase().get(j).name,
                        user.getBasket().getProductsForPurchase().get(j).price,
                        user.getBasket().getProductsForPurchase().get(j).rating);
            }
        }
    }
}
