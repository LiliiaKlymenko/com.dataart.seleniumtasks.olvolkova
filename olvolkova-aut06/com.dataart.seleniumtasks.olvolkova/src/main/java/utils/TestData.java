package utils;

import com.opencsv.bean.CsvToBeanBuilder;
import entities.Application;
import entities.User;
import org.apache.commons.lang3.RandomStringUtils;
import testdata.TestEnums;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TestData {
    
    public static User getValidUser() {
        return new User().withLogin("admin").withPassword("admin");
    }

    public static List<User> getUserListFromCSV() {
        String fileName = "src\\test\\resources\\users.csv";

        List<User> beans = null;
        try {
            beans = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(User.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return beans;
    }

    public static User getInvalidUser() {
        return new User().withLogin("invalidlogin").withPassword("invalidpassword");
    }

    public static User getUserForRegistration() {
        String password = RandomStringUtils.randomAlphabetic(6);
        return new User()
            .withLogin(RandomStringUtils.randomAlphabetic(6))
                .withFirstName(RandomStringUtils.randomAlphabetic(6))
                .withLastName(RandomStringUtils.randomAlphabetic(6))
                .withPassword(password)
                .withPasswordConfirm(password)
                .withUserRole(TestEnums.UserRole.DEVELOPER);
    }

    public static Application getDataForNewApp() { 
        return new Application()
            .withTitle(RandomStringUtils.randomAlphabetic(6))
            .withDescription(RandomStringUtils.randomAlphabetic(6));}

    public static Application newAppWithImage() { 
        return getDataForNewApp()
            .withImageData("C:\\Users\\olvolkova\\Desktop\\Course\\test1.jpg")
            .withIconData("C:\\Users\\olvolkova\\Desktop\\Course\\test1.jpg");}

}
