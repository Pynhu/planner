package net.javaguides.plan.repository;

import jakarta.transaction.Transactional;
import net.javaguides.plan.entity.Osobno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OsobnoRepository extends JpaRepository<Osobno,Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE plan", nativeQuery = true)
    void truncateTable();



}
