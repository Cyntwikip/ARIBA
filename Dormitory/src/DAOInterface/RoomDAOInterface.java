/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOInterface;

import Beans.RoomBean;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface RoomDAOInterface {
    
    // do something here
    public boolean addRoom(RoomBean room);
    public ArrayList<RoomBean> getAllRooms();
    
}
