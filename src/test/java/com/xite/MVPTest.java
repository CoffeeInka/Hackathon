package com.xite;


import com.codeborne.selenide.*;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.xite.PlayerPage.*;

public class MVPTest {

    @Before
    public void setUp() {
        Configuration.timeout = 5000;
        Configuration.collectionsTimeout = 5000;
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;

    }

    @Test
    public void launchMVPShowsWelcomeTextTest() {
        launchMVP();
        userMessage.shouldHave(text("First, please help us build user profiles by liking the videos you really like, and skipping the rest"));
    }

    @Test
    public void likeSongTest() {
        launchMVP();
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);

        likeSong();
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }

    @Test
    public void skipSongTest() {
        launchMVP();
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);

        skipSong();
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }

    @Test
    public void quizToResultSetTransitionTest(){
        launchMVP();

        likeSong(10);
        skipSong(10);

        userMessage.shouldHave(text("Your user profile is stored. In the next set of videos, please provide feedback by liking what you like, and skipping what you don’t!"));
        artistTitle.shouldBe(visible);
        System.out.println(artistTitle.getText());
    }
}
