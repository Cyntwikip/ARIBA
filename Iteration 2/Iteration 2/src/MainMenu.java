
import Models.Beans.TenantBean;
import Models.DAOImplementation.TenantDAOImplementation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;



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
        
    }
    
}
