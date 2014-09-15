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
    //creating object//

    HomePage homePage = new  HomePage();
    LoginPage loginPage = new LoginPage();
    ListOfItemsPage listOfItemPage = new ListOfItemsPage();
    ProductPage productPage    = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    PaymentPage paymentPage=new PaymentPage();
    ComparelistPage comparelistPage=new ComparelistPage();
    WishlistPgae wishlistPage =new WishlistPgae();
    ConfirmationPage confirmationPage=new ConfirmationPage();


    @Test
    public void  verifyPaymentOptionShownAfterCheckOut()
    {
        HomePage homePage = new  HomePage();
        homePage.gotoLogin();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category);
        homePage.goToSubcategory(scategory);
        listOfItemPage.selectProduct(product);
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        shoppingCartPage.gotCheckOut();
        checkOutPage.gotoPayment();
        REPORTER.isTrue(paymentPage.isPaymentOptionsShown());
        homePage.logout();

    }
    @Test
    public void verifyUserCanCompareTheItemsWithoutLogin()
    {

        homePage.gotoCategory(category1);
        homePage.goToSubcategory(scategory1);
        listOfItemPage.selectProduct(item1);
        listOfItemPage.addToComparelist(compare);
        homePage.gotoCategory(category1);
        homePage.goToSubcategory(scategory2);
        listOfItemPage.selectProduct(item2);
        productPage.addToComparelist(compare);
        productPage.goToComparelist();
        productPage.goToComparelistPage();
        REPORTER.isTrue(comparelistPage.isItemCompared(item1,item2));


    }
    @Test
    public void verifyItemCanAddToCartFromWishlistPage()
    {

        homePage.gotoCategory(category1);
        homePage.goToSubcategory(scategory1);
        listOfItemPage.selectProduct(item1);
        productPage.addToWishlist();
        productPage.goToWishlist();
        productPage.goToWishlistPage();
        wishlistPage.addToCartFromWishlist();
        REPORTER.isTrue(shoppingCartPage.isItemPresent(item1));

    }
    @Test
    public void verifyUserCanContinueTheShoppingAfterGoingToCart()
    {

        homePage.gotoLogin();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category2);
        homePage.goToSubcategory(scategory2_1);
        listOfItemPage.selectProduct(item3);
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        shoppingCartPage.continueTheShopping();
        REPORTER.isTrue(homePage.isUserInHomePage(scategory2_1));
        homePage.logout();
    }
    @Test
    public void verifyAfterLoggedOutAndLoggedInItemStillPresent()
    {
        homePage.gotoLogin();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category2);
        homePage.goToSubcategory(scategory2_1);
        listOfItemPage.selectProduct(item3);
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
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

        homePage.gotoLogin();
        loginPage.loginAsConsumer(username,password);
        homePage.gotoCategory(category);
        homePage.goToSubcategory(scategory);
        listOfItemPage.selectProduct(product);
        productPage.addProductToBasket(qty);
        productPage.goToBasket();
        productPage.gotoShoppingCart();
        shoppingCartPage.gotCheckOut();
        checkOutPage.gotoPayment();
        paymentPage.confirmOrderWithCashAfterDeliveryMethod();
        paymentPage.acceptTerms();
        paymentPage.confirmOdrer();
        REPORTER.isTrue(confirmationPage.isOrderConfirmed());
        homePage.logout();

    }



}
