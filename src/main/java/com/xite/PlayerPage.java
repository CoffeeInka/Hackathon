package com.xite;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
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

    public static void pressUp() {
        player.sendKeys(Keys.ARROW_UP);
    }

    public static void pressRight() {
        player.sendKeys(Keys.ARROW_RIGHT);
    }

    public static void launchMVP(){
        open(url);
        prompting.shouldHave(text("Press Up to Like or Right to Skip"));
    }

    public static void likeSong(){
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);
        pressUp();
        likeIcon.should(appear);
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }

    public static void skipSong(){
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);
        pressRight();
        skipIcon.should(appear);
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }
}
