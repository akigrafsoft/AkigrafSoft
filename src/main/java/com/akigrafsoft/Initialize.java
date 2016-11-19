/**

 * (c) Copyright 2014-2020, AkiGrafSoft All rights reserved.
 *
 * LEGAL NOTICE:  This source code is provided to specific authorized end
 * users pursuant to a separate license agreement.  You MAY NOT use this
 * source code if you do not have a separate license from AkiGrafSoft.
 * Except as expressly set forth in such license agreement, this
 * source code, or any portion thereof, may not be used, modified,
 * reproduced, transmitted, or distributed in any form or by any means,
 * electronic or mechanical, without written permission from AkiGrafSoft.
 *
 * $Id:  $
 *
 **/
package com.akigrafsoft;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

import com.akigrafsoft.kwebplatform.AuthorizationController;
import com.akigrafsoft.kwebplatform.Configuration;
import com.akigrafsoft.kwebplatform.Utils;

public class Initialize implements javax.servlet.ServletContextListener {

	private static org.apache.log4j.Logger logger = Logger.getLogger(Initialize.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		InitialContext initialContext;
		String configurationFile = null;
		try {
			initialContext = new javax.naming.InitialContext();
			configurationFile = (String) initialContext.lookup("java:comp/env/configurationFile");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		Properties props = Utils.getConfigProperties(configurationFile);
		if (props != null) {
			Configuration.init(props);
		} else {
			logger.warn("Context configurationFile is not set !");
		}

		AuthorizationController.INSTANCE.init(props);

		// try {
		// PagedListsController.INSTANCE.registerPagedListFactory("Users", new
		// PagedListFactory() {
		// @Override
		// public PagedList<?> createPagedList(String sessionId, int pageSize,
		// final JSONObject searchCriteriasBase, String... parameters) {
		// return new UsersPagination(pageSize);
		// }
		// });
		// } catch (ExceptionDuplicate e) {
		// logger.error("ExceptionDuplicate:" + e.getMessage());
		// e.printStackTrace();
		// }
	}

}
