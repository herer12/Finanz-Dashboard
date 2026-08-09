package finance.repository;

import finance.model.Category;
import finance.model.SavingsGoal;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(SavingsGoal.class)
public interface SavingsGoalRepo {



        @SqlQuery("""
        SELECT id, name, targetAmountCents, currentAmountCents, targetDate
        FROM "Category"
        WHERE id = :id
        """)
        Optional<SavingsGoal> findById(@Bind("id") Long id);

        @SqlQuery("""
        SELECT id, name, targetAmountCents, currentAmountCents, targetDate
        FROM "Category"
        ORDER BY id
        """)
        List<SavingsGoal> findAll();

        @SqlUpdate("""
        INSERT INTO "Category" (id, name, targetAmountCents, currentAmountCents, targetDate)
        VALUES (:id, :name, :targetAmountCents, :currentAmountCents, :targetDate)
        """)
        void save(
                @Bind("id") Long id,
                @Bind("name") String name,
                @Bind("targetAmountCents") Long targetAmountCents,
                @Bind("currentAmountCents") Long currentAmountCents,
                @Bind("targetDate") LocalDate targetDate
        );

        @SqlUpdate("""
        UPDATE "Category"
        SET name = :name,
            targetAmountCents = :targetAmountCents,
            currentAmountCents = :currentAmountCents,
            targetDate = :targetDate
        WHERE id = :id
        """)
        boolean update(
                @Bind("id") Long id,
                @Bind("name") String name,
                @Bind("targetAmountCents") Long targetAmountCents,
                @Bind("currentAmountCents") Long currentAmountCents,
                @Bind("targetDate") LocalDate targetDate
        );

        @SqlUpdate("""
        DELETE FROM "Category"
        WHERE id = :id
        """)
        boolean delete(@Bind("id") Long id);


}
