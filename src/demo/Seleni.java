package demo;


public class Seleni extends PageObject{
	


	public static void main(String[] args) throws InterruptedException {
		System.out.println("hello moye");
        
        PageObject po = new PageObject();
//        po.locator();
//        po.seleniumP();
//		po.shouldScrollFromElementByGivenAmount();
//		po.shouldScrollFromElementByGivenAmountWithOffset();
//        po.shouldScrollFromViewportByGivenAmountFromOrigin();
//        po.handleAlerts();
 //       po.multipleBrowserScanner();
        po.windowsOperation();
        System.out.println("bye moye");
	}
	

}
