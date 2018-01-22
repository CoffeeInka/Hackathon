package com.xite;


import com.codeborne.selenide.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MVPTest {

    @Before
    public void setUp() {
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
        Configuration.collectionsTimeout = 10000;
    }

    @Test
    public void launchMVPShowsWelcomeTextTest() {
        launchMVP();
        userMessage.shouldHave(text("First, please help us build user profiles by liking the videos you really like, and skipping the rest"));
    }

    @Test
    public void likeSongTest() {
        launchMVP();
        likeSong();
    }

    @Test
    public void skipSongTest() {
        launchMVP();
        skipSong();
    }

    @Test
    public void quizToResultSetTransitionTest(){
        launchMVP();
        //skip to 2nd
        likeSong();
        //skip to 3rd
        likeSong();
        //skip to 4th
        likeSong();
        //skip to 5th
        likeSong();
        //skip to 6th
        likeSong();
        //skip to 7th
        likeSong();
        //skip to 8th
        likeSong();
        //skip to 9th
        likeSong();
        //skip to 10th
        likeSong();

        //skip to 11th
        skipSong();
        //skip to 12th
        skipSong();
        //skip to 13th
        skipSong();
        //skip to 14th
        skipSong();
        //skip to 15th
        skipSong();
        //skip to 16th
        skipSong();
        //skip to 17th
        skipSong();
        //skip to 18th
        skipSong();
        //skip to 19th
        skipSong();
        //skip to 20th
        skipSong();

        userMessage.shouldHave(text("Your user profile is stored. In the next set of videos, please provide feedback by liking what you like, and skipping what you don’t!"));

    }

    public static String url = "";
    public static SelenideElement player = $("#video");
    public static SelenideElement userMessage;
    public static SelenideElement prompting;
    public static SelenideElement likeIcon;
    public static SelenideElement skipIcon;
    public static SelenideElement artistTitle;

    private static void pressUp() {
        player.sendKeys(Keys.ARROW_UP);
    }

    private static void pressRight() {
        player.sendKeys(Keys.ARROW_RIGHT);
    }

    private static void launchMVP(){
        open(url);
        prompting.shouldHave(text("Press Up to Like or Right to Skip"));
    }

    private static void likeSong(){
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);
        pressUp();
        likeIcon.should(appear);
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }

    private static void skipSong(){
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);
        pressRight();
        skipIcon.should(appear);
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }
}
