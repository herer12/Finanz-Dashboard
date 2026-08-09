package finance.repository;
import finance.model.Category;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Category.class)
public interface CategoryRepo {

        @SqlQuery("""
        SELECT id, name, active
        FROM "Category"
        WHERE id = :id
        """)
        Optional<Category> findById(@Bind("id") Long id);

        @SqlQuery("""
        SELECT id, name, active
        FROM "Category"
        ORDER BY id
        """)
        List<Category> findAll();

        @SqlUpdate("""
        INSERT INTO "Category" (id, name, active)
        VALUES (:id, :name, :active)
        """)
        void save(
                @Bind("id") Long id,
                @Bind("name") String name,
                @Bind("active") boolean active
        );

        @SqlUpdate("""
        UPDATE "Category"
        SET name = :name,
            active = :active
        WHERE id = :id
        """)
        boolean update(
                @Bind("id") Long id,
                @Bind("name") String name,
                @Bind("active") boolean active
        );

        @SqlUpdate("""
        DELETE FROM "Category"
        WHERE id = :id
        """)
        boolean delete(@Bind("id") Long id);

}