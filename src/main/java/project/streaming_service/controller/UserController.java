package project.streaming_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.streaming_service.dto.request.BuySubscriptionDto;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.response.SubscriptionDto;
import project.streaming_service.dto.response.UserDto;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "User-Controller ")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Creating new user",
            description = "In this endpoint new user created by default FREE subscription"
    )
    @PostMapping("/create")
    public void create(@RequestBody UserDto userDto) {
        userService.create(userDto);
    }

    @Operation(
            summary = "Updating profile of user",
            description = "in this endpoint we can update profile info of user" +
                    " by id "
    )
    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @Operation(
            summary = "Delete user",
            description = "In this endpoint we can delete user by user id "
    )
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @Operation(
            summary = "Get watched contents",
            description = "In this endpoint we can get watched contents of user by user id"
    )
    @GetMapping("/wathedContents/{id}")
    public List<ContentDto> getWatchingContents(@PathVariable Long id) {
        return userService.getWatchingContents(id);
    }

    @Operation(
            summary = "Buy subscription",
            description = "In this endpoint we could buy subscription to watch " +
                    "content so we just need to put user id and type of subscription " +
                    "which required for this user"
    )
    @PostMapping("/buySubscription/{id}")
    public void BuySubscription(@PathVariable Long id, @RequestBody BuySubscriptionDto buySubscriptionDto) {
        userService.buySubscription(id, buySubscriptionDto);
    }

    @Operation(
            summary = "Get subscription info",
            description = "In this endpoint we could get information about subscription with id"
    )
    @GetMapping("/getSubscription/{id}")
    public SubscriptionDto getSubscription(@PathVariable Long id) {
        return userService.getSubscription(id);
    }

    @Operation(
            summary = "Cancel subscription of user",
            description = "With this endpoint we can cancel the subscription of user with user id")
    @PutMapping("/cancelSubscription/{id}")
    public void cancelSubscription(@PathVariable Long id) {
        userService.cancelSubscription(id);
    }

    @Operation(
            summary = "Get histories of user",
            description = "In this endpoint we can get histories of user's watched and ongoing contents")
    @GetMapping("/getHistories/{id}")
    public List<WatchHistoryDto> getAllHistories(@PathVariable Long id) {
        return userService.getAllHistories(id);
    }

    @Operation(
            summary = "Get Recommendation of content",
            description = "In this endpoint we can get recommendation of content by putting user id " +
                    "so by this user id we get contents for this user")
    @GetMapping("/recommendation/{id}")
    public List<ContentDto> recommendation(@PathVariable Long id) {
        return userService.recommendation(id);
    }
}
