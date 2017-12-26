package framework.helper;


import framework.datalayer.*;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;

import framework.datalayer.*;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;

public class EmailHandler {

	private String eMailAdrs = "";
	private String eMailPswd = "";
	private String storeType = "";
	private String portNumber = "";

	// private String activationLink = "";
	private String emailBody = "";

	public EmailHandler(String emailID, String emailPswd) {
		this.eMailPswd = emailPswd;
		this.eMailAdrs = emailID;
		if (emailID.contains("+"))
			this.eMailAdrs = emailID.split("\\+")[0] + "@" + emailID.split("\\+")[1].split("@")[1];

	}

	public String FetchResetPasswordURL() throws MessagingException, IOException {
		String activationLink = "";

		// String emailID = userName;
		// String emailPswd = psWd;

		String expectedEmailAddress = this.eMailAdrs;
		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		// Flag flag = null;
		String expectedEmailSubject = "Reset Password";

		String expectedEmailBodyLine = ".happygrasshopper.com";

		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);
			//awais+938937@gmail.comm

			store = session.getStore("imaps");
			store.connect("imap.googlemail.com", this.eMailAdrs, this.eMailPswd);

			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }

			folder = (IMAPFolder) store.getFolder("INBOX");

			if (!folder.isOpen())
				folder.open(Folder.READ_ONLY);
			Message[] messages = folder.getMessages();
			// System.out.println("No of Messages : " +
			// folder.getMessageCount());
			// System.out.println("No of Unread Messages : " +
			// folder.getUnreadMessageCount());
			// System.out.println(messages.length);
			for (int i = messages.length - 1; i < messages.length; i--) {

				Message msg = messages[i];
				subject = msg.getSubject();
				Address targetEmailAddress = msg.getAllRecipients()[0];
				// &&
				// targetEmailAddress.toString().contains(expectedEmailAddress)

				if (subject.contains(expectedEmailSubject)) {
					processMessageBody(msg);

					Scanner scanner = new Scanner(emailBody);
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						if (line.contains(expectedEmailBodyLine)) {
							activationLink = line;
							break;
						}
					}
					scanner.close();

					String[] tempLinks = activationLink.split("<br");
					activationLink = tempLinks[0];
					break;
				}

			}
		} finally {
			if (folder != null && folder.isOpen()) {
				folder.close(true);
			}
			if (store != null) {
				store.close();
			}
		}
		return activationLink;

	}

	public String FetchSignUpLink() throws MessagingException, IOException {
		String activationLink = "";

		// String emailID = userName;
		// String emailPswd = psWd;

		String expectedEmailAddress = this.eMailAdrs;
		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		// Flag flag = null;
		String expectedEmailSubject = "Reset Password";

		String expectedEmailBodyLine = "jobularity.com/admin/token";

		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			store = session.getStore("imaps");
			store.connect("imap.googlemail.com", this.eMailAdrs, this.eMailPswd);

			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }

			folder = (IMAPFolder) store.getFolder("INBOX");

			if (!folder.isOpen())
				folder.open(Folder.READ_ONLY);
			Message[] messages = folder.getMessages();
			// System.out.println("No of Messages : " +
			// folder.getMessageCount());
			// System.out.println("No of Unread Messages : " +
			// folder.getUnreadMessageCount());
			// System.out.println(messages.length);
			for (int i = messages.length - 1; i < messages.length; i--) {

				Message msg = messages[i];
				subject = msg.getSubject();
				Address targetEmailAddress = msg.getAllRecipients()[0];
				// &&
				// targetEmailAddress.toString().contains(expectedEmailAddress)

				if (subject.contains(expectedEmailSubject)) {
					processMessageBody(msg);

					Scanner scanner = new Scanner(emailBody);
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						if (line.contains(expectedEmailBodyLine)) {
							activationLink = line;
							break;
						}
					}
					scanner.close();

					String[] tempLinks = activationLink.split("<br");
					activationLink = tempLinks[0];
					break;
				}

			}
		} finally {
			if (folder != null && folder.isOpen()) {
				folder.close(true);
			}
			if (store != null) {
				store.close();
			}
		}
		return activationLink;

	}

	private void procesMultiPart(Multipart content) {
		try {
			int multiPartCount = content.getCount();
			for (int i = 0; i < multiPartCount; i++) {
				BodyPart bodyPart = content.getBodyPart(i);
				Object o;
				o = bodyPart.getContent();
				if (o instanceof String) {
					// System.out.println(o);
					emailBody += o.toString();
				} else if (o instanceof Multipart) {
					procesMultiPart((Multipart) o);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void processMessageBody(Message message) {
		try {
			Object content = message.getContent();
			// check for string // then check for multi-part
			if (content instanceof String) {
				emailBody += content.toString();
				// System.out.println(content);

			} else if (content instanceof Multipart) {
				Multipart multiPart = (Multipart) content;
				procesMultiPart(multiPart);
			} else if (content instanceof InputStream) {
				InputStream inStream = (InputStream) content;
				int ch;
				while ((ch = inStream.read()) != -1) {
					// System.out.write(ch);
					emailBody += Integer.toString(ch);
				}
				inStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
