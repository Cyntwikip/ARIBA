
import Models.Beans.BillBean;
import Models.Beans.ElectricReadingBean;
import Models.DAOImplementation.BillDAOImplementation;
import Models.DAOImplementation.ElectricReadingDAOImplementation;
import java.io.FileInputStream;
import java.sql.Date;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danica
 */
public class MainMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FileInputStream fin = null;
        //try {
            // TODO code application logic here
            
            //testing blob
            /*
            FileItem photo;
            File imgfile = new File("C:\\Users\\Danica\\Documents\\heart.png");
            fin = new FileInputStream(imgfile);
            
            Blob image = (Blob) fin;
            
            TenantDAOImplementation dao = new TenantDAOImplementation();
            TenantBean bean = new TenantBean();
            
            Date date = new Date(1996-01-27);
            
            
            bean.setAddress("Manila");
            bean.setBirthday((java.sql.Date) date);
            bean.setContact("09274672839");
            bean.setDegree("CS-NE");
            bean.setEmail("dccorpuz1@yahoo.com");
            bean.setExpectedyearofgrad(2016);
            bean.setFname("Danica");
            bean.setGender("Female");
            bean.setLname("Corpuz");
            bean.setSchool("DLSU");
            bean.setStatus("Current");
            bean.setImage(image);
            
            dao.addTenant(bean);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
        
        BillBean bill = new BillBean();
        BillDAOImplementation bdao = new BillDAOImplementation();
        
        bill.setBill_roomID(1);
        bill.setPaidElectric(true);
        bill.setPaidRent(true);
        bill.setPaidWater(true);
        bill.setPrice(0);
        
        bdao.addBill(bill);
        
        ElectricReadingBean bean = new ElectricReadingBean();
        ElectricReadingDAOImplementation dao = new ElectricReadingDAOImplementation();
        
        bean.setCurrentKW(10);
        bean.setElectric_billID(1);
        bean.setPrice(10);
        bean.setPriceperKW(10);
        Date date = new Date(2014-07-26);
        bean.setDateRead(date);
        
        dao.addElectricReadingToRoom(bean, 1);
        
    }
    
}
