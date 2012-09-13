/**
 * 
 */
package hudson.scm;

import org.tmatesoft.svn.core.SVNErrorMessage;
import org.tmatesoft.svn.core.internal.wc.SVNExternal;
import org.tmatesoft.svn.core.wc.SVNEventAction;

/**
 * @author schristou88
 *
 */
public class SVNEvent extends org.tmatesoft.svn.core.wc.SVNEvent {

	public SVNEvent(SVNErrorMessage errorMessage, SVNEventAction expected) {
		super(errorMessage, expected);
	}
	
	public SVNExternal getExternalInfo() {
		return myExternalInfo;
	}
	
	public SVNExternal getPreviousExternalInfo() {
		return myPreviousExternalInfo;
	}
	
	public SVNEvent setExternalInfo(SVNExternal prev, SVNExternal _new) {
		this.myPreviousExternalInfo = prev;
		this.myExternalInfo = _new;
		return this;
	}

	private SVNExternal myExternalInfo;
	private SVNExternal myPreviousExternalInfo;
	
}
