package org.dieschnittstelle.jee.esa.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.13
 * 2015-09-16T11:06:28.558+02:00
 * Generated source version: 2.7.13
 * 
 */
@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", name = "TouchpointCRUDWebServiceSOAP")
@XmlSeeAlso({org.dieschnittstelle.jee.esa.crm.entities.ObjectFactory.class, ObjectFactory.class})
public interface TouchpointCRUDWebServiceSOAP {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "readAllTouchpoints", targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", className = "org.dieschnittstelle.jee.esa.jaxws.ReadAllTouchpoints")
    @WebMethod
    @ResponseWrapper(localName = "readAllTouchpointsResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", className = "org.dieschnittstelle.jee.esa.jaxws.ReadAllTouchpointsResponse")
    public java.util.List<org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint> readAllTouchpoints();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", className = "org.dieschnittstelle.jee.esa.jaxws.CreateTouchpoint")
    @WebMethod
    @ResponseWrapper(localName = "createTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", className = "org.dieschnittstelle.jee.esa.jaxws.CreateTouchpointResponse")
    public org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint createTouchpoint(
        @WebParam(name = "arg0", targetNamespace = "")
        org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteTouchpoint", targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", className = "org.dieschnittstelle.jee.esa.jaxws.DeleteTouchpoint")
    @WebMethod
    @ResponseWrapper(localName = "deleteTouchpointResponse", targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", className = "org.dieschnittstelle.jee.esa.jaxws.DeleteTouchpointResponse")
    public boolean deleteTouchpoint(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0
    );
}
