package project.streaming_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User controller for endpoinds")
public class UserController {

    private final UserService userService;

    @Operation(
            description = "In this endpoint we could buy subscription to watch " +
                    "content so we just need to put user id and type of sunscription " +
                    "which required for this user"
    )
    @PostMapping("/buySubscription/{id}")
    public void BuySubscription(@PathVariable Long id, @RequestBody BuySubscriptionDto buySubscriptionDto) {
        userService.buySubscription(id, buySubscriptionDto);
    }

    @Operation(
            description = "In this endpoint we could get information about subscription with id"
    )
    @GetMapping("/getSubscription/{id}")
    public SubscriptionDto getSubscription(@PathVariable Long id) {
        return userService.getSubscription(id);
    }

    @PutMapping("/cancelSubscription/{id}")
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
