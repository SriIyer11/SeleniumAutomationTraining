package assignments;

public class AddItemsCheckOutTest
{

	public static void main(String[] args)
	
	{
		BaseClass base = new BaseClass();
		LoginPage logpage = new LoginPage();
		HomePage hmepage = new HomePage();
		Apashoes apashoe = new Apashoes();
		ShopCart shpcart = new ShopCart();
		CartPage crtpage = new CartPage();
		
		base.initialize(); // to initialize driver and launch browser
		hmepage = logpage.login_HomePage("dummyperson508@gmail.com", "Abc@1234");
		apashoe = hmepage.click_Apashoes();
		apashoe.SortBy_SelectValue("Name: Z to A");
		shpcart = apashoe.ApparelShoesClick();
		crtpage = shpcart.Check_Out();
		crtpage.fill_CartDetails();
	}

}
