/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models.DAOInterface;

import Models.Beans.DormBillBean;
import java.util.ArrayList;
/**
 *
 * @author adrian
 */
public interface DormBillDAOInterface {
    public boolean addDormBill(DormBillBean dorm);
    public boolean editDormBill(DormBillBean dorm);
    public ArrayList<DormBillBean> getAllDormBills();
    public DormBillBean getDormBillByID(int dormID);
    public DormBillBean getDormBillByMonthandYear(java.sql.Date date);
    
}
