package mango;

import mango.utils.REPORTER;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class E2ETestSuite extends baseTestSuite{
    private String username = "test13";
    private String password = "Insoft12";
    private String category = "Books";
    private String category1 = "Digital Cameras";
    private String category2="Computer";
    private String comp_s_category1="Desktops";
    private String item3="Dell Vostro Desktop 470 MT";
    private String scategory1="Canon";
    private String scategory2="Casio";
    private String item1="Canon Digital IXUS 100 IS Digitalkamera silber";
    private String item2="Casio EXILIM EX-Z2 SR Digitalkamera";
    private String product  = "Fast Cars, Picture Calendar 2013";
    private int qty=1;
    /////-------------DATA-----------------//

    ////-----------end of data----------//
    @Test
    public void  verifyPaymentOptionShownAfterCheckOut()
    {

        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category);
        ListOfItemsPage listOfItemPage = new ListOfItemsPage();
        listOfItemPage.selectProduct(product);
        ProductPage productPage    = new ProductPage();
        productPage.addProductToBasket(qty);
        productPage.gotoShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.checkOutBasket();
        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.gotoPayment();
        PaymentPage paymentPage=new PaymentPage();
        REPORTER.isTrue(paymentPage.isPaymentOptionsShown());

    }
    @Test
    public void verifyUserCanCompareTheItemsWithoutLogin()
    {
        HomePage homepage=new HomePage();
        homepage.gotoCategory(category1);
        homepage.goToSubcategory(scategory1);
        ListOfItemsPage listOfItemsPage=new ListOfItemsPage();
        listOfItemsPage.goToProduct(item1);
        listOfItemsPage.addToComparelist();
        homepage.gotoCategory(category1);
        homepage.goToSubcategory(scategory2);
        listOfItemsPage.goToProduct(item2);
        listOfItemsPage.addToComparelist();
        listOfItemsPage.goToComparelist();
        ComparelistPage comparelistPage=new ComparelistPage();
        REPORTER.isTrue(comparelistPage.isItemCompared());


    }
    @Test
    public void verifyItemCanAddToCartFromWishlistPage()
    {
        HomePage homepage=new HomePage();
        homepage.gotoCategory(category2);
        homepage.goToSubcategory(comp_s_category1);
        ListOfItemsPage listOfItemsPage =new ListOfItemsPage();
        listOfItemsPage.goToProduct(item3);
        listOfItemsPage.addToWishlist();
        listOfItemsPage.goToWishlist();
        WishlistPgae wishlistPage =new WishlistPgae();
        wishlistPage.addToCartFromWishlist();
        ShoppingCartPage shoppingCartPage =new ShoppingCartPage();
        REPORTER.isTrue(shoppingCartPage.isItemPresent());

    }
    @Test
    public void verifyUserCanContinueTheShoppingAfterGoingToCart()
    {
        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category2);
        ListOfItemsPage listOfItemPage = new ListOfItemsPage();
        listOfItemPage.selectProduct(item3);
        ProductPage productPage = new ProductPage();
        productPage.addProductToBasket(qty);
        productPage.gotoShoppingCart();
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.continueTheShopping();
        REPORTER.isTrue(homePage.isUserInHomePage());
    }
    @Test


}
