package org.dieschnittstelle.jee.esa.crm.ejbs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.logging.Logger;

@ApplicationPath("/rest")
public class CrmRESTApplication extends Application {

	protected static Logger logger = LoggerFactory.getLogger(CrmRESTApplication.class);
	
	public CrmRESTApplication() {
		logger.info("<constructor>");
	}
	
}
