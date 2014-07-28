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
    /////-------------DATA-----------------//
    private String username = "test13";
    private String password = "Insoft12";
    private String category = "Books";
    private String scategory="SPIEGEL-Bestseller";
    private String category1 = "Digital Cameras";
    private String category2="Computer";

    private String scategory1="Canon";
    private String scategory2="Casio";
    private String scategory2_1="Desktops";

    private String item1="Canon Digital IXUS 100 IS Digitalkamera silber";

    private String item2="Casio EXILIM EX-Z2 SR Digitalkamera";
    private String item3="Dell Vostro Desktop 470 MT";
    private String product  = "Winter World: The century saga.";
    private String qty="1";
    private String compare="Add to compare list";


    ////-----------end of data----------//
    @Test
    public void  verifyPaymentOptionShownAfterCheckOut()
    {

        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category);
        homePage.goToSubcategory(scategory);
        ListOfItemsPage listOfItemPage = new ListOfItemsPage();
        listOfItemPage.selectProduct(product);
        ProductPage productPage    = new ProductPage();
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.gotCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.gotoPayment();
        PaymentPage paymentPage=new PaymentPage();
        REPORTER.isTrue(paymentPage.isPaymentOptionsShown());
        homePage.logout();

    }
    @Test
    public void verifyUserCanCompareTheItemsWithoutLogin()
    {
        HomePage homepage=new HomePage();
        homepage.gotoCategory(category1);
        homepage.goToSubcategory(scategory1);
        ListOfItemsPage listOfItemsPage=new ListOfItemsPage();
        listOfItemsPage.selectProduct(item1);
        listOfItemsPage.addToComparelist(compare);
        homepage.gotoCategory(category1);
        homepage.goToSubcategory(scategory2);
        listOfItemsPage.selectProduct(item2);
        ProductPage productPage    = new ProductPage();
        productPage.addToComparelist(compare);
        productPage.goToComparelist();
        productPage.goToComparelistPage();
        ComparelistPage comparelistPage=new ComparelistPage();
        REPORTER.isTrue(comparelistPage.isItemCompared(item1,item2));


    }
    @Test
    public void verifyItemCanAddToCartFromWishlistPage()
    {
        HomePage homepage=new HomePage();
        homepage.gotoCategory(category1);
        homepage.goToSubcategory(scategory1);
        ListOfItemsPage listOfItemsPage =new ListOfItemsPage();
        listOfItemsPage.selectProduct(item1);
        ProductPage productPage    = new ProductPage();
        productPage.addToWishlist();
        productPage.goToWishlist();
        productPage.goToWishlistPage();
        WishlistPgae wishlistPage =new WishlistPgae();
        wishlistPage.addToCartFromWishlist();
        ShoppingCartPage shoppingCartPage =new ShoppingCartPage();
        REPORTER.isTrue(shoppingCartPage.isItemPresent(item1));

    }
    @Test
    public void verifyUserCanContinueTheShoppingAfterGoingToCart()
    {
        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category2);
        homePage.goToSubcategory(scategory2_1);
        ListOfItemsPage listOfItemPage = new ListOfItemsPage();
        listOfItemPage.selectProduct(item3);
        ProductPage productPage = new ProductPage();
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.continueTheShopping();
        REPORTER.isTrue(homePage.isUserInHomePage(scategory2_1));
        homePage.logout();
    }
    @Test
    public void verifyAfterLoggedOutAndLoggedInItemStillPresent()
    {
        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category2);
        homePage.goToSubcategory(scategory2_1);
        ListOfItemsPage listOfItemPage = new ListOfItemsPage();
        listOfItemPage.selectProduct(item3);
        ProductPage productPage = new ProductPage();
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.isItemPresent(item3);
        homePage.logout();
        homePage.gotoLogin();
        loginPage.loginAsConsumer(username,password);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        REPORTER.isTrue(shoppingCartPage.isItemPresent(item3));
        homePage.logout();

    }
    @Test
    public void  verifyUserCanConfirmTheOrderWithCashAfterDeliveryMethod()
    {

        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category);
        homePage.goToSubcategory(scategory);
        ListOfItemsPage listOfItemPage = new ListOfItemsPage();
        listOfItemPage.selectProduct(product);
        ProductPage productPage    = new ProductPage();
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.gotCheckOut();
        CheckOutPage checkOutPage = new CheckOutPage();
        checkOutPage.gotoPayment();
        PaymentPage paymentPage=new PaymentPage();
        paymentPage.confirmOrderWithCashAfterDeliveryMethod();
        paymentPage.acceptTerms();
        paymentPage.confirmOdrer();
        ConfirmationPage confirmationPage=new ConfirmationPage();
        REPORTER.isTrue(confirmationPage.isOrderConfirmed());
        homePage.logout();

    }



}
