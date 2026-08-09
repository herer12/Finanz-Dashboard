package finance.repository;

import finance.model.Expense;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Expense.class)
public interface ExpenseRepo {

        @SqlQuery("""
        SELECT id, categoryId, amountCents, description, expenseDate
        FROM "Expense"
        WHERE id = :id
        """)
        Optional<Expense> findById(@Bind("id") Long id);

        @SqlQuery("""
        SELECT id, categoryId, amountCents, description, expenseDate
        FROM "Expense"
        ORDER BY id
        """)
        List<Expense> findAll();

        @SqlUpdate("""
        INSERT INTO "Expense" (id, categoryId, amountCents, description, expenseDate)
        VALUES (:id, :categoryId, :amountCents, :description, :expenseDate)
        """)
        void save(
                @Bind("id") Long id,
                @Bind("categoryId") Long categoryId,
                @Bind("amountCents") Long amountCents,
                @Bind("description") int description,
                @Bind("expenseDate") LocalDate expenseDate
        );

        @SqlUpdate("""
        UPDATE "Expense"
        SET categoryId = :categoryId,
            amountCents = :amountCents,
            description = :description,
            expenseDate = :expenseDate
        WHERE id = :id
        """)
        boolean update(
                @Bind("id") Long id,
                @Bind("categoryId") Long categoryId,
                @Bind("amountCents") Long amountCents,
                @Bind("description") int description,
                @Bind("expenseDate") LocalDate expenseDate
        );

        @SqlUpdate("""
        DELETE FROM "Expense"
        WHERE id = :id
        """)
        boolean delete(@Bind("id") Long id);

}
