/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mongodb.client.FindIterable; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClient;
import org.bson.Document;
import java.util.Iterator;
import com.mongodb.MongoCredential; 

/**
 *
 * @author Akshat Singhal
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
     private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
            LoginForm formbean= (LoginForm)form;
            String name = formbean.getName();
            String regno = formbean.getRegno();
            String phone = formbean.getPhone();
            
            MongoClient mongo = new MongoClient("localhost",27017);
            MongoCredential credentials;
            credentials = MongoCredential.createCredential("akshat", "javadb", "password".toCharArray());
            MongoDatabase database = mongo.getDatabase("javadb");
            System.out.println("Your credentials are -  "+credentials);

            //database.createCollection("userdetails");
            System.out.println("Collection created Successfully");

            MongoCollection<Document> collection = database.getCollection("userdetails");
            FindIterable<Document> iterdoc = collection.find();
            Iterator it = iterdoc.iterator();
            
            int count=0;
            while(it.hasNext() && count==0)
            {
                Document doc = (Document)it.next();
                String namet = doc.get("name").toString();
                String regt = doc.get("reg").toString();
                String phonet = doc.get("phone").toString();
                if(namet.equalsIgnoreCase(name) && phonet.equalsIgnoreCase(phone) && regt.equalsIgnoreCase(regno))
                {
                    return mapping.findForward(SUCCESS);
                }
            }
            formbean.setError("Invalid");
            return mapping.findForward(FAILURE);
    }
}
