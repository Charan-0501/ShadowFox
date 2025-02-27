import org.example.Entity_BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Testing {

    public void testCreateAccount(){
        Entity_BankAccount account ;
        account=new Entity_BankAccount("sunny",1500,7386215653L,"hyderabad");

        assertNotNull(account);
        assertEquals("sunny",account.getAccountHolderName());
        assertEquals(1500,account.getBalanceAmount());
    }




}
