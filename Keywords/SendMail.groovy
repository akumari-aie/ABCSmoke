
import javax.activation.DataHandler
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import com.kms.katalon.core.annotation.Keyword

//import internal.GlobalVariable as GlobalVariable


class SendMail {

	def iteratingFailedTestCases(Map failedTCs){
		def mailBody =""
		String key
		String value
		int serialNo = 1
		for (entry in failedTCs) {
			key = entry.key
			value= entry.value;
			String[] testcaseID = key.split("/");
			String[] valueLines = value.split("\\r?\\n");
			mailBody += "  <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>";
			mailBody += "  <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "  <p class=MsoNormal align=center style='text-align:center'>" + serialNo + "</p>";
			mailBody += "  </td>";
			mailBody += "  <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "  <p class=MsoNormal align=center style='text-align:center'>" +testcaseID[2]+ "</p>";
			mailBody += "  </td>";
			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'>" +testcaseID[3]+"</p>";
			mailBody += "   </td>";
			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'>"+valueLines[2]+"</p>";
			mailBody += "   </td>";
			mailBody += "  </tr>";
			serialNo++;
		}
		return mailBody;
	}

	@Keyword
	def sendMail(int total, int passed, int failed, int error, int skipped, Map failedTCs) {

		String host="smtp.office365.com";
		final String from = "akumari@aienterprise.com";
		//final String from = GlobalVariable.Email_from;
		final String password="Anzaie@1234";
		//String to = "kkulkarni@aienterprise.com,Jgopala@aienterprise.com";
			String to = "jyotianamika94@gmail.com";

		//Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from,password);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Automation Execution Report:- ABC Smoke");

			def totalNumberOfTestCases =total;
			def totalTestCasesPassed = passed;
			def totalTestCasesFailed = failed;
			def totalError = error;
			def totalTestCasesSkiped = skipped;
			int percentagePass = (passed/total)*100;
			int percentageFailAndError = ((failed+error)/total)*100;


			String mailBody = "";


			mailBody += "<HTML><BODY>";
			mailBody += "<p class=MsoNormal align=left style='text-align:left'><h3>Summary of Execution</h3></p>";
			mailBody += "<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width='50%'";
			mailBody += " style='width:70.0%;mso-cellspacing:0in;mso-yfti-tbllook:1184;mso-padding-alt:";
			mailBody += " 0in 0in 0in 0in'>";
			mailBody += "  <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>";
			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Module <o:p></o:p></b></p>";
			mailBody += "   </td>";
			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Total Test Cases <o:p></o:p></b></p>";
			mailBody += "   </td>";
			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Total Passed <o:p></o:p></b></p>";
			mailBody += "   </td>";
			mailBody += "  <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Total Failed <o:p></o:p></b></p>";
			mailBody += "   </td>";
			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Total Error <o:p></o:p></b></p>";
			mailBody += "   </td>";
			//			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			//			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Total Skipped <o:p></o:p></b></p>";
			//			mailBody += "   </td>";
			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b> %Pass Test Cases <o:p></o:p></b></p>";
			mailBody += "   </td>";

			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b> %Failed And Error <o:p></o:p></b></p>";
			mailBody += "   </td>";

			mailBody += "   <td style='background:lightblue;padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b> %Total Execution <o:p></o:p></b></p>";
			mailBody += "   </td>";

			mailBody += "  </tr>";
			mailBody += "  <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>";
			mailBody += "  <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "  <p class=MsoNormal align=center style='text-align:center'><b> Smoke Suite </b></p>";
			mailBody += "  </td>";
			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>" +totalNumberOfTestCases+"</b></p>";
			mailBody += "   </td>";
			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b><span  style='color:green'>"+totalTestCasesPassed+"</b></p>";
			mailBody += "   </td>";
			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b><span  style='color:red'>"+totalTestCasesFailed+"</span></b></p>";
			mailBody += "   </td>";
			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b><span  style='color:orange'>"+totalError+"</span></b></p>";
			mailBody += "   </td>";
			//			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			//			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b><span  style='color:blueviolet'>"+totalTestCasesSkiped+"</span></b></p>";
			//			mailBody += "   </td>";

			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b><span  style='color:green'>"+percentagePass+" % </span></b></p>";
			mailBody += "   </td>";

			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b><span  style='color:red'>"+percentageFailAndError+" % </span></b></p>";
			mailBody += "   </td>";

			mailBody += "   <td style='padding:3.0pt 3.0pt 3.0pt 3.0pt'>";
			mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b> 100 % </b></p>";
			mailBody += "   </td>";

			mailBody += "  </tr>";
			mailBody += " </table><br>";


			if (!failedTCs.isEmpty()){
				mailBody += "<br><br><b><h3>Failed and Error Test Cases Details </h3></b>";

				//Failed Test Case table

				mailBody += "<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=5.0 width='70%'";
				mailBody += " style='width:90.0%;mso-cellspacing:0in;mso-yfti-tbllook:1184;mso-padding-alt:";
				mailBody += " 0in 0in 0in 0in'>";
				mailBody += "  <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>";
				mailBody += "   <td style='background:lightblue;padding:5.0pt 5.0pt 5.0pt 5.0pt'>";
				mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Serial_No <o:p></o:p></b></p>";
				mailBody += "   </td>";
				mailBody += "   <td style='background:lightblue;padding:5.0pt 5.0pt 5.0pt 5.0pt'>";
				mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Test_Case_ID <o:p></o:p></b></p>";
				mailBody += "   </td>";
				mailBody += "   <td style='background:lightblue;padding:5.0pt 5.0pt 5.0pt 5.0pt'>";
				mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Test_Case_Description <o:p></o:p></b></p>";
				mailBody += "   </td>";
				mailBody += "  <td style='background:lightblue;padding:5.0pt 5.0pt 5.0pt 5.0pt'>";
				mailBody += "   <p class=MsoNormal align=center style='text-align:center'><b>Error_Message <o:p></o:p></b></p>";
				mailBody += "   </td>";
				mailBody += "  </tr>"+iteratingFailedTestCases(failedTCs);
				mailBody +=	"</table><br>";

				//Failed Test Case table
			}
			mailBody += "<br><br><b>Please contact QA Team for any queries.</b><br>";
			mailBody += "<b>Contact mail IDs : akumari@AIENTERPRISE.COM </b><br>";
			mailBody += "<br><br></BODY></HTML>";


			MimeBodyPart emailText = new MimeBodyPart();

			emailText.setContent(mailBody, "text/html");

			// Adding Attachment to the Mail

			MimeBodyPart bodyPart = new MimeBodyPart();
			FileDataSource attachement = new FileDataSource("Extents//SmokeReport.html");
			bodyPart.setDataHandler(new DataHandler(attachement));
			bodyPart.setFileName(attachement.getName());

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyPart);
			multipart.addBodyPart(emailText);

			message.setContent(multipart);


			//send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {e.printStackTrace();}
	}
}