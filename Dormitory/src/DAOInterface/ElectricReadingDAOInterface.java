/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.ElectricReadingBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ElectricReadingDAOInterface {
    public boolean addElectricReadingToRoom (ElectricReadingBean electric, int bill_roomID);
    public ArrayList<ElectricReadingBean> getAllElectricReading();
    public ArrayList<ElectricReadingBean> getAllElectricReadingByRoomID(int bill_roomID);
}
