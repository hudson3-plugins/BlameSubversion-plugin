package hudson.scm;

public interface ISVNAuthenticationManager extends org.tmatesoft.svn.core.auth.ISVNAuthenticationManager{
	
	/**
	 * Sets the listener that gets invoked every time {@link #acknowledgeAuthentication(boolean, String, String, SVNErrorMessage, SVNAuthentication)}
     * is called.
	 */
	public void setAuthenticationOutcomeListener(ISVNAuthenticationOutcomeListener listener);
}
