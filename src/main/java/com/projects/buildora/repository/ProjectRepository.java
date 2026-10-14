package com.projects.buildora.repository;

import com.projects.buildora.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query("""
           SELECT p FROM Project p
           WHERE p.deletedAt IS NULL
           ORDER BY p.updatedAt DESC
           """
    )
    List<Project> findAllAccessibleByUser(@Param("user_id") Long userId);


    @Query("""
            SELECT p From Project p
            WHERE p.id= :projectId
                AND p.deletedAt IS NULL
            """
    )
    Optional<Project> findAccessibleProjectById(@Param("projectId") Long projectId,
            @Param("userId") Long userId);



}
