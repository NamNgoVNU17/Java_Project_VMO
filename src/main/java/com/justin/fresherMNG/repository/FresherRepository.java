package com.justin.fresherMNG.repository;

import com.justin.fresherMNG.entity.Fresher;
import com.justin.fresherMNG.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface FresherRepository extends JpaRepository<Fresher, Integer> {
    List<Fresher> findByNameContaining(String name);
    List<Fresher> findByProgrammingLanguage(String programmingLanguage);
    Fresher findByEmail(String email);

    @Query("SELECT f.center.name, COUNT(f) FROM Fresher f GROUP BY f.center.name")
    List<Object[]> countFresherByCenter();

    @Query("SELECT CASE " +
            "WHEN (f.score1 + f.score2 + f.score3) / 3 >= 8 THEN 'Excellent' " +
            "WHEN (f.score1 + f.score2 + f.score3) / 3 >= 6 THEN 'Good' " +
            "ELSE 'Average' END, COUNT(f) " +
            "FROM Fresher f " +
            "GROUP BY CASE " +
            "WHEN (f.score1 + f.score2 + f.score3) / 3 >= 8 THEN 'Excellent' " +
            "WHEN (f.score1 + f.score2 + f.score3) / 3 >= 6 THEN 'Good' " +
            "ELSE 'Average' END")
    List<Object[]> countFreshersByScore();



}
