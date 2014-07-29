/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorHandling;

/**
 *
 * @author adrian
 */
public class CheckAccount {

    public CheckAccount() {

    }
    
    public void checkName(String name, String field) throws AccountException{
        if(!name.matches("[\\w&&[\\D]]*")){
            throw new AccountException(field);
        }
    }
    
    public void checkEmail(String email, String field)throws AccountException{
        if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*" +
                "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new AccountException(field);
        } 
    }
    
    public void checkContact(String contact, String field) throws AccountException{
        if(!contact.matches("^(09+(22|22|25|06|07|15|17|26|27|"+
                             "10|18|19|20|21|28|12))+\\d{7}$")){
            throw new AccountException(field);
        }
    }
}
