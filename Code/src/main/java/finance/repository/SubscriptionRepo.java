package finance.repository;

import finance.model.BillingCycle;
import finance.model.Category;
import finance.model.Subscription;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Subscription.class)
public interface SubscriptionRepo {




    @SqlQuery("""
        SELECT id, name, amountCents, billingCycle, nextPaymentDate, active
        FROM "Subscription"
        WHERE id = :id
        """)
    Optional<Subscription> findById(@Bind("id") Long id);

    @SqlQuery("""
        SELECT id, name, amountCents, billingCycle, nextPaymentDate, active
        FROM "Subscription"
        ORDER BY id
        """)
    List<Subscription> findAll();

    @SqlUpdate("""
        INSERT INTO "Subscription" (id, name, amountCents, billingCycle, nextPaymentDate, active)
        VALUES (:id, :name, :amountCents, :billingCycle, :nextPaymentDate, :active)
        """)
    void save(
            @Bind("id") Long id,
            @Bind("name") String name,
            @Bind("amountCents") Long amountCents,
            @Bind("billingCycle") Enum<BillingCycle> billingCycle,
            @Bind("nextPaymentDate") LocalDate nextPaymentDate,
            @Bind("active") boolean active
    );

    @SqlUpdate("""
        UPDATE "Subscription"
        SET name = :name,
            amountCents = :amountCents,
            billingCycle = :billingCycle,
            nextPaymentDate = :nextPaymentDate,
            active = :active  
        WHERE id = :id
        """)
    boolean update(
            @Bind("id") Long id,
            @Bind("name") String name,
            @Bind("amountCents") Long amountCents,
            @Bind("billingCycle") Enum<BillingCycle> billingCycle,
            @Bind("nextPaymentDate") LocalDate nextPaymentDate,
            @Bind("active") boolean active
    );

    @SqlUpdate("""
        DELETE FROM "Subscription"
        WHERE id = :id
        """)
    boolean delete(@Bind("id") Long id);
}
