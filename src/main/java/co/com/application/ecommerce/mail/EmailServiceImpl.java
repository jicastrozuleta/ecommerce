package co.com.application.ecommerce.mail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {
	private static final Logger LOGGER=LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void sendMessage(String to, String subject, String text) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			emailSender.send(message);
		} catch (MailException exception) {
			LOGGER.error("context", exception);
		}
	}
}
