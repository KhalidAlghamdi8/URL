import com.sun.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/**
 *
 * @author dev
 */
public class URL {

    public URL(String url) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
            
          String data=  getData("https://jsonplaceholder.typicode.com/users/1");
         
            JSONObject jsonObj=new JSONObject(data);
            
            String username=jsonObj.getString("username");
            System.out.println(username);
            
            JSONObject address=jsonObj.getJSONObject("address");
            
           String city= address.getString("city");
        
            System.out.println(city);
           
          //System.out.println(data);
            
        } catch (Exception e) {
        }
        
    }
    
    
    
    static String getData(String url)throws Exception{
    
        URL u=new URL(url);
            
        HttpsURLConnection conn=(HttpsURLConnection) u.openConnection();
            
        InputStream is=conn.getInputStream();
          
            
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            
            String line=br.readLine();
            String data="";
            while (line!=null) {                
                data+= line +"\n";
                line=br.readLine();
            }
            
            
        return data;
    }
    
}