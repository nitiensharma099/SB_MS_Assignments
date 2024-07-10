package com.nitienit.cards.repository;

import com.nitienit.cards.entites.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Cards, Long> {

    Optional<Cards> findByCardNo(String cardNo);

    @Transactional
    @Modifying
    void deleteByCardNo(String cardNo);
}
