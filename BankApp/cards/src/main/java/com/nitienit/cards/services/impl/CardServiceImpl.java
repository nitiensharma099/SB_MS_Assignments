package com.nitienit.cards.services.impl;

import com.nitienit.cards.dto.CardsDto;
import com.nitienit.cards.entites.Cards;
import com.nitienit.cards.exception.CardDetailsNotFoundException;
import com.nitienit.cards.repository.CardRepository;
import com.nitienit.cards.service.ICardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CardServiceImpl implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardsDto createCard(CardsDto cardsDto) {
        log.info("CardServiceImpl :: createCard {}", cardsDto.getCardNo());
        CardsDto savedCardDto = new CardsDto();
        Optional<Cards> dbcard = cardRepository.findByCardNo(cardsDto.getCardNo());
        log.info("CardServiceImpl :: dbcard.isEmpty() {}", dbcard.isEmpty());
        if (dbcard.isEmpty()) {
            Cards cards = new Cards();
            BeanUtils.copyProperties(cardsDto, cards);
            cardRepository.save(cards);
            BeanUtils.copyProperties(cards, savedCardDto);
        } else {
            //throw new CardDetailAlreadyPresentExcetpion("Card details already present ");
        }
        return savedCardDto;
    }

    @Override
    public CardsDto fetchCardDetails(String cardNo) {
        log.info("CardServiceImpl :: fetchCardDetails {}", cardNo);
        Cards dbcard = cardRepository.findByCardNo(cardNo).orElseThrow(() -> new CardDetailsNotFoundException("No card details with given card No" + cardNo));
        CardsDto dbcardDto = new CardsDto();
        BeanUtils.copyProperties(dbcard, dbcardDto);
        return dbcardDto;
    }

    @Override
    public CardsDto updateCardDetails(CardsDto cardsDto) {
        log.info("CardServiceImpl :: updateCardDetails {}", cardsDto.getCardNo());
        CardsDto savedCardDto = new CardsDto();
        Cards dbcard = cardRepository.findById(cardsDto.getCardId()).orElseThrow(() -> new CardDetailsNotFoundException("No card details with given card No"));
        log.info("CardServiceImpl :: dbcard {}", dbcard.getCardNo());
        BeanUtils.copyProperties(cardsDto, dbcard);
        cardRepository.save(dbcard);
        BeanUtils.copyProperties(dbcard, savedCardDto);
        return savedCardDto;
    }

    @Override
    public boolean deleteCard(String cardNo) {
        log.info("CardServiceImpl :: deleteCard {}", cardNo);
        Cards card = cardRepository.findByCardNo(cardNo).orElseThrow(() -> new CardDetailsNotFoundException("No card details available"));
        cardRepository.deleteByCardNo(card.getCardNo());
        log.info("CardServiceImpl :: deleteCard {}", cardNo);
        return true;
    }
}
