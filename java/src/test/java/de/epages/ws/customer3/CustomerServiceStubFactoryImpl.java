package de.epages.ws.customer3;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.epages.ws.StubConfigurator;
import de.epages.ws.WebServiceConfiguration;
import de.epages.ws.customer3.stub.Bind_Customer_SOAPStub;
import de.epages.ws.customer3.stub.CustomerService;
import de.epages.ws.customer3.stub.Port_Customer;

final class CustomerServiceStubFactoryImpl implements CustomerServiceStubFactory {



    @Override
    public Port_Customer create(WebServiceConfiguration config, CustomerService service) {
        
        try {
            Bind_Customer_SOAPStub stub = (Bind_Customer_SOAPStub) service.getport_Customer(config.getWebserviceURL());
            if (stub == null) {
                throw new NullPointerException("stub");
            }
            return StubConfigurator.configure(stub, config);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

}
