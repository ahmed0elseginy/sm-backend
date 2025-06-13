package zag.library.security.api.service;

public interface SecurityService {

    String encryptPassword(String password);

    Boolean comparePasswords(String unHashedPassword, String hashedPassword);
}
