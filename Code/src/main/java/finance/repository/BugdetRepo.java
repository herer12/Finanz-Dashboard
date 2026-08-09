package finance.repository;

import finance.model.Budget;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Budget.class)
public interface BugdetRepo {

    @SqlQuery("""
        SELECT id, categoryId, amountCents, year, month
        FROM "Bugdet"
        WHERE id = :id
        """)
    Optional<Budget> findById(@Bind("id") Long id);

    @SqlQuery("""
        SELECT id, categoryId, amountCents, year, month
        FROM "Bugdet"
        ORDER BY id
        """)
    List<Budget> findAll();

    @SqlUpdate("""
        INSERT INTO "Bugdet" (id, categoryId, amountCents, year, month)
        VALUES (:id, :categoryId, :amountCents, :year, :month)
        """)
    void save(
            @Bind("id") Long id,
            @Bind("categoryId") Long categoryId,
            @Bind("amountCents") Long amountCents,
            @Bind("year") int year,
            @Bind("month") int month
    );

    @SqlUpdate("""
        UPDATE "Bugdet"
        SET categoryId = :categoryId,
            amountCents = :amountCents,
            year = :year,
            month = :month
        WHERE id = :id
        """)
    boolean update(
            @Bind("id") Long id,
            @Bind("categoryId") Long categoryId,
            @Bind("amountCents") Long amountCents,
            @Bind("year") int year,
            @Bind("month") int month
    );

    @SqlUpdate("""
        DELETE FROM "Bugdet"
        WHERE id = :id
        """)
    boolean delete(@Bind("id") Long id);

}

