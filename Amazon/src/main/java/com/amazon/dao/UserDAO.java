package com.amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import com.amazon.model.User;

@Service
public class UserDAO extends AbstractDAO implements IUserDAO{

	private static final String INSERT_USER_SQL = "INSERT INTO users(user_name, email, password, isAdmin) VALUES (?, ?, md5(?), ?);";
	
	public boolean addUser(User user) {

		try {
			if (checkEmail(user.getEmail())) {
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setBoolean(4, false);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			sendEmail(user.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public String loginUser(User user) {
		try {
			if (checkUser(user)) {
				return "index";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "login";
	}

	public boolean checkEmail(String email) throws SQLException {
		String query = "SELECT email  FROM users WHERE email ='" + email + "'";
		ResultSet rs = null;
		try (Statement stmt = getConnection().createStatement()) {
			rs = stmt.executeQuery(query);
			return rs.first();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}

	}

	public boolean checkUser(User user) throws SQLException {
		String query = "SELECT email ,password FROM users WHERE email ='" + user.getEmail() + "' and password =MD5('"
				+ user.getPassword() + "');";
		ResultSet rs = null;
		try (Statement stmt = getConnection().createStatement()) {
			rs = stmt.executeQuery(query);
			return rs.next();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}

	public void sendEmail(String email) {

		final String username = "deniittalents@gmail.com";
		final String password = "ittalents";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("deniittalents@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Registration");
			message.setText("Your registration was successfull!");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
