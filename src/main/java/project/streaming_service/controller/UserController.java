package project.streaming_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.streaming_service.dto.request.BuySubscriptionDto;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.response.SubscriptionDto;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/buySubscription/{id}")
    public void BuySubscription(@PathVariable Long id, @RequestBody BuySubscriptionDto buySubscriptionDto) {
        userService.buySubscription(id, buySubscriptionDto);
    }

    @GetMapping("/getSbscription/{id}")
    public SubscriptionDto getSubscription(@PathVariable Long id) {
        return userService.getSubscription(id);
    }

    @GetMapping("/cancelSubscription/{id}")
    public void cancelSubscription(@PathVariable Long id) {
        userService.cancelSubscription(id);
    }

    @GetMapping("/getHistories/{id}")
    public List<WatchHistoryDto> getAllHistories(@PathVariable Long id) {
        return userService.getAllHistories(id);
    }

    @GetMapping("/recommendation/{id}")
    public List<ContentDto> recommendation(@PathVariable Long id) {
       return userService.recommendation(id);
    }
}
