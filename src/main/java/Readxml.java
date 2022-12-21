import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.ServerError;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Readxml {

    public static void main(String[] args) {
        File file = new File("");
        File oppath = new File("");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
            String path= f.getPath();
            System.out.println(path);
            validateXMLSchema("", path);

            File destpath = new File("");



        }




    }



    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}