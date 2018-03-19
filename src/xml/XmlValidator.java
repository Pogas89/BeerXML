package xml;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlValidator extends DefaultHandler {
    private String xmlFileName;
    private String xsdFileName;
    List<Exception> exceptions = new ArrayList<>();

    public XmlValidator(String xmlFileName, String xsdFileName) {
        this.xmlFileName = xmlFileName;
        this.xsdFileName = xsdFileName;
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        exceptions.add(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        exceptions.add(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        exceptions.add(e);
    }

    public String getError() {
        if (!exceptions.isEmpty()) {
            return exceptions.toString();
        }
        return null;
    }

    public boolean validate() {
        try {
            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).
                    newSchema(new File(xsdFileName)).newValidator();
            validator.setErrorHandler(this);
            try {
                validator.validate(new StreamSource(xmlFileName));
            } catch (IOException e) {
                e.getMessage();
            }
            return (getError() == null);
        } catch (SAXException ex) {
            exceptions.add(ex);
            return false;
        }
    }
}
