package hudson.scm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.wc.admin.SVNTranslator;

public class SVNSSLAuthentication extends org.tmatesoft.svn.core.auth.SVNSSLAuthentication {
	
	public SVNSSLAuthentication(File certFile, String password, boolean storageAllowed, SVNURL url, boolean isPartial) throws IOException {
		super(ISVNAuthenticationManager.SSL, null, storageAllowed, url, isPartial);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream in = new FileInputStream(certFile);
		try {
			SVNTranslator.copy(in,baos);
		} finally {
			in.close();
		}
		myCertificate = baos.toByteArray();
		myPassword = password;
	}
	
	public SVNSSLAuthentication(File certFile, String password, boolean storageAllowed) throws IOException {
		this(certFile,password,storageAllowed,null,false);
	}

	public SVNSSLAuthentication(byte[] certFile, String password, boolean storageAllowed) {
		this(certFile,password,storageAllowed,null,false);
	}
	
	public SVNSSLAuthentication(byte[] certFile, String password, boolean storageAllowed, SVNURL url, boolean isPartial) {
		super(ISVNAuthenticationManager.SSL, null, storageAllowed, url, isPartial);
		myCertificate = certFile;
		myPassword = password;
		mySSLKind = SSL;
	}
	
	/**
	 * 
	 * @return cetificate file as a byte array
	 */
	public byte[] getCertificateByteArray() {
		return myCertificate;
	}
	
	@Override
	public void setCertificatePath(String path) {
		super.setCertificatePath(path);
		
		myCertificatePath = path;
	}
	
	@Override
	public String getSSLKind() {
		return mySSLKind;
	}
	
	@Override
	public String getPassword() {
		return myPassword;
	}
	
	@Override
	public String getCertificatePath() {
		return myCertificatePath;
	}
	
	private String myPassword;
	private String mySSLKind;
	private byte[] myCertificate;
	private String myCertificatePath;
}
