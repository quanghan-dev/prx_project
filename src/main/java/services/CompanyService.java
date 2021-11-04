package services;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import models.Company;

public class CompanyService {

    private static final String FILE_NAME = "project.xml";

    public Company Unmarshaller(String filepath) throws JAXBException {

        File f = new File(filepath + FILE_NAME);

        Company company;

        JAXBContext context;
        context = JAXBContext.newInstance(Company.class);

        javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
        company = (Company) unmarshaller.unmarshal(f);

        System.out.println(company);

        return company;
    }

    public void Marshaller(Company company, String filepath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(company, new File(filepath + FILE_NAME));
    }

}
