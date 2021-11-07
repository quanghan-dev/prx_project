package services;

import java.io.File;
import java.nio.file.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import models.Company;

public class CompanyService {

    private static final String FILE_NAME = "project.xml";
    
    public Company UnmarshallerCompany(String filepath) throws JAXBException {

        File f = new File(filepath + FILE_NAME);
        JAXBContext context = JAXBContext.newInstance(Company.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Company company = (Company) unmarshaller.unmarshal(f);
        return company;
    }

    public void MarshallerCompany(Company company, String filepath) throws JAXBException {
        
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(company, new File(filepath + FILE_NAME));
    }

}
