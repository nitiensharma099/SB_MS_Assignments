package com.nitienit.cards.service;

import com.nitienit.cards.dto.CardsDto;

public interface ICardService {

    CardsDto createCard(CardsDto cardsDto);

    CardsDto fetchCardDetails(String cardNo);

    CardsDto updateCardDetails(CardsDto cardsDto);

    boolean deleteCard(String cardNo);
}
