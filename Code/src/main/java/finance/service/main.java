package finance.service;

import finance.config.Settings;
import finance.model.Category;
import finance.repository.CategoryRepo;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) throws SQLException {
        Settings.initializeSettings();
        Connection connection = DriverManager.getConnection(Settings.getURL());
        Jdbi jdbi = Jdbi.create(connection);
        jdbi.installPlugin(new SqlObjectPlugin());
        CategoryRepo categoryRepository = jdbi.onDemand(CategoryRepo.class);


        List<Category> categories =
                categoryRepository.findAll();

        System.out.println(categories);


    }
}
