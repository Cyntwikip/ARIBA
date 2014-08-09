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
        if(!name.matches("[- \\w&&[\\D]]*")){
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
        if(!contact.matches("^(09+(05|06|15|16|17|25|26|27|35|36|37|96|97"
                + "|07|08|09|10|12|18|19|20|21|28|29|30|38|39|89|99|48|"+ 
                             "|22|23|32|33))+\\d{7}$")){
            throw new AccountException(field, contact);
        }
    }
}
