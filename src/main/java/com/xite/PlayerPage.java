package com.xite;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PlayerPage {
    public static String url = "localhost:8808";
    public static SelenideElement player = $("#video");
    public static SelenideElement userMessage = $("#user-message");
    public static SelenideElement prompting = $("#prompting");
    public static SelenideElement likeIcon = $("#like-icon");
    public static SelenideElement skipIcon = $("#kip-icon");
    public static SelenideElement artistTitle = $("#artist-title");
    public static SelenideElement score = $("#score");

    public static void pressUp() {
        player.sendKeys(Keys.ARROW_UP);
    }

    public static void pressRight() {
        player.sendKeys(Keys.ARROW_RIGHT);
    }

    public static void launchMVP() {
        open(url);
        prompting.shouldHave(text("Press Up to Like or Right to Skip"));
    }

    public static void likeSong() {
        pressUp();
        likeIcon.should(appear);
        likeIcon.waitUntil(disappears, 3000);
        artistTitle.waitUntil(visible, 3000);
    }

    public static void likeSong(int times) {
        for (int i = 0; i < times; i++) {
            pressUp();
            likeIcon.should(appear);
            likeIcon.waitUntil(disappears, 3000);
            artistTitle.waitUntil(visible, 3000);
        }
    }

    public static void skipSong() {
        pressRight();
        skipIcon.should(appear);
        skipIcon.waitUntil(disappears, 3000);
        artistTitle.waitUntil(visible, 3000);
    }

    public static void skipSong(int times) {
        for (int i = 0; i < times; i++) {
            pressRight();
            skipIcon.should(appear);
            skipIcon.waitUntil(disappears, 3000);
            artistTitle.waitUntil(visible, 3000);
        }
    }
}
