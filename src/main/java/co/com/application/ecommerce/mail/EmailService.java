package co.com.application.ecommerce.mail;

public interface EmailService {

	void sendMessage(String to, String subject, String text);
}
