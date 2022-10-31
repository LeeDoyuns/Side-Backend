package com.project.backend.api.user.service.repository;

import com.project.backend.api.user.model.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Members,Long> {

    Members findByLoginIdAndPassword(String loginId, String password);

    @Query(value = "select m from members m where m.id = :id")
    Members querySelectMember(@Param("id") long userId);


    Optional<Members> findByLoginId(String loginId);

    Optional<Members> findBynickname(String nickname);
}
