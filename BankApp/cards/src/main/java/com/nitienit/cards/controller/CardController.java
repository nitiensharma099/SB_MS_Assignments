package com.nitienit.cards.controller;

import com.nitienit.cards.dto.CardsDto;
import com.nitienit.cards.service.ICardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Slf4j
public class CardController {

    @Autowired
    private ICardService iCardService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CardsDto createCard(@RequestBody CardsDto cardsDto) {
        log.info("CardController :: createCard");
        return iCardService.createCard(cardsDto);
    }

    @GetMapping("/fetch/{cardNo}")
    public CardsDto fetchCardDetails(@PathVariable String cardNo) {
        log.info("CardController :: fetchCardDetails");
        return iCardService.fetchCardDetails(cardNo);
    }

    @PutMapping("/update")
    public CardsDto updateCardDetial(@RequestBody CardsDto cardsDto) {
        log.info("CardController :: updateCardDetial");
        return iCardService.updateCardDetails(cardsDto);

    }

    @DeleteMapping("/delete/{cardNo}")
    public boolean deleteCardDetail(@PathVariable String cardNo) {
        log.info("CardController :: deleteCardDetail");
        return iCardService.deleteCard(cardNo);
    }

}
