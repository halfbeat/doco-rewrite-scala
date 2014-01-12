package org.eclipse.persistence.customizers;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.DatabaseLogin;
import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.server.ServerSession;

import javax.naming.InitialContext;

/**
 * See http://wiki.eclipse.org/Customizing_the_EclipseLink_Application_(ELUG)
 * Use for clients that would like to use a JTA SE pu instead of a
 * RESOURCE_LOCAL SE pu.
 */
public class JPAEclipseLinkSessionCustomizer implements SessionCustomizer {

	/**
	 * Get a dataSource connection and set it on the session with
	 * lookupType=STRING_LOOKUP
	 */
	public void customize(Session session) throws Exception {
		JNDIConnector connector = null;
		try {
			new InitialContext();
			connector = (JNDIConnector) session.getLogin().getConnector(); // possible
			connector.setLookupType(JNDIConnector.STRING_LOOKUP);
			JNDIConnector writeConnector = (JNDIConnector) session.getLogin()
					.getConnector();
			writeConnector.setLookupType(JNDIConnector.STRING_LOOKUP);
			JNDIConnector readConnector = (JNDIConnector) ((DatabaseLogin) ((ServerSession) session)
					.getReadConnectionPool().getLogin()).getConnector();
			readConnector.setLookupType(JNDIConnector.STRING_LOOKUP);

			System.out.println("_JPAEclipseLinkSessionCustomizer: configured "
					+ connector.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
