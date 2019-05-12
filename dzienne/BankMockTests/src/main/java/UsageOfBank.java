import biz.AccountManager;
import model.Account;
import model.User;

/**
 * Created by Krzysztof Podlaski on 01.04.2019.
 */
public class UsageOfBank {

    public static void main(String[] args) {
        AccountManager am = AccountManager.buildBank();
        try {
            boolean success =
                    am.logIn("Adam", "Adam".toCharArray());
            System.out.println("Udało się zalogować " + success);
            User adam = am.getLoggedUser();
            success = am.paymentIn(adam,100,
                    "Wpłata na konto",1);
            System.out.println(success);
            success = am.paymentOut(adam,150,"Wypłąta 150",1);
            System.out.println(success);
            success = am.paymentOut(adam,1500,"Wypłata 1500",2);
            System.out.println(success);
        }
        catch(Exception e){
            System.err.println(e);
        }
    }


}
