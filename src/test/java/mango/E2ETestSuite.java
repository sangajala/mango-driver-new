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
        homePage.gotoCatagory(category);
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
}
